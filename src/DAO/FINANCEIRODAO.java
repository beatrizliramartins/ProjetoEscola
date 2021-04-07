package DAO;


import java.util.List;

import ENTIDADES.FINANCEIRO;


public interface FINANCEIRODAO {
	
	//Inserir
	public void inserir(FINANCEIRO pessoa);
	//Lista
	public List<FINANCEIRO> listarPessoas();
	//Alteração
	public void alterar(FINANCEIRO pessoa);
	//Remoção pelo CPF que é a chave primária
	public void remover(int id_pai);
	//Pequisar pelo id_pai que é a chave primária
	public FINANCEIRO pesquisar(int id_pai);
	FINANCEIRO pesquisar(String nome);

}
