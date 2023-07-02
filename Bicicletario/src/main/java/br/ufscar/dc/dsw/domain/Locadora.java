package br.ufscar.dc.dsw.domain;

public class Locadora {
    private String cnpj;
    private String descricao;
    private String cidade;

    //Construtor da classe
    public Locadora(String cnpj){
        this.cnpj = cnpj;
    }

    public Locadora(String cnpj, String desc, String cidade){
        this.cnpj = cnpj;
        this.descricao = desc;
        this.cidade = cidade;
    }

    //Metodos gets e sets da classe
    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }

    public String getCidade(){
        return this.cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
}
