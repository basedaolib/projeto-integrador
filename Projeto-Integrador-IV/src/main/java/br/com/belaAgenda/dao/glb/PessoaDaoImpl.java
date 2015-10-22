package br.com.belaAgenda.dao.glb;

import br.com.belaAgenda.dao.glb.exceptions.PessoaDaoException;
import br.com.belaAgenda.infra.base.dao.ChaveValorDaoImpl;
import br.com.belaAgenda.model.glb.Pessoa;

public class PessoaDaoImpl<T extends Pessoa> extends ChaveValorDaoImpl<T> implements PessoaDao<T>{
	
	private static final long serialVersionUID = 2422108002556413034L;

	@Override
	protected T consist(T entity) {
		validarCPF(entity);
		validarRG(entity);
		return super.consist(entity);
	}
	
	private void validarCPF(T entity){
		String nome = this.<String>findFieldForProperties("nome", "pessoaFisica.cpf,id!=", 
				entity.getPessoaFisica().getCpf(), entity.getId());
		
		if(nome != null){
			throw new PessoaDaoException(getMessage("pessoaDao.cpfJaCadastrado"));
		}
	}
	
	private void validarRG(T entity){
		String nome = this.<String>findFieldForProperties("nome", "pessoaFisica.rg,pessoaFisica.orgaoExpedidor,id!=", 
				entity.getPessoaFisica().getCpf(), entity.getPessoaFisica().getOrgaoExpedidor() ,entity.getId());
		
		if(nome != null){
			throw new PessoaDaoException(getMessage("pessoaDao.rgJaCadastrado"));
		}
	}
	
	

}
