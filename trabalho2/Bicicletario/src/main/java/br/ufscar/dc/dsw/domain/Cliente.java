package br.ufscar.dc.dsw.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCpf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {
    
    @NotBlank
	@UniqueCpf(message = "{CPF já cadastrado}")
	@Size(min = 3, max = 18, message = "{Size.cliente.CPF}")
    @Column(nullable = false, length = 45 )
    private String CPF;
    
    @Column(nullable = false, length = 64)
    private String telefone;
    
    @Column(nullable = false, length = 45)
    private String genero;
    
    @Column(nullable = false, length = 15)
    private String dataNasc;
	
	public String getCpf() {
		return CPF;
	}
	
	public void setCpf(String CPF) {
		this.CPF = CPF;
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