package br.com.belaAgenda.controller.svc;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.com.belaAgenda.business.svc.ServicoBusiness;
import br.com.belaAgenda.model.svc.Servico;

@FacesConverter(value = "servicoConverter")
public class ServicoConverter implements javax.faces.convert.Converter {

    private ServicoBusiness  servicoBusiness;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        servicoBusiness = (ServicoBusiness) CDI.current().select(ServicoBusiness.class).get();
        return servicoBusiness.searchEntity().eq("nome", value).search();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Servico)value).getNome() ;
    }

}