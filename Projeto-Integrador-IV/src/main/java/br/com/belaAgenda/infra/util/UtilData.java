package br.com.belaAgenda.infra.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilData {
	
	private static DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static String formatarData(LocalDateTime data){
		return dateTimeFormatter.format(data);
	}
	
	public static String formatarData(LocalDate data){
		return dateFormatter.format(data);
	}

}
