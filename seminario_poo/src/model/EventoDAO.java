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
	public boolean compararDados(Evento evento) throws SQLException {
		//cria uma consulta para achar a data, horario e local se ja tiver algum evento cadastrado
		String compara = "SELECT * FROM tb_evento WHERE id_evento > 0 AND data_evento = ? AND horario = ? AND localizacao = ?";
		try {
			ps = conn.conexao().prepareStatement(compara); 
			//envia os dados para procurar no banco
			ps.setString(1, evento.getData());
			ps.setString(2, evento.getHorario());
			ps.setString(3, evento.getLocal());
			
			// se não os dados inseridos, ele retorna um true e valida o cadastro do evento, pois esta vago 
			rs = ps.executeQuery();
			if(rs.next() == false){
				return true;
			//se ele achar, não autoriza o cadastro
			} else {
				return false;
			}
			
		}catch(SQLException erro){
			System.out.println("Erro ao enviar dados de evento "+erro.getMessage()+"\n");
			throw erro;
			
		}
	}
		
	public boolean cadastrarEvento(Evento evento) throws SQLException{
		
		if (compararDados(evento) == true){ // envia os dados para a comparação e entra nesse if se o cadastro for permitido
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
			if(compararDados(evento) == true) {
				
				//faz a consulta no banco para alterar os dados
				String consulta = "UPDATE tb_evento SET nome = ?, tipo_evento = ?, data_evento = ?, horario = ?, localizacao = ? WHERE id_evento = ?";
				
				try {
					//envia os dados para a alteração
					ps = conn.conexao().prepareStatement(consulta);
					ps.setString(1, evento.getNome_evento());
					ps.setString(2, evento.getTipo_evento());
					ps.setString(3, evento.getData());
					ps.setString(4, evento.getHorario());
					ps.setString(5, evento.getLocal());
					ps.setInt(6, evento.getId_evento());
					ps.executeUpdate();
					System.out.println("dados alterados\n");
					conn.desconectar(conn.conexao());
					return true;
					
				}catch(SQLException erro){
					System.out.println("Erro ao alterar dados "+erro.getMessage()+"\n");
					throw erro;
				}
			}else {
				return false;
			}
		}
	
	public boolean excluirEvento(int id_evento) throws SQLException {
		//para excluir evento e organizador com chaves estrangeiras, é preciso desativar as chaves estrangeiras
		String desativarChave = "SET FOREIGN_KEY_CHECKS = 0"; // comando para desativar as chaves
		String exclueOrg = "DELETE FROM tb_organizador WHERE id_evento = ?"; // comando para escluir organizador
		String ativarChave = "SET FOREIGN_KEY_CHECKS = 1"; // comando para ativar novamente as chaves
		String exclueEvento = "DELETE FROM tb_evento WHERE id_evento = ?"; // comando para excluir evento
		
		try {
			// desativa as chaves
			ps = conn.conexao().prepareStatement(desativarChave);
			ps.executeUpdate();
			
			//exclue o organizador
			ps = conn.conexao().prepareStatement(exclueOrg);
			ps.setInt(1, id_evento);
			ps.executeUpdate();
			
			//exclue o evento
			ps = conn.conexao().prepareStatement(exclueEvento);
			ps.setInt(1, id_evento);
			ps.executeUpdate();
			
			//ativa novamente as chaves estrangeiras
			ps = conn.conexao().prepareStatement(ativarChave);
			ps.executeUpdate();
			
			System.out.println("Dados excluidos");
			conn.desconectar(conn.conexao());
			
			return true;
			
		}catch(SQLException erro){
			System.out.println("Erro ao excluir dados "+erro.getMessage()+"\n");
			throw erro;
		}
	}
	
	public DefaultTableModel mostrarEventos() throws SQLException {
		
		//seleciona a tabela do banco de dados que sera consultada
		String consulta = "SELECT id_evento, nome AS evento_nome, tipo_evento, descricao, data_evento, horario, localizacao FROM tb_evento";
        DefaultTableModel tabela = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo", "Descricao", "Data", "Horario", "Local", "Organizador"}, 0);

        try {
        	// faz a consulta na ta baela
            ps = conn.conexao().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            
            while (rs.next()) { //percorre a tabela e envia os dados do banco para uma variavel
                int idEvento = rs.getInt("id_evento");
                String eventoNome = rs.getString("evento_nome");
                String tipoEvento = rs.getString("tipo_evento");
                String descricao = rs.getString("descricao");
                String dataEvento = rs.getString("data_evento");
                String horario = rs.getString("horario");
                String localizacao = rs.getString("localizacao");
                
                // cria a variavel orgNome para receber o nome do organizador
                String orgNome = null; 
                // cria uma consulta para achar o nome do organizador se baseando pelo id_evento
                String tbOrg = "SELECT nome FROM tb_organizador WHERE id_evento = ?";  
                try (PreparedStatement psOrg = conn.conexao().prepareStatement(tbOrg)) {
                    psOrg.setInt(1, idEvento); // envia o id_evento da linha 125, para achar o nome do organizador
                    try (ResultSet rsOrg = psOrg.executeQuery()) {
                        if (rsOrg.next()) {// faz a busca pelo id para achar o nome
                            orgNome = rsOrg.getString("nome"); // armazena o nome encontrado
                        }
                    }
                }
                
                // adiciona todas as variaveis em um vetor e envia para a tabela
                tabela.addRow(new Object[]{idEvento, eventoNome, tipoEvento, descricao, dataEvento, horario, localizacao, orgNome});
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao obter dados: " + erro.getMessage());
            throw erro;
        } 
        // desconecta do banco
        conn.desconectar(conn.conexao());
        
        //retorna a tabela para a interface
        return tabela;
    }
}

