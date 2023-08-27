package br.ufscar.dc.dsw.dto;

public class LocadoraDTO {

	private Long id;
	private String cnpj;
    private String cidade;


    LocadoraDTO(Long id, String cnpj, String cidade){
    	this.id = id;
    	this.cnpj = cnpj;
    	this.cidade = cidade;    
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

}
