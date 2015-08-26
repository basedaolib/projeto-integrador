package br.com.belaAgenda.infra.resourceBundle;

import java.util.Locale;
import java.lang.ThreadLocal;

public class LocaleSafe {
	
	public static ThreadLocal<Locale> threadLocal = new ThreadLocal<Locale>();
	

	public static Locale getLocale() {

		return threadLocal.get();
	}

	public static void setLocale(Locale locale) {
		LocaleSafe.threadLocal.set( locale);
	}
	
	

}
