package br.ufscar.dc.dsw.domain;

public class Locacao {

	private Long id;
	private String status;
	private String data;
	private Float val;
	private Locadora locadora;
	private Cliente cliente;
	private Bicicleta bicicleta;

	public Locacao(Long id, String status, String data, Float val, Locadora locadora, Cliente cliente, Bicicleta bicicleta) {
		this.id = id;
		this.status = status;
		this.data = data;
		this.val = val;
		this.locadora = locadora;
		this.cliente = cliente;
		this.bicicleta = bicicleta;
	}

	public Locacao(String status, String data, Float val, String cnpj, String cpf, Bicicleta bicicleta) {
		super();
		this.status = status;
		this.data = data;
		this.val = val;
		this.locadora = locadora;
		this.cliente = cliente;
		this.bicicleta = bicicleta;
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

	public Locadora getLocadora() {
		return locadora;
	}
	
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCpf(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void Bicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
}