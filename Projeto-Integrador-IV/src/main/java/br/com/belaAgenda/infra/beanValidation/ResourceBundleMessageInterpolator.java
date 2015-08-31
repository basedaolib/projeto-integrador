package br.com.belaAgenda.infra.beanValidation;


import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;

import br.com.belaAgenda.infra.resourceBundle.ResourceBundleMessageScan;


public class ResourceBundleMessageInterpolator extends org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator{
	
	
	
	public ResourceBundleMessageInterpolator() {
		this(new  AggregateResourceBundleLocator( ResourceBundleMessageScan.listarArquivos()));
		
	}
	
	public ResourceBundleMessageInterpolator(ResourceBundleLocator defaultResourceBundleLocator) {
		this(defaultResourceBundleLocator, true);
	}


	public ResourceBundleMessageInterpolator(ResourceBundleLocator testResourceBundleLocator, boolean cachingEnabled) {
		super(testResourceBundleLocator, cachingEnabled);
	}

	
	
	
}