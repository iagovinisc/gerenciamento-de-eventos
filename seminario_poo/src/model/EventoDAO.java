package model;

import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import control.Organizador;
import control.Evento;

public class EventoDAO {

	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// classe para comparar os dados inseridos com a tabela do banco de dados
	public boolean comparaDados(Evento evento) throws SQLException {
		String compara = "SELECT * FROM tb_evento WHERE id_evento > 0 AND data_evento = ? AND horario = ? AND localizacao = ?";
		try {
			ps = conn.conexao().prepareStatement(compara);
			
			ps.setString(1, evento.getData());
			ps.setString(2, evento.getHorario());
			ps.setString(3, evento.getLocal());

			rs = ps.executeQuery();
			if(rs.next() == false){
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
			String inserir = "INSERT INTO tb_evento(nome, tipo_evento, descricao, data_evento, horario, localizacao) VALUES(?, ?, ?, ?, ?, ?)";
		
			try { //insere os dados do evento na tabela evento
				ps = conn.conexao().prepareStatement(inserir);
				ps.setString(1, evento.getNome_evento());
				ps.setString(2, evento.getTipo_evento());
				ps.setString(3, evento.getDescricao());
				ps.setString(4, evento.getData());
				ps.setString(5, evento.getHorario());
				ps.setString(6, evento.getLocal());
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
	
	public DefaultTableModel mostrarEventos() throws SQLException {
		
		String consulta = "SELECT id_evento, nome AS evento_nome, tipo_evento, descricao, data_evento, horario, localizacao FROM tb_evento";
        DefaultTableModel tabela = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo", "Descricao", "Data", "Horario", "Local", "Organizador"}, 0);

        try {
            ps = conn.conexao().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idEvento = rs.getInt("id_evento");
                String eventoNome = rs.getString("evento_nome");
                String tipoEvento = rs.getString("tipo_evento");
                String descricao = rs.getString("descricao");
                String dataEvento = rs.getString("data_evento");
                String horario = rs.getString("horario");
                String localizacao = rs.getString("localizacao");
                
                String orgNome = null;
                String tbOrg = "SELECT nome FROM tb_organizador WHERE id_evento = ?";
                try (PreparedStatement psOrg = conn.conexao().prepareStatement(tbOrg)) {
                    psOrg.setInt(1, idEvento);
                    try (ResultSet rsOrg = psOrg.executeQuery()) {
                        if (rsOrg.next()) {
                            orgNome = rsOrg.getString("nome");
                        }
                    }
                }
                
                tabela.addRow(new Object[]{idEvento, eventoNome, tipoEvento, descricao, dataEvento, horario, localizacao, orgNome});
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao obter dados: " + erro.getMessage());
            throw erro;
        } 
        conn.desconectar(conn.conexao());

        return tabela;
    }
}

