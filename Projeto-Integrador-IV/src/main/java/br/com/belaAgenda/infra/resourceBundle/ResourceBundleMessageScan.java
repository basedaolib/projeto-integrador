package br.com.belaAgenda.infra.resourceBundle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResourceBundleMessageScan {
	
	private static String uri = ResourceBundleMessageScan.class.getResource("").toString().substring(0,  ResourceBundleMessageScan.class.getResource("").toString().indexOf("/br")).replace("file:", "");
	
	public static List<String> listarArquivos(){
		return listarArquivos(new File(uri));
	}
	
	private static List<String> listarArquivos(File file){
		List<String> lista = new ArrayList<String>();
		File[] arquivos = file.listFiles();
		String nome;
		for(File item : arquivos){
			if(!item.isDirectory()){
				if(item.getName().contains(".properties")){
					nome = item.getPath().substring(item.getPath().indexOf("br"));
					nome = nome.replace("/", ".");
					nome = nome.replace("\\", ".");
					nome = nome.replace(".properties", "");
					
					lista.add(nome);
				}
			}else{
				lista.addAll(listarArquivos(item));
			}
		}
		return lista;
	}
}
