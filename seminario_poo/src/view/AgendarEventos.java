package view;

import control.Evento;
import model.Conexao;
import model.EventoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AgendarEventos extends JFrame {

    private JPanel jPanel2;
    private JPanel jPanel1;
    private JButton jButton7;
    private JButton jButton18;
    private JButton jButton20;
    private JButton jButton21;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JButton criarEvento;
    private JFormattedTextField campoDescricao;
    private JFormattedTextField campoNome;
    private JFormattedTextField campoLocal;
    private JFormattedTextField campoHorario;
    private JFormattedTextField campoData;
    private JLabel lblDescrio;
    private JFormattedTextField campoTipo;

    public AgendarEventos() {
        initComponents();
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 212, 725);
        jButton7 = new JButton();
        jButton7.setBounds(0, 278, 223, 41);
        jButton18 = new JButton();
        jButton18.setBounds(0, 143, 223, 43);
        jButton20 = new JButton();
        jButton20.setBounds(0, 210, 223, 42);
        jButton21 = new JButton();
        jButton21.setBounds(0, 82, 223, 43);
        jLabel2 = new JLabel();
        jLabel2.setBounds(317, 29, 161, 27);
        jLabel1 = new JLabel();
        jLabel1.setBounds(317, 85, 118, 20);
        jLabel3 = new JLabel();
        jLabel3.setBounds(317, 149, 106, 20);
        jLabel4 = new JLabel();
        jLabel4.setBounds(576, 213, 52, 20);
        jLabel5 = new JLabel();
        jLabel5.setBounds(317, 213, 30, 20);
        jLabel6 = new JLabel();
        jLabel6.setBounds(317, 290, 34, 20);
        criarEvento = new JButton();
        criarEvento.setBounds(433, 378, 212, 36);
        campoDescricao = new JFormattedTextField();
        campoDescricao.setBackground(Color.WHITE);
        campoDescricao.setBounds(317, 175, 471, 28);
        campoNome = new JFormattedTextField();
        campoNome.setBackground(Color.WHITE);
        campoNome.setBounds(317, 111, 212, 28);
        campoLocal = new JFormattedTextField();
        campoLocal.setBackground(Color.WHITE);
        campoLocal.setBounds(317, 323, 471, 33);
        campoHorario = new JFormattedTextField();
        campoHorario.setBackground(Color.WHITE);
        campoHorario.setBounds(576, 243, 212, 28);
        campoData = new JFormattedTextField();
        campoData.setBackground(Color.WHITE);
        campoData.setBounds(317, 243, 212, 28);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setPreferredSize(new Dimension(709, 523));

        jPanel1.setBackground(new Color(9, 91, 176));

        jButton7.setBackground(new Color(36, 135, 219));
        jButton7.setFont(new Font("Segoe UI", Font.BOLD, 13));
        jButton7.setForeground(new Color(255, 255, 255));
        jButton7.setIcon(new ImageIcon(getClass().getResource("/view/icons/icons8-sair-26.png")));
        jButton7.setText(" Sair                        ");
        jButton7.setBorderPainted(false);
        jButton7.setHorizontalTextPosition(SwingConstants.RIGHT);

        jButton18.setBackground(new Color(36, 135, 219));
        jButton18.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton18.setForeground(new Color(255, 255, 255));
        jButton18.setIcon(new ImageIcon(getClass().getResource("/view/icons/iconizer-agenda.png")));
        jButton18.setText("Agendar evento  ");
        jButton18.setBorderPainted(false);
        jButton18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new Color(36, 135, 219));
        jButton20.setFont(new Font("Segoe UI", Font.BOLD, 13));
        jButton20.setForeground(new Color(255, 255, 255));
        jButton20.setIcon(new ImageIcon(getClass().getResource("/view/icons/iconizer-editar.png")));
        jButton20.setText("Gerenciar agendamentos  ");
        jButton20.setBorderPainted(false);
        jButton20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new Color(36, 135, 219));
        jButton21.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton21.setForeground(new Color(255, 255, 255));
        jButton21.setIcon(new ImageIcon(getClass().getResource("/view/icons/icons8-casa-64.png")));
        jButton21.setText(" Página inicial      ");
        jButton21.setBorderPainted(false);
        jButton21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel2.setForeground(new Color(9, 91, 176));
        jLabel2.setText("Agendar eventos");

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel1.setForeground(new Color(36, 135, 219));
        jLabel1.setText("Nome do evento");

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel3.setForeground(new Color(36, 135, 219));
        jLabel3.setText("Descrição");

        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel4.setForeground(new Color(36, 135, 219));
        jLabel4.setText("Horário");

        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel5.setForeground(new Color(36, 135, 219));
        jLabel5.setText("Data");

        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel6.setForeground(new Color(36, 135, 219));
        jLabel6.setText("Local");
        
        /*JLabel msg = new JLabel("aguardando");
        msg.setBounds(408, 434, 237, 36);
        msg.setForeground(SystemColor.textHighlight);
        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
        msg.setHorizontalAlignment(SwingConstants.CENTER);
*/
        criarEvento.setBackground(new Color(36, 135, 219));
        criarEvento.setFont(new Font("Segoe UI", Font.BOLD, 14));
        criarEvento.setForeground(new Color(255, 255, 255));
        criarEvento.setText("Criar agendamento");
        criarEvento.setBorderPainted(false);
        criarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                criarEventoActionPerformed(evt);
                
                EventoDAO eventoDAO = new EventoDAO();
                Evento evento = new Evento();
                Conexao conn = new Conexao();
                
                try {
                    evento.setNome_evento(campoNome.getText());
                    evento.setTipo_evento(campoDescricao.getText());
                    evento.setLocal(campoLocal.getText());
                    evento.setData(campoData.getText());
                    evento.setHorario(campoHorario.getText());
                                       
                    if(eventoDAO.cadastrarEvento(evento) == true) {
                    	JLabel msg = new JLabel("evento criado");
                        msg.setBounds(408, 434, 237, 36);
                        msg.setForeground(SystemColor.textHighlight);
                        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
                        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
                        msg.setHorizontalAlignment(SwingConstants.CENTER);
                        jPanel2.add(msg);
                    	
                    }else {
                    	JLabel msg = new JLabel("erro ao cadastrar");
                        msg.setBounds(408, 434, 237, 36);
                        msg.setForeground(SystemColor.textHighlight);
                        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
                        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
                        msg.setHorizontalAlignment(SwingConstants.CENTER);
                        jPanel2.add(msg);
                    }
                     
                } catch (NumberFormatException | SQLException erro) {
                    erro.printStackTrace();
                }
                //conn.desconectar(conn.conexao());
                
            }
        });

        campoDescricao.setForeground(new Color(36, 135, 219));
        campoDescricao.setHorizontalAlignment(JTextField.CENTER);

        campoNome.setForeground(Color.LIGHT_GRAY);
        campoNome.setHorizontalAlignment(JTextField.CENTER);

        campoLocal.setForeground(new Color(36, 135, 219));
        campoLocal.setHorizontalAlignment(JTextField.CENTER);

        campoHorario.setForeground(new Color(36, 135, 219));
        campoHorario.setHorizontalAlignment(JTextField.CENTER);

        campoData.setForeground(new Color(36, 135, 219));
        campoData.setHorizontalAlignment(JTextField.CENTER);
        
        

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);
        jPanel2.setLayout(null);
        jPanel2.add(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.add(jButton20);
        jPanel1.add(jButton7);
        jPanel1.add(jButton18);
        jPanel1.add(jButton21);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel4);
        jPanel2.add(criarEvento);
        jPanel2.add(campoHorario);
        jPanel2.add(campoData);
        jPanel2.add(campoLocal);
        jPanel2.add(campoDescricao);
        jPanel2.add(campoNome);
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel3);
        
        lblDescrio = new JLabel();
        lblDescrio.setText("Tipo de evento");
        lblDescrio.setForeground(new Color(36, 135, 219));
        lblDescrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblDescrio.setBounds(576, 85, 106, 20);
        jPanel2.add(lblDescrio);
        
        campoTipo = new JFormattedTextField();
        campoTipo.setHorizontalAlignment(SwingConstants.CENTER);
        campoTipo.setForeground(Color.LIGHT_GRAY);
        campoTipo.setBackground(Color.WHITE);
        campoTipo.setBounds(576, 115, 212, 28);
        jPanel2.add(campoTipo);
        
        String[] tipoEvento = { "Palestra", "Workshop", "Maratona", "Outros" };
        JComboBox comboBox = new JComboBox();

        pack();
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
        // Implementar a lógica para o botão jButton18, se necessário
    }

    private void jButton20ActionPerformed(ActionEvent evt) {
        // Implementar a lógica para o botão jButton20, se necessário
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
        // Implementar a lógica para o botão jButton21, se necessário
    }

    private void criarEventoActionPerformed(ActionEvent evt) {
        
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarEventos().setVisible(true);
            }
        });
    }
}