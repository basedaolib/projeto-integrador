package br.com.belaAgenda.business.sys;

import javax.inject.Named;

import br.com.belaAgenda.dao.sys.UsuarioDao;
import br.com.belaAgenda.infra.base.business.BaseBusinessImpl;
import br.com.belaAgenda.model.sys.Usuario;

@Named
class UsuarioBusinessImpl extends BaseBusinessImpl<Usuario, UsuarioDao> implements UsuarioBusiness{

	private static final long serialVersionUID = 8222401020878299317L;
}
