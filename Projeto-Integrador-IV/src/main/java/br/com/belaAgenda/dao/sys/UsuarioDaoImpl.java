package br.com.belaAgenda.dao.sys;

import br.com.belaAgenda.dao.sys.exceptions.UsuarioDaoException;
import br.com.belaAgenda.infra.base.dao.ChaveValorDaoImpl;
import br.com.belaAgenda.model.sys.Usuario;

class UsuarioDaoImpl extends ChaveValorDaoImpl<Usuario> implements UsuarioDao {
	
	@Override
	protected Usuario consist(Usuario entity) {
		String login = this.<String>findFieldForProperties("login", "login,id!=", entity.getLogin(), entity.getId());
		
		if(login != null){
			throw new UsuarioDaoException(getMessage("usuarioDao.oLonginNaoPodeRepetir"));
		}
		
		return super.consist(entity);
	}
	
	
	
}
