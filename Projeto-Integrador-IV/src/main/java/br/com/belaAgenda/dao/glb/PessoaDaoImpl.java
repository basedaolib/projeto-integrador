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
		String nome = this.<String>searchProperty("nome")
				.equal("pessoaFisica.cpf", entity.getPessoaFisica().getCpf())
				.notEqual("id", entity.getId())
				.search();
		
		if(nome != null){
			throw new PessoaDaoException(getMessage("pessoaDao.cpfJaCadastrado"));
		}
	}
	
	private void validarRG(T entity){
		String nome = this.<String>searchProperty("nome")
				.equal("pessoaFisica.rg", entity.getPessoaFisica().getRg())
				.equal("pessoaFisica.orgaoExpedidor", entity.getPessoaFisica().getOrgaoExpedidor())
				.notEqual("id", entity.getId())
				.search();
		
		if(nome != null){
			throw new PessoaDaoException(getMessage("pessoaDao.rgJaCadastrado"));
		}
	}
	
	

}
