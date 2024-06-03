package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Organizador;
import control.Evento;

public class OrganizadorDAO {
	
	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	
	
	private int id_evento;
	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	
	public boolean buscarIdEvento() throws SQLException {
		try {
			/*este comando mostra o ultimo valor da coluna id_evento na tabela eventos, é a 
			chave necessaria para cadastrar o organizador dentro do ultimo evento cadastrado*/
			String buscar = "SELECT * FROM tb_evento ORDER BY id_evento DESC LIMIT 1";
			
			ps = conn.conexao().prepareStatement(buscar);
			ResultSet resultado = ps.executeQuery(); // executa a consulta	
			if(resultado.next()) { // busca a ultima chave dentro da tabela id_evento
				int idEvento = resultado.getInt("id_evento"); // achou e armazena dentro da variavel idEvento
				setId_evento(idEvento); //envia a variavel id_evento para setIdEvento
				System.out.println("id_evento capturado: "+idEvento);
				return true;
			}else {
                System.out.println("id não capturado"); // se a consulta não achar o ultimo id_evento
                return false;
            }
			
		}catch(SQLException erro) {
			System.out.println("erro ao capturar chave"+erro.getMessage()+"\n");
			throw erro;
		}		
	}
	
	public boolean cadastrarOrg(Organizador org) throws SQLException {
		
		buscarIdEvento(); // primeiro executa o metodo de buscar id
		if(buscarIdEvento() == true) { //se achar o id do evento ele executa o cadastro
			
			try {
				String insere = "INSERT INTO tb_organizador(nome, email, cpf, telefone, endereco, id_evento) VALUES (?, ?, ?, ?, ?, ?)";
				//envia os dados para o banco na tabela organizador
				ps = conn.conexao().prepareStatement(insere);
				ps.setString(1, org.getNome());
				ps.setString(2, org.getEmail());
				ps.setInt(3, org.getCpf());
				ps.setString(4, org.getTelefone());
				ps.setString(5, org.getEndereco());
				ps.setInt(6, getId_evento()); //envia o id do evento pegando do get
				ps.execute();
				System.out.println("Organizador cadastrado");
				
				conn.desconectar(conn.conexao());
			
			}	catch(SQLException erro) {
				System.out.println("erro ao cadastrar organizador "+erro.getMessage()+"\n");
				throw erro;
			}
			return true;	
			
		}else {
			return false;
		}
	}
}

