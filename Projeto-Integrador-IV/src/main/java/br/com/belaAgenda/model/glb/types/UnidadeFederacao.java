package br.com.belaAgenda.model.glb.types;

public enum UnidadeFederacao {
	AC(12,"ACRE"), AL(27,"ALAGOAS"), AM(13, "AMAZONAS"), AP(16, "AMAPA"), BA(29, "BAHIA"), CE(23, "CEARA"), DF(53, "DISTRITO FEDERAL"), 
	ES(32, "ESPIRITO SANTO"), GO(52, "GOIAS"), MA(21, "MARANHAO"), MG(31, "MINAS GERAIS"), MS(50, "MATO GROSSO DO SUL"), MT(51, "MATO GROSSO"), 
	PA(15, "PARA"), PB(25, "PARAIBA"), PE(26, "PERNAMBUCO"), PI(22, "PIAUI"), PR(41, "PARANA"), RJ(33, "RIO DE JANEIRO"), RN(24, "RIO GRANDE DO NORTE"),
	RO(11, "RONDONIA"), RR(14, "RORAIMA"), RS(43, "RIO GRANDE DO SUL"), SC(42, "SANTA CATARINA"), SE(28, "SERGIPE"), SP(35, "SAO PAULO"), 
	TO(17, "TOCANTINS");
	
	private Integer codigo; 
	private String nome;
	private String sigla;
	
	private UnidadeFederacao(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = toString();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
		
	public String getSigla() {
		return sigla;
	}

}
