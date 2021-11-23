package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Enum;

public enum Situacao {

	AP("AP"),
	RP("RP"),
	FN("FN"),
	MT("MT"),
	RF("RF");
	
	private String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
		
}