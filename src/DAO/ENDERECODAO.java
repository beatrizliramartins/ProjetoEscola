package DAO;

import java.util.List;

import ENTIDADES.ENDERECO;


public interface ENDERECODAO {
	
	//Inserir
	public void inserir(ENDERECO pessoa);
	//Lista
	public List<ENDERECO> listarPessoas();
	//Altera��o
	public void alterar(ENDERECO pessoa);
	//Remo��o pelo CPF que � a chave prim�ria
	public void remover(int id_endereco);
	//Pequisar pelo id_pai que � a chave prim�ria
	public ENDERECO pesquisar(String Rua);
	List<ENDERECO> ListarPessoas();

}