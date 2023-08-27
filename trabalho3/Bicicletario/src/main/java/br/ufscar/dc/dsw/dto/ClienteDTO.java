package br.ufscar.dc.dsw.dto;

public class ClienteDTO {
	   
	private Long id;
    private String cpf;
    private String telefone;
    private String genero;
    private String dataNasc;
    
    ClienteDTO(Long id, String cpf, String telefone, String genero, String dataNasc){
    	this.id = id;
    	this.cpf = cpf;
    	this.telefone = telefone;
    	this.genero = genero;
    	this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

}
