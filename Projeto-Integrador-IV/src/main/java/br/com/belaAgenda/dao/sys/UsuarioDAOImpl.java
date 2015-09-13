package br.com.belaAgenda.dao.sys;

import javax.inject.Named;

import br.com.belaAgenda.infra.base.dao.ChaveValorDaoImpl;
import br.com.belaAgenda.model.sys.Usuario;

@Named
class UsuarioDAOImpl extends ChaveValorDaoImpl<Usuario> implements UsuarioDao {
}
