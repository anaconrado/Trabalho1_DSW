package br.ufscar.dc.dsw.domain;

public class Locadora extends Usuario {

	private String cnpj;
	private String cidade;

	public Locadora(String cnpj){
		super(cnpj);
		this.cnpj = cnpj;
	}
	

	public Locadora(String cnpj, String cidade, String email, String senha, String papel, String nome) {
		super(cnpj, email, senha, papel, nome);
		this.cnpj = cnpj;
		this.cidade = cidade;
	}

	public Locadora(String cnpj, String cidade, String email, String papel, String nome) {
		super(cnpj, email, papel, nome);
		this.cnpj = cnpj;
		this.cidade = cidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}