package br.com.belaAgenda.infra.resourceBundle.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceBundleAnnotation {
	
	String bundle();
	String name();

}
