package DAO;

import java.util.List;

import ENTIDADES.ENDERECO;


public interface ENDERECODAO {
	
	//Inserir
	public void inserir(ENDERECO pessoa);
	//Lista
	public List<ENDERECO> listarPessoas();
	//Alteração
	public void alterar(ENDERECO pessoa);
	//Remoção pelo CPF que é a chave primária
	public void remover(int id_endereco);
	//Pequisar pelo id_pai que é a chave primária
	public ENDERECO pesquisar(String Rua);
	List<ENDERECO> ListarPessoas();

}