package control;
import model.OrganizadorDAO;
import java.sql.SQLException;
import model.EventoDAO;

public class Principal {

    public static void main(String[] args) throws SQLException {
        OrganizadorDAO orgDAO = new OrganizadorDAO();
        EventoDAO eventoDAO = new EventoDAO();
        Evento evento = new Evento();

        // Definindo os valores do evento
        evento.setNome_evento("hackaton");
        evento.setTipo_evento("programacao");
        evento.setData("10/07");
        evento.setHorario("14:00");
        evento.setLocal("ceuma");
        
        
        // Passa o objeto evento para cadastrarEvento
        eventoDAO.cadastrarEvento(evento);
        System.out.println("chave estrangeira enviada: " + evento.getId_evento());

        // Passa o mesmo objeto evento para cadastrarOrg
        orgDAO.cadastrarOrg(evento); // Passe o evento com o id setado
    }
}
