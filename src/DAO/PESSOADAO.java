package DAO;

import java.util.List;

import ENTIDADES.FINANCEIRO;
import ENTIDADES.PESSOA;

public interface PESSOADAO {
	
	//Inserir
	public void inserir(PESSOA pessoa);
	//Lista
	public List<PESSOA> listarPessoas();
	//Altera��o
	public void alterar(PESSOA pessoa);
	//Remo��o pelo CPF que � a chave prim�ria
	public void remover(String cpf);
	//Pequisar pelo CPF que � a chave prim�ria
	public PESSOA pesquisar(String cpf);
	void inserir(FINANCEIRO pessoa);

}
