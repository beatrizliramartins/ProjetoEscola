package VIEW;

import java.util.List;
import java.util.Scanner;

import DAO.PESSOADAO;
import DAO.PessoaDAOImpl;
import ENTIDADES.PESSOA;


public class Menu {

	public static void main(String[] args) {
		
		PESSOADAO pessoaDAO = new PessoaDAOImpl ();
		PESSOA pessoa = new PESSOA();
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		
		
		while(opcao != 10) {
			
			System.out.println("*********ESCOLA DO FUTURO*******\n"
								+ "Digite 1 para cadastrar aluno\n"
								+ "Digite 2 para listar aluno\n"
								+ "Digite 3 para Remover aluno\n"
								+ "Digite 4 para Alterar aluno\n"
								+ "Digite 5 para pesquisar aluno\n"
								+ "Digite 6 para cadastrar informações ao financeiro\n"
								+ "Digite 7 para listar seus dados no financeiro\n"
								+ "Digite 8 para alterar informações do financeiro\n"
								+ "Digite 9 para apagar informações do financeiro\n"
								+ "Digite 10 para sair do Menu\n"); 
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			
			case 1: 
				
				
				System.out.println("*******Cadastro******");
				System.out.println("Digite o nome:");
				pessoa.setNome(scan.nextLine());
				System.out.println("Digite a idade:");
				pessoa.setIdade(scan.nextInt());
				scan.nextLine();
				System.out.println("Digite o genero:");
				pessoa.setGenero(scan.nextLine());
				System.out.println("Digite o ID do Aluno:");
				pessoa.setId_aluno(scan.nextInt());
				System.out.println("Digite o nome do responsável:");
				pessoa.setNome_responsavel(scan.nextLine());
				scan.nextLine();
				System.out.println("Digite Status:");
				pessoa.setStatus(scan.nextLine());
				System.out.println("Digite o CPF:");
				pessoa.setCpf(scan.nextInt());
				scan.nextLine();
				System.out.println("Digite o Id_Endereco:");
				pessoa.setId_endereco(scan.nextInt());
				pessoaDAO.inserir(pessoa);
				
				break;
				
			case 2: 
				
				System.out.println("******Lista******");
				List<PESSOA> listaPessoas = pessoaDAO.listarPessoas();
				for (PESSOA p: listaPessoas) {
					System.out.println("***************");
					System.out.println("Nome:" +p.getNome());
					System.out.println("Idade" +p.getIdade());
					System.out.println("Genero:" +p.getGenero());
					System.out.println("Id do Aluno:" +p.getId_aluno());
					System.out.println("Status:" +p.getStatus());
					System.out.println("CPF:" +p.getCpf());
					System.out.println("Digite o Id_Endereço:" +p.getId_endereco());
					System.out.println("*****************");
					
				}
				break;
				
			case 3:
				
				System.out.println("********Remover*******");
				System.out.println("Digite o CPF:");
				pessoaDAO.remover(scan.nextLine());
				
				break; 
			case 4:
				

				System.out.println("******Alterar*******");
				System.out.println("CPF:");
				pessoa.setCpf(scan.nextInt());
				System.out.println("Nome:");
				pessoa.setNome(scan.nextLine());
				scan.nextLine();
				System.out.println("Idade:");
				pessoa.setIdade(scan.nextInt()); 
				scan.nextLine();
				System.out.println("Genero:");
				pessoa.setGenero(scan.nextLine());
				System.out.println("id_endereco:");
				pessoa.setId_endereco(scan.nextInt());
				System.out.println("Id_aluno:");
				pessoa.setId_aluno(scan.nextInt());
				pessoaDAO.alterar(pessoa);
				
				break;
			case 5:
				
				System.out.println("******Pesquisar*******");
				System.out.println("Digite o CPF:");
				pessoa = pessoaDAO.pesquisar(scan.nextLine());
				System.out.println("CPF:" +pessoa.getCpf());
				System.out.println("Nome:" +pessoa.getNome());
				System.out.println("Genero:" +pessoa.getGenero());
				System.out.println("Id_endereco:" +pessoa.getId_endereco());
				System.out.println("Id_Aluno::" +pessoa.getId_aluno());
				
				
				break;
				
			case 6: 
				
				System.out.println("*******Cadastro Financeiro******");
				System.out.println("Digite o nome:");
				pessoa.setNome(scan.nextLine());
				System.out.println("Digite a idade:");
				pessoa.setIdade(scan.nextInt());
				scan.nextLine();
				System.out.println("Digite o genero:");
				pessoa.setGenero(scan.nextLine());
				System.out.println("Digite o ID do Aluno:");
				pessoa.setId_aluno(scan.nextInt());
				System.out.println("Digite o nome do responsável:");
				pessoa.setNome_responsavel(scan.nextLine());
				scan.nextLine();
				System.out.println("Digite Status:");
				pessoa.setStatus(scan.nextLine());
				System.out.println("Digite o CPF:");
				pessoa.setCpf(scan.nextInt());
				scan.nextLine();
				System.out.println("Digite o Id_Endereco:");
				pessoa.setId_endereco(scan.nextInt());
				pessoaDAO.inserir(pessoa);
				
				
				
				break;
				
			case 7: 
				
				System.out.println("******Lista do Financeiro******");
				List<PESSOA> listaFinanceiro = pessoaDAO.listarPessoas();
				for (PESSOA p: listaFinanceiro) {
					System.out.println("***************");
					System.out.println("Nome:" +p.getNome());
					System.out.println("Id Aluno" +p.getId_aluno());
					System.out.println("Status de Pagamento:" +p.getStatus());
				}
				
				break;
				
			case 8: 
				
				System.out.println("******Alterar Financeiro*******");
				System.out.println("CPF:");
				scan.nextLine();
				System.out.println("Status de Pagamento:");
				pessoa.setStatus(scan.nextLine());
				System.out.println("Id_aluno:");
				pessoa.setId_aluno(scan.nextInt());
				pessoaDAO.alterar(pessoa);
				break;
				
			case 9: 
				
				System.out.println("********Remover do Financeiro*******");
				System.out.println("Digite o CPF:");
				pessoaDAO.remover(scan.nextLine());
				
				break;
			case 10:
				System.out.println( "Obrigada por estudar em nossa escola\n"
						+ "que a força esteja com você"); 
				break;
				default: System.out.println("Opção Inválida");
			}
		}
		if (opcao != 7) {
			System.out.println("Fazer outra operação em outro setor? \n 1- Sim\n 2- Não");
			opcao = scan.nextInt();
			
		}else {
			System.out.println("Volte Sempre!");
		}
		while (opcao == 1);
}
}
	
		
		
		