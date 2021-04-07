package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.FINANCEIRO;
import ENTIDADES.PESSOA;
import UTIL.JdbcUtil;

public class FINANCEIRODAOImpl implements FINANCEIRODAO {
	
	@Override 
	public void inserir (FINANCEIRO financeiro) {
		
		String sql = "INSERT INTO FINANCEIRO (NOME, ID_PAI, STATUS_PAGAMENTO)"
				+ "VALUES (?,?,?)";
		
		Connection conexao = null;
		
		try {
			//Criada a abertura de conexao 
			conexao = JdbcUtil.getConexao();
			//Conversao de string sql em query sql 
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, financeiro.getNome());
			ps.setInt(2, financeiro.getId_pai());
			ps.setString(3, financeiro.getStatus_pagamento());
			
			ps.execute();
			ps.close();
			conexao.close();
					
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public List<FINANCEIRO> listarPessoas() {
		
		String sql = "SELECT * FROM PESSOA";
		List<PESSOA> listaPessoas = new ArrayList<PESSOA>();
		Connection conexao;
		
		try {
			//Criada a abertura de conexao 
			conexao = JdbcUtil.getConexao();
			//Conversao de string sql em query sql 
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				PESSOA pessoa = new PESSOA();
				pessoa.setNome(res.getString("NOME"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setGenero(res.getString("GENERO"));
				pessoa.setId_aluno(res.getInt("ID_ALUNO"));
				pessoa.setNome_responsavel(res.getString("NOME_RESPONSAVEL"));
				pessoa.setStatus(res.getString("STATUS"));
				pessoa.setCpf(res.getInt("CPF"));
				pessoa.setId_endereco(res.getInt("ID_ENDERECO"));
				
				listaPessoas.add(pessoa);
			}
			
			
			ps.execute();
			conexao.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override 
	public void alterar (FINANCEIRO financeiro) {
		
		String sql = "UPDATE PESSOA SET NOME = ?, ID_PAI = ?, STATUS_PAGAMENTO = ?"
				+"WHERE ID_PAI = ?";
		
		Connection conexao;
		
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, financeiro.getNome());
			ps.setInt(2, financeiro.getId_pai());
			ps.setString(3, financeiro.getStatus_pagamento());
			
			ps.execute();
			conexao.close();
			ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		

	@Override
	public void remover (int id_pai) {
		
		String sql = "DELETE FROM PESSOA WHERE ID_PAI = ?";
		Connection conexao;
		
		try { 
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_pai);
			ps.execute();
			ps.close();
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	@Override
	public FINANCEIRO pesquisar(String nome) {
		
		String sql = "SELECT * FROM WHERE ID_PAI = ?";
		Connection conexao;
		PESSOA pessoa = new PESSOA();
		
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				pessoa.setNome(res.getString("NOME"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setGenero(res.getString("GENERO"));
				pessoa.setId_aluno(res.getInt("ID_ALUNO"));
				pessoa.setNome_responsavel(res.getString("NOME_RESPONSAVEL"));
				pessoa.setStatus(res.getString("STATUS"));
				pessoa.setCpf(res.getInt("CPF"));
				pessoa.setId_endereco(res.getInt("ID_ENDERECO"));
			}
			ps.close();
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}
		return null;
		
	}

	@Override
	public FINANCEIRO pesquisar(int id_pai) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
	
	