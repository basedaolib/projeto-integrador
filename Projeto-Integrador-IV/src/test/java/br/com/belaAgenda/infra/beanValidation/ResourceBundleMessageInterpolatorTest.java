package br.com.belaAgenda.infra.beanValidation;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class ResourceBundleMessageInterpolatorTest{

	@Test
	public void metodo() {
		System.out.println(ResourceBundleMessageInterpolator.class.getResource("").toString().substring(0, ResourceBundleMessageInterpolator.class.getResource("").toString().indexOf("br")));
		List<String> lista = ResourceBundleMessageInterpolator.listarArquivos(new File(ResourceBundleMessageInterpolator.class.getResource("").toString().substring(0, ResourceBundleMessageInterpolator.class.getResource("").toString().indexOf("br"))));
		for(String item : lista){
			System.out.println(item);
		}
	}


	
}
