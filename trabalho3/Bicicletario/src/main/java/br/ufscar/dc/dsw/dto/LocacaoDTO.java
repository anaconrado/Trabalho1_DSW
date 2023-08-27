package br.ufscar.dc.dsw.dto;

import java.math.BigDecimal;

public class LocacaoDTO {
	private Long id;
	private String data;
	private BigDecimal valor;
	private ClienteDTO cliente;
	private LocadoraDTO locadora;

	public ClienteDTO getCliente() {
		return this.cliente;
	}
	public void setCliente(Long id, String cpf, String telefone, String genero, String dataNasc) {
		this.cliente = new ClienteDTO(id, cpf, telefone, genero, dataNasc);
	}

	public LocadoraDTO getLocadora() {
		return this.locadora;
	}
	public void setLocadora(Long id, String cnpj, String cidade) {
		this.locadora = new LocadoraDTO(id, cnpj, cidade);
	}
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

