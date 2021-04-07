package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.FINANCEIRO;
import ENTIDADES.PESSOA;
import UTIL.JdbcUtil;

public class  PessoaDAOImpl implements PESSOADAO {

	@Override
	public void inserir(PESSOA pessoa) {
		String sql = "INSERT INTO PESSOA (NOME, IDADE, GENERO, ID_ALUNO, NOME_RESPONSAVEL,STATUS, CPF, ID_ENDERECO)"
				     + "VALUES (?,?,?,?,?,?,?,?)";
				
				Connection conexao = null;
		
	try {
		//criada a abertura de conexao
		conexao = JdbcUtil.getConexao();
		//Conversao de string sql em query sql 
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, pessoa.getNome());
		ps.setDouble(2, pessoa.getIdade());
		ps.setString(3, pessoa.getGenero());
		ps.setInt(4, pessoa.getId_aluno());
		ps.setString(5, pessoa.getNome_responsavel());
		ps.setString(6, pessoa.getStatus());
		ps.setInt(7, pessoa.getCpf());
		ps.setInt(8, pessoa.getId_endereco());
	
		
		ps.execute();
		ps.close();
		conexao.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PESSOA> listarPessoas() {
		String sql = "SELECT * FROM PESSOA";
		List<PESSOA> listaPessoas = new ArrayList <PESSOA>();
		
		Connection conexao;
		
		try {
			conexao = JdbcUtil.getConexao();
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
			ps.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPessoas;
		
	}

	@Override
	public void alterar(PESSOA pessoa) {
		String sql = "UPDATE PESSOA SET NOME = ?, IDADE = ?, GENERO = ?, ID_ALUNO = ?, NOME_RESPONSAVEL = ?, STATUS = ? , CPF = ?, ID_ENDERECO = ? "
				+"WHERE CPF = ?";
		
		Connection conexao;
		
		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setString(3, pessoa.getGenero());
			ps.setInt(4, pessoa.getId_aluno());
			ps.setString(5, pessoa.getNome_responsavel());
			ps.setString(6, pessoa.getStatus());
			ps.setInt(7, pessoa.getCpf());
			ps.setInt(8, pessoa.getId_endereco());
			
			ps.execute();
			conexao.close();
			ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(String cpf) {
		String sql = "DELETE FROM PESSOA WHERE CPF = ?";
		Connection conexao;
		
		try { 
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.execute();
			ps.close();
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PESSOA pesquisar(String cpf) {
			String sql = "SELECT * FROM WHERE CPF = ?";
			
			Connection conexao;
			PESSOA pessoa = new PESSOA();
			try {
				conexao = JdbcUtil.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, pessoa.getNome());
				ps.setInt(2, pessoa.getIdade());
				ps.setString(3, pessoa.getGenero());
				ps.setInt(4, pessoa.getId_aluno());
				ps.setString(5, pessoa.getNome_responsavel());
				ps.setString(6, pessoa.getStatus());
				ps.setInt(7, pessoa.getCpf());
				ps.setInt(8, pessoa.getId_endereco());
				
				ps.execute();
				conexao.close();
				ps.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return pessoa;
			
		}


	@Override
	public void inserir(FINANCEIRO pessoa) {
		// TODO Auto-generated method stub
		
	}
}
