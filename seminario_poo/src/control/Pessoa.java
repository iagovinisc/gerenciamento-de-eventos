package control;

abstract class Pessoa {
	private int id, telefone;
    private String nome, email, senha;
    
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected int getTelefone() {
		return telefone;
	}
	protected void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getSenha() {
		return senha;
	}
	protected void setSenha(String senha) {
		this.senha = senha;
	}
}
