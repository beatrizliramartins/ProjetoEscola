package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.ENDERECO;
import ENTIDADES.PESSOA;
import UTIL.JdbcUtil;

public abstract class EnderecoDAOimpl implements ENDERECODAO {
	
	@Override 
	public void inserir (ENDERECO endereco) {
		
		String sql = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, ID_ENDERECO)"
				 + "VALUES (?,?,?,?)";
		
		Connection conexao = null; 
		
		try {
		//criada a conexao 
			conexao = JdbcUtil.getConexao();
			//Conversao de Strign sql em query sql 
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setInt(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId_endereco());
			
			ps.execute();
			ps.close();
			conexao.close();
			
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}	
	
	
	@Override 
	public List<ENDERECO> ListarPessoas() {
		
		String sql = "SELECT * FROM PESSOA";
		ArrayList<ENDERECO> listaPessoas = new ArrayList <ENDERECO>();
		
		Connection conexao;
		
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				PESSOA pessoa = new PESSOA();
				pessoa.setNome(res.getString("RUA"));
				pessoa.setIdade(res.getInt("NUMERO"));
				pessoa.setGenero(res.getString("COMPLEMENTO"));
				pessoa.setId_aluno(res.getInt("ID_ENDERECO"));
				
				listaPessoas.add(pessoa);
			}
			ps.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return listaPessoas;
}
	
	@Override 
	public void alterar (ENDERECO endereco) {
		
		String sql = "UPDATE PESSOA SET RUA = ?, NUMERO = ?, COMPLEMENTO = ?, ID_ENDERECO = ?"
				+"WHERE ID_ENDERECO = ?";
		
		Connection conexao;
		
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setInt(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId_endereco());
			
			
			ps.execute();
			conexao.close();
			ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override 
	public void remover (int id_endereco) {
		String sql = "DELETE FROM PESSOA WHERE ID_ENDERECO = ?";
		Connection conexao;
		
		try { 
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_endereco);
			ps.execute();
			ps.close();
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ENDERECO pesquisar (String rua) {
	 
		String sql = "SELECT * FROM WHERE RUA = ?";
		
		Connection conexao;
		PESSOA pessoa = new PESSOA();
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setString(3, pessoa.getGenero());
			ps.setInt(4, pessoa.getId_aluno());
			
			ps.execute();
			conexao.close();
			ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	}
