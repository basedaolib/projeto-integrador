package br.com.belaAgenda.controller.sys.security;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

import br.com.belaAgenda.infra.base.controller.BaseBean;

@Named
@RequestScoped
public class LoginBean extends BaseBean{

	private static final long serialVersionUID = 4012405416366953134L;
	public static final String HOME_URL = "/pages/index.xhtml";
	public static final String LOGIN_URL = "/login.xhtml";
	private String login;
    private String senha;
    private boolean remember;
	
	public void logon(){
		
		 try {
	            SecurityUtils.getSubject().login(new UsernamePasswordToken(login, senha, remember));
	            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(
	            		(ServletRequest) facesContext.getExternalContext().getRequest());
	            
				facesContext.getExternalContext().redirect(
						savedRequest != null ? 
								savedRequest.getRequestUrl() : getContextPath() + HOME_URL);
	        }
	        catch (AuthenticationException e) {
	        	addMessage(null, FacesMessage.SEVERITY_FATAL ,
	        			getMessage("Unknown user, please try again"), null);
	            e.printStackTrace(); // TODO: logger.
	        }catch (IOException e) {
	        	addMessage(null, FacesMessage.SEVERITY_FATAL ,
	        			getMessage("Unknown user, please try again"), null);
	            e.printStackTrace(); // TODO: logger.
			}
	}
	

    public void logOut() throws IOException {

        SecurityUtils.getSubject().logout();
        facesContext.getExternalContext().invalidateSession();
        facesContext.getExternalContext().redirect( getContextPath() + LOGIN_URL);
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	private String getContextPath(){
		return ((ServletRequest) facesContext.getExternalContext()
				.getRequest()).getServletContext().getContextPath();
	}
	

}
