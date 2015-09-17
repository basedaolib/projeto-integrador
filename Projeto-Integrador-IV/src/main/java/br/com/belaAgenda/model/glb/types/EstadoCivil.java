package br.com.belaAgenda.model.glb.types;

public enum EstadoCivil {
	Solteiro, Casado, UniaoEstavel, Desquitado, Viuvo;
	
	public boolean contemConjugue(){
		if(this.equals(Casado) || this.equals(UniaoEstavel)){
			return true;
		}else{
			return false;
		}
	}
}
