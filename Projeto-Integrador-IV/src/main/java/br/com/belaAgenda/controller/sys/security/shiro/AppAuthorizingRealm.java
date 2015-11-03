package br.com.belaAgenda.controller.sys.security.shiro;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import br.com.belaAgenda.business.sys.UsuarioBusiness;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.model.sys.Usuario;

public class AppAuthorizingRealm extends AuthorizingRealm {

	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String login = (String) principals.fromRealm(getName()).iterator().next();
		Usuario usuario = usuarioBusiness.searchEntity()
				.equal("login", login)
				.equal("estado", EstadoEntidade.Ativo)
				.search();
		if(usuario != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Set<String> roles = new HashSet<String>();
			roles.add(usuario.getNivel().name());
			info.setRoles(roles);
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
		
		Usuario usuario = usuarioBusiness.searchEntity()
				.equal("login", usernamePasswordToken.getUsername())
				.search();
		
        if(usuario != null) {
             AuthenticationInfo info = new  SimpleAuthenticationInfo(usuario.getLogin(), usuario.getSenha(),getName());
             SimpleCredentialsMatcher cmatcher = new SimpleCredentialsMatcher();
             
              
             
             boolean credentialsMatch = cmatcher.doCredentialsMatch(token, info);
             if(credentialsMatch) {
                 return info;
             }
 
         }
         throw new AuthenticationException();
	}

}
