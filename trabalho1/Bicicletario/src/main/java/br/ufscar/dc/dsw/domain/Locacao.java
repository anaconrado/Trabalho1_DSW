package br.ufscar.dc.dsw.domain;

public class Locacao {

	private static Long ids = (long)0;
	private String id;
	private String data;
	private String val;
	private Locadora locadora;
	private Cliente cliente;
	private Bicicleta bicicleta;

	public Locacao(String data, String val, Locadora locadora, Cliente cliente, Bicicleta bicicleta) {
		ids++;
		this.id = String.valueOf(ids);
		this.data = data;
		this.val = val;
		this.locadora = locadora;
		this.cliente = cliente;
		this.bicicleta = bicicleta;
	}
	
	public Locacao(String id, String data, String val, Locadora locadora, Cliente cliente, Bicicleta bicicleta) {
		this.id = id;
		this.data = data;
		this.val = val;
		this.locadora = locadora;
		this.cliente = cliente;
		this.bicicleta = bicicleta;
	}

	public String getId() {
		return id;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
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