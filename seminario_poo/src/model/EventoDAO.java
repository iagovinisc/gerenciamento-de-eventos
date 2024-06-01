package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Evento;

public class EventoDAO {

	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	
	// classe para comparar os dados inseridos com a tabela do banco de dados
	public boolean comparaDados(Evento evento) throws SQLException {
		String compara = "SELECT * FROM tb_evento WHERE id_evento > 0 AND data_evento = ? AND horario = ? AND localizacao = ?";
		try {
			ps = conn.conexao().prepareStatement(compara);
			
			ps.setString(1, evento.getData());
			ps.setString(2, evento.getHorario());
			ps.setString(3, evento.getLocal());
			
			ResultSet resultado = null;
			resultado = ps.executeQuery();
			if(resultado.next() == false){
				return true;
			} else {
				return false;
			}
			
		}catch(SQLException erro){
			System.out.println("Erro ao enviar dados de evento "+erro.getMessage()+"\n");
			throw erro;
			
		}
	}
		
	public boolean cadastrarEvento(Evento evento) throws SQLException{
		
		comparaDados(evento); //envia os dados para a comparação
		if (comparaDados(evento) == true){ // se o cadastro for permitido
			String inserir = "INSERT INTO tb_evento(nome, tipo_evento, data_evento, horario, localizacao) VALUES(?, ?, ?, ?, ?)";
		
			try { //insere os dados do evento na tabela evento
				ps = conn.conexao().prepareStatement(inserir);
				ps.setString(1, evento.getNome_evento());
				ps.setString(2, evento.getTipo_evento());
				ps.setString(3, evento.getData());
				ps.setString(4, evento.getHorario());
				ps.setString(5, evento.getLocal());
				ps.execute();
				System.out.println("Evento cadastrado\n");
		
				conn.desconectar(conn.conexao());
				
			} 	catch (SQLException erro) {
				System.out.println("Erro ao enviar dados de evento "+erro.getMessage()+"\n");
				throw erro;
			}
			
			return true; // condição de evento criado, retorna para View.AgendarEventos linha 212.
		
		} else {
			return false; // condição de de evento não criado, retorna para View.AgendarEventos linha 216.
		
		}
	}	
	
	public boolean editarEvento(Evento evento) throws SQLException {
		String consulta = "UPDATE tb_evento SET nome = ?, tipo_evento = ?, data_evento = ?, horario = ?, localizacao = ? WHERE nome = ?";
		
		try {
			ps = conn.conexao().prepareStatement(consulta);
			ps.setString(1, evento.getNome_evento());
			ps.setString(2, evento.getTipo_evento());
			ps.setString(3, evento.getData());
			ps.setString(4, evento.getHorario());
			ps.setString(5, evento.getLocal());
			ps.setString(6, evento.getNome_evento());
			ps.execute();
			System.out.println("dados alterados\n");
			conn.desconectar(conn.conexao());
			return true;
			
		}catch(SQLException erro){
			System.out.println("Erro ao alterar dados "+erro.getMessage()+"\n");
			throw erro;
		}
	}
	
	public boolean excluirEvento(Evento evento) throws SQLException {
		String consulta = "DELETE FROM tb_evento WHERE nome = ?";
		
		try {
			ps = conn.conexao().prepareStatement(consulta);
			ps.setString(1, evento.getNome_evento());
			ps.execute();
			System.out.println("Dados excluidos");
			conn.desconectar(conn.conexao());
			return true;
			
		}catch(SQLException erro){
			System.out.println("Erro ao excluir dados "+erro.getMessage()+"\n");
			throw erro;
		}
	}
}

