package br.com.belaAgenda.controller.sys.security.shiro;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;

@Named
public class ShiroCDIEnvironmentLoader extends EnvironmentLoaderListener {

	@Inject
	private AppAuthorizingRealm appAuthorizingRealm;
	

	
	@Override
	protected WebEnvironment createEnvironment(ServletContext pServletContext) {
		DefaultWebEnvironment environment = (DefaultWebEnvironment) super.createEnvironment(pServletContext);
		RealmSecurityManager securityManager = (RealmSecurityManager) environment.getSecurityManager();
		        
		securityManager.setRealm(appAuthorizingRealm);
		environment.setSecurityManager(securityManager);
		
		return environment;
	}

}
