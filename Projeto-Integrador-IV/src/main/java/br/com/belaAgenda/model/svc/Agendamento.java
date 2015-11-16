package br.com.belaAgenda.model.svc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import br.com.belaAgenda.infra.base.model.EntityId;
import br.com.belaAgenda.model.glb.Cliente;
import br.com.belaAgenda.model.rh.Funcionario;
import br.com.belaAgenda.model.svc.exceptions.AgendamentoException;
import br.com.belaAgenda.model.svc.type.StatusAgendamento;

@Entity
public class Agendamento extends EntityId {

	private static final long serialVersionUID = 7998457391157630937L;
	
	@NaturalId
	@NotNull
	private Long codigo;

	@NotNull(message="{agendamento.funcionarioObrigatorio}")
	@ManyToOne
	private Funcionario funcionario;
	
	@NotNull(message="{agendamento.clienteObrigatorio}")
	@ManyToOne
	private Cliente cliente;
	
	@NotNull(message="{agendamento.dataObrigatoria}")
	private LocalDateTime data;
	
	@NotNull(message="{agendamento.finalEstimadoObrigatorio}")
	private LocalDateTime finalEstimado;
	
	private LocalDateTime inicioAtendimento;
	
	private LocalDateTime finalAtendimento;
	
	private LocalDateTime dataCancelamento;
	
	@NotNull(message="{agendamento.statusObrigatorio}")
	@Enumerated(EnumType.STRING) 
	private StatusAgendamento status;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="agendamento_servico", 
    		joinColumns={
    				@JoinColumn(name="agendamento_id")}, 
    		inverseJoinColumns={
    				@JoinColumn(name="servico_id")})
	private List<Servico> servicos;

	
	@PrePersist
	private void preInsert(){
		consistirData();
		consistirFinalEstimado();
	}
	
	private void consistirData(){
		if(data.isBefore(LocalDateTime.now())){
			throw new AgendamentoException(getMessage("agendamento.dataMenorQueADataDeHj"));
		}
	}
	
	private void consistirFinalEstimado(){
		if(finalEstimado.isBefore(data)){
			throw new AgendamentoException(getMessage("agendamento.finalEstimadoMenorQueAData"));
		}
		
		if(finalEstimado.isBefore(LocalDateTime.now())){
			throw new AgendamentoException(getMessage("agendamento.finalEstimadoMenorQueADataHj"));
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public StatusAgendamento getStatus() {
		return status;
	}

	public void setStatus(StatusAgendamento status) {
		this.status = status;
	}

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public LocalDateTime getInicioAtendimento() {
		return inicioAtendimento;
	}


	public void setInicioAtendimento(LocalDateTime inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}


	public LocalDateTime getFinalAtendimento() {
		return finalAtendimento;
	}


	public void setFinalAtendimento(LocalDateTime finalAtendimento) {
		this.finalAtendimento = finalAtendimento;
	}


	public LocalDateTime getFinalEstimado() {
		return finalEstimado;
	}


	public void setFinalEstimado(LocalDateTime finalEstimado) {
		this.finalEstimado = finalEstimado;
	}


	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public List<Servico> getServicos() {
		return servicos = servicos == null? new ArrayList<Servico>() : servicos;
	}


	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
}
