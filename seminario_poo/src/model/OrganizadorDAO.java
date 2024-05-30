package model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import control.Organizador;
import control.Evento;

public class OrganizadorDAO {
	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	
	public void cadastrarOrg(Evento evento) {
		Organizador organizador = new Organizador();
		String insere = "INSERT INTO tb_organizador(nome, email, telefone, id_evento) VALUES (?, ?, ?, ?)";
		
		//envia os dados para tb_organizador
		try {
			ps = conn.conexao().prepareStatement(insere);
			ps.setString(1, organizador.getNome());
			ps.setString(2, organizador.getEmail());
			ps.setString(3, organizador.getTelefone());
			ps.setInt(4, evento.getId_evento()); //envia o id do evento pegando de evento.getId_evento
			ps.execute();
			System.out.println("Organizador cadastrado");
			
			conn.desconectar(conn.conexao());
			
		}catch(SQLException erro) {
			System.out.println("erro ao cadastrar organizador "+erro.getMessage()+"\n");
		}
	}
	
}
