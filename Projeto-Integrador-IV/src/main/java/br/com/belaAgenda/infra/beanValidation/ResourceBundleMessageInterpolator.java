package br.com.belaAgenda.infra.beanValidation;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;


public class ResourceBundleMessageInterpolator extends org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator{
	
	private static String uri = ResourceBundleMessageInterpolator.class.getResource("").toString().substring(0,  ResourceBundleMessageInterpolator.class.getResource("").toString().indexOf("/br")).replace("file:", "");
	
	public ResourceBundleMessageInterpolator() {
		this(new  AggregateResourceBundleLocator( listarArquivos(new File(uri))));
		
	}
	
	public ResourceBundleMessageInterpolator(ResourceBundleLocator defaultResourceBundleLocator) {
		this(defaultResourceBundleLocator, true);
	}


	public ResourceBundleMessageInterpolator(ResourceBundleLocator testResourceBundleLocator, boolean cachingEnabled) {
		super(testResourceBundleLocator, cachingEnabled);
	}

	
	public static List<String> listarArquivos(File file){
		List<String> lista = new ArrayList<String>();
		File[] arquivos = file.listFiles();
		for(File item : arquivos){
			if(!item.isDirectory()){
				if(item.getName().contains(".properties")){
					lista.add(item.getPath().substring(item.getPath().indexOf("br")).replaceAll("/", ".").replace(".properties", ""));
				}
			}else{
				lista.addAll(listarArquivos(item));
			}
		}
		return lista;
	}
	
}