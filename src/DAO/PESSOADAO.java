package DAO;

import java.util.List;

import ENTIDADES.FINANCEIRO;
import ENTIDADES.PESSOA;

public interface PESSOADAO {
	
	//Inserir
	public void inserir(PESSOA pessoa);
	//Lista
	public List<PESSOA> listarPessoas();
	//Alteração
	public void alterar(PESSOA pessoa);
	//Remoção pelo CPF que é a chave primária
	public void remover(String cpf);
	//Pequisar pelo CPF que é a chave primária
	public PESSOA pesquisar(String cpf);
	void inserir(FINANCEIRO pessoa);

}
