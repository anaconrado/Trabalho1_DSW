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
		return this.id;
	}
	
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Locadora getLocadora() {
		return this.locadora;
	}
	
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Bicicleta getBicicleta() {
		return this.bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
}