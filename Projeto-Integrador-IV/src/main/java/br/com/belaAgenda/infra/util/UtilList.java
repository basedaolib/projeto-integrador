package br.com.belaAgenda.infra.util;

import java.util.List;

public class UtilList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean update(List list, Object arg1, Object arg2){
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == arg1){
				index = i;
				break;
			}
		}
		if(index == -1){
			return false;
		}
		
		list.set(index, arg2);
		return true;
		
	}

}
