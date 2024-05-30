package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection conexao() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/seminario?serverTimezone=America/Sao_Paulo";
		String user = "root";
		String senha = "";
		
		try {
			conn = DriverManager.getConnection(url,user,senha);
			System.out.println("\nBanco de dados conectado");
			
		}catch(SQLException erro){
			System.out.println("erro na classe de conexão " + erro.getMessage());
			
		}	
		return conn;
	}
	
	public void desconectar(Connection conn) {
	    try {
	        if (conn != null) {
	            conn.close();
	            System.out.println("Banco de dados desconectado\n");
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao desconectar: " + e.getMessage());
	    }
	}
}
