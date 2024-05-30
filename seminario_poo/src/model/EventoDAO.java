package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Evento;

public class EventoDAO {
	Conexao conn = new Conexao();
	PreparedStatement ps = null;
		
	public boolean cadastrarEvento(Evento evento) throws SQLException{
		String inserir = "INSERT INTO tb_evento(nome, tipo_evento, data_evento, horario, localizacao) VALUES(?, ?, ?, ?, ?)";
		
		try { //insere os dados do evento na tabela evento
			ps = conn.conexao().prepareStatement(inserir, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, evento.getNome_evento());
			ps.setString(2, evento.getTipo_evento());
			ps.setString(3, evento.getData());
			ps.setString(4, evento.getHorario());
			ps.setString(5, evento.getLocal());
			ps.execute();
			System.out.println("Evento cadastrado\n");
			
			ResultSet rs = ps.getGeneratedKeys(); // pega a chave gerada		
			if(rs.next()) { // busca a chave ID_evento dentro da coluna
				int idEvento = rs.getInt(1);
				evento.setId_evento(idEvento); //envia o id para a classe evento.setId_evento
				System.out.println("id_evento capturado: "+idEvento);
			}else {
                System.out.println("id não capturado");
            }
			
			conn.desconectar(conn.conexao());
			
			return true;
			
		} 	catch (SQLException erro) {
			System.out.println("Erro ao enviar dados de evento "+erro.getMessage()+"\n");
			throw erro;
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

