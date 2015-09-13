package br.com.belaAgenda.controller.sys.security;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;

import br.com.belaAgenda.infra.base.controller.BaseBean;

@Named
@RequestScoped
public class SecurityBean extends BaseBean {

	public boolean isRole(String... roles){
		List<String> rolesList = new ArrayList<String>();
		for(String role : roles){
			rolesList.add(role);
		}
		boolean ret = false; 
		for(boolean item : SecurityUtils.getSubject().hasRoles(rolesList)){
			ret = ret || item;
		}
		return ret;
	}

}
