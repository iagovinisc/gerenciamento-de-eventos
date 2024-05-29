package model;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.Organizador;

public class OrganizadorDAO {
	Conexao conn = new Conexao();
	PreparedStatement ps = null;
	
	public void cadastrarOrg(Organizador org) {
		String consulta = "INSERT INTO tb_organizador(nome, email, telefone) VALUES (?, ?, ?)";
		
		try {
			ps = conn.conexao().prepareStatement(consulta);
			ps.setString(1, org.getNome());
			ps.setString(2, org.getEmail());
			ps.setString(3, org.getTelefone());
			ps.execute();
			System.out.println("dados enviados");
			
			conn.desconectar(conn.conexao());
			
		}catch(SQLException erro) {
			System.out.println("dados não enviados "+erro.getMessage()+"\n");
		}
	}
	
}
