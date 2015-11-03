package br.com.belaAgenda.dao.sys;

import br.com.belaAgenda.dao.sys.exceptions.UsuarioDaoException;
import br.com.belaAgenda.infra.base.dao.ChaveValorDaoImpl;
import br.com.belaAgenda.model.sys.Usuario;

class UsuarioDaoImpl extends ChaveValorDaoImpl<Usuario> implements UsuarioDao {
	
	private static final long serialVersionUID = 7014193426943195000L;

	@Override
	protected Usuario consist(Usuario entity) {
		String login = this.<String>searchProperty("login")
				.equal("login", entity.getLogin())
				.notEqual("id", entity.getId())
				.search();
		
		if(login != null){
			throw new UsuarioDaoException(getMessage("usuarioDao.oLonginNaoPodeRepetir"));
		}
		
		return super.consist(entity);
	}
	
	
	
}
