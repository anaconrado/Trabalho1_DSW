package br.ufscar.dc.dsw.domain;

public class Usuario {

	private String codigo;
	private String email;
	private String senha;
	private String papel;
	private String nome;

	public Usuario(String codigo) {
		this.codigo = codigo;
	}

	/*public Usuario(String codigo, String nome, String email, String senha, String papel) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}*/

	public Usuario(String codigo, String email, String senha, String papel, String nome) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.papel = papel;
		this.nome = nome;
	}

	public Usuario(String codigo, String email, String papel, String nome) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.papel = papel;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}