package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.Evento;

public class EventoDAO {
	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	
	
	public boolean cadastrarEvento(Evento evento) throws SQLException{
		String consulta = "INSERT INTO tb_evento(nome, tipo_evento, data_evento, horario, localizacao) VALUES(?, ?, ?, ?, ?)";
		
		try {
			ps = conn.conexao().prepareStatement(consulta);
			ps.setString(1, evento.getNome_evento());
			ps.setString(2, evento.getTipo_evento());
			ps.setString(3, evento.getData());
			ps.setString(4, evento.getHorario());
			ps.setString(5, evento.getLocal());
			ps.execute();
			System.out.println("dados enviados\n");
			conn.desconectar(conn.conexao());
			return true;
			
		}catch(SQLException erro) {
			System.out.println("Erro ao enviar dados "+erro.getMessage()+"\n");
			throw erro;
		}	
	}
}

