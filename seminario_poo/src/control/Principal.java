package control;

import model.OrganizadorDAO;
import java.sql.SQLException;
import model.EventoDAO;
import view.Paginainicial;

public class Principal {

    public static void main(String[] args) throws SQLException {
    	Paginainicial iniciarTela = new Paginainicial();  	
    	iniciarTela.setVisible(true);
        
    }
}