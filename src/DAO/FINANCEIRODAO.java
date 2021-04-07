package DAO;


import java.util.List;

import ENTIDADES.FINANCEIRO;


public interface FINANCEIRODAO {
	
	//Inserir
	public void inserir(FINANCEIRO pessoa);
	//Lista
	public List<FINANCEIRO> listarPessoas();
	//Altera��o
	public void alterar(FINANCEIRO pessoa);
	//Remo��o pelo CPF que � a chave prim�ria
	public void remover(int id_pai);
	//Pequisar pelo id_pai que � a chave prim�ria
	public FINANCEIRO pesquisar(int id_pai);
	FINANCEIRO pesquisar(String nome);

}
