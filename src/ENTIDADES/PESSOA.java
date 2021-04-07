package ENTIDADES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
public class PESSOA {
	
	@Id
	@Column(name="NOME", nullable = false)
	private String Nome;
	
	@Column(name = "IDADE", nullable = false)
	private int idade;
	
	@Column(name="GENERO", nullable = false)
	private String genero;
	
	@OneToMany
	@JoinColumn(name = "ID_ALUNO", referencedColumnName="ID_ALUNO", nullable = false)
	private int id_aluno;
	
	@Id
	@Column(name="Nome_Responsavel", nullable = false)
	private String nome_responsavel;
	
	@Id
	@Column(name="Status", nullable = false)
	private String status;
	
	@Column(name="CPF", nullable = false)
	private int cpf;
	
	@OneToMany
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName="ID_ENDERECO", nullable = false)
	private int id_endereco;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	
}
	