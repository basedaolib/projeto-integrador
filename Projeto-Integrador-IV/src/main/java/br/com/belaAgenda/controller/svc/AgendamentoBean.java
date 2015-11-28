package br.com.belaAgenda.controller.svc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.belaAgenda.business.svc.AgendamentoBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.util.UtilData;
import br.com.belaAgenda.infra.util.UtilList;
import br.com.belaAgenda.model.glb.Cliente;
import br.com.belaAgenda.model.rh.Funcionario;
import br.com.belaAgenda.model.svc.Agendamento;
import br.com.belaAgenda.model.svc.Servico;
import br.com.belaAgenda.model.svc.type.StatusAgendamento;
import br.com.generic.dao.SearchEntityListBuilder;

@Named
@ViewScoped
public class AgendamentoBean extends BaseBean {

    private static final long serialVersionUID = 5039419771488014150L;
    @Inject
    private AgendamentoBusiness agendamentoBusiness;

    private Agendamento agendamento = new Agendamento();

    private List<Agendamento> agendamentos;

    private List<Servico> servicos = new ArrayList<>();

    private List<Servico> servicosSelecionados = new ArrayList<>();

    private Long codigo;

    private LocalDateTime data;
    
    private LocalDateTime finalEstimado;

    public void adicionar() {
        agendamento = new Agendamento();
        servicos.clear();
        servicosSelecionados.clear();
    }

    public void clonar(Agendamento agendamento) {
        this.agendamento = (Agendamento) agendamento.clone();
    }

    public void salvar() {
        this.agendamento.setServicos(servicosSelecionados);
        this.agendamento = agendamentoBusiness.save(this.agendamento);

        addMessage(null, FacesMessage.SEVERITY_INFO, getMessage("agendamentoBean.agendamentoSalvo"), null);
        agendamentos.add(agendamento);
    }

    public void pesquisar() {
        SearchEntityListBuilder<Agendamento> builder = agendamentoBusiness.listEntities().sortBy("codigo");
        if(codigo != null && codigo != 0){
            builder = builder.equal("codigo", codigo);
        }
        
        if(data != null){
            builder = builder.greaterThanOrEqualTo("data", data);
        }
        
        if(finalEstimado != null){
            builder = builder.greaterThanOrEqualTo("finalEstimado", finalEstimado);
        }
        
        agendamentos = builder.list();

    }

    public void onClienteChosen(SelectEvent event) {
        agendamento.setCliente((Cliente) event.getObject());
    }

    public void onFuncionarioChosen(SelectEvent event) {
        Funcionario funcionario = (Funcionario) event.getObject();
        agendamento.setFuncionario(funcionario);
        servicos = funcionario.getServicos();
    }

    public void editar(Agendamento agendamento) {
        servicos.clear();
        servicos.addAll(agendamento.getFuncionario().getServicos());
        servicosSelecionados.clear();
        servicosSelecionados.addAll(agendamento.getServicos());
        this.agendamento = agendamento;
    }

    public void show(Agendamento agendamento) {
        this.agendamento = agendamento;
        this.servicos = agendamento.getFuncionario().getServicos();
        this.servicosSelecionados = agendamento.getServicos();
    }

    public void iniciarAtendimento() {
        this.agendamento = agendamentoBusiness.iniciarAtendimento(agendamento);
        UtilList.update(agendamentos, agendamento, this.agendamento);

    }

    public void terminarAtendimento() {
        this.agendamento = agendamentoBusiness.terminarAtendimento(agendamento);
        UtilList.update(agendamentos, agendamento, this.agendamento);
    }

    public void cancelarAtendimento() {
        this.agendamento = agendamentoBusiness.cancelarAtendimento(agendamento);
        UtilList.update(agendamentos, agendamento, this.agendamento);
    }

    public String obterTituloCadastro(Agendamento agendamento) {
        if (agendamento == null || (agendamento != null && agendamento.getId() == 0)) {
            return getMessage("global.novo");
        } else {
            return agendamento.getCodigo().toString() + " - " + UtilData.formatarData(agendamento.getData());
        }
    }

    public String obterDataFormatada(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        return UtilData.formatarData(localDateTime);

    }

    public boolean podeAtender() {
        return agendado();
    }

    public boolean podeCancelar() {
        return agendado() || emAtendimento();
    }

    public boolean podeFinalizar() {
        return emAtendimento();
    }

    public boolean emAtendimento() {
        return agendamento.getStatus() == StatusAgendamento.EN_ANDAMENTO;
    }

    public boolean agendado() {
        return agendamento.getStatus() == StatusAgendamento.AGENDADO;
    }

    public boolean cancelado() {
        return agendamento.getStatus() == StatusAgendamento.CANCELADO;
    }

    public boolean concluido() {
        return agendamento.getStatus() == StatusAgendamento.CONCLUIDO;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public List<Agendamento> getAgendamentos() {
        if (agendamentos == null) {
            agendamentos = listarProximosAgendamentos();
        }
        return agendamentos;
    }

    private List<Agendamento> listarProximosAgendamentos() {
        return agendamentoBusiness.listEntities().greaterThanOrEqualTo("data", LocalDateTime.now()).list();
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
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

    public LocalDateTime getFinalEstimado() {
        return finalEstimado;
    }

    public void setFinalEstimado(LocalDateTime finalEstimado) {
        this.finalEstimado = finalEstimado;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<Servico> getServicos() {
        return servicos;
    }
    
    public List<Servico> getServicosSelecionados() {
        return servicosSelecionados;
    }

    public void setServicosSelecionados(List<Servico> servicosSelecionados) {
        this.servicosSelecionados = servicosSelecionados;
    }
    
    public String obterStatus(Agendamento agendamento){
        return getMessage("agendamentoLabels." + agendamento.getStatus());
    }
}
