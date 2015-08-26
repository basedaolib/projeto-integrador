package br.com.belaAgenda.infra.resourceBundle;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


public class ResourceBundleFactory<T> {
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Produces
	public ResourceBundle<T>  create(InjectionPoint injectionPoint) {
	    ParameterizedType type = (ParameterizedType) injectionPoint.getType();
	    Class classe = (Class) type.getActualTypeArguments()[0];
	    return new ResourceBundle<T>(classe);
	  }

}
