package control;
import model.OrganizadorDAO;

public class Principal {

	public static void main(String[] args) {
		OrganizadorDAO orgDAO = new OrganizadorDAO();
		
		orgDAO.cadastrarOrg(null);
		
	}

}
