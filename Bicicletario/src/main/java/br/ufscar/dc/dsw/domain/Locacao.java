package br.ufscar.dc.dsw.domain;

public class Locacao {

	private Long id;
	private String status;
	private String data;
	private Float val;
	private String cnpj;
	private String cpf;
	private Bicicleta bicicleta;
	private Usuario usuario;

	public Locacao(Long id, String status, String data, Float val, String cnpj, String cpf, Bicicleta bicicleta, Usuario usuario) {
		this.id = id;
		this.status = status;
		this.data = data;
		this.val = val;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.bicicleta = bicicleta;
		this.usuario = usuario;
	}

	public Locacao(String status, String data, Float val, String cnpj, String cpf, Bicicleta bicicleta, Usuario usuario) {
		super();
		this.status = status;
		this.data = data;
		this.val = val;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.bicicleta = bicicleta;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Float getVal() {
		return val;
	}

	public void setVal(Float val) {
		this.val = val;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setLivro(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}