package br.ufscar.dc.dsw.domain;

//import java.time.LocalDate;

public class Cliente extends Usuario{

	private String cpf;
	private String telefone;
	private String sexo;
	//private LocalDate nascimento;
	private String nascimento;

	public Cliente(String cpf, String telefone, String sexo, String nascimento, String email, String senha, String papel, String nome) {
		super(cpf, email, senha, papel, nome);
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.nascimento = nascimento;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
}