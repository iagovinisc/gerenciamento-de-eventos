package view;

import control.Evento;
import control.Organizador;
import model.Conexao;
import model.EventoDAO;
import model.OrganizadorDAO;

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
    private JButton botaoGerenciarAgendamentos;
    private JButton botaoAgendarEvento;
    private JButton botaoPaginainicial;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JButton criarAgendamento;
    private JFormattedTextField campoDescricao;
    private JFormattedTextField campoNome;
    private JFormattedTextField campoLocal;
    private JFormattedTextField campoHorario;
    private JFormattedTextField campoData;
    private JLabel lblDescrio;
    private JFormattedTextField campoTipo;
    private JButton botaoSair;

    public AgendarEventos() {
        initComponents();
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 212, 725);
        botaoGerenciarAgendamentos = new JButton();
        botaoGerenciarAgendamentos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	new GerenciarAgendamentos().setVisible(true);
            	dispose();
        	}
        });
        botaoGerenciarAgendamentos.setBounds(0, 210, 223, 41);
        botaoAgendarEvento = new JButton();
        botaoAgendarEvento.setBounds(0, 143, 223, 43);
        botaoPaginainicial = new JButton();
        botaoPaginainicial.setBounds(0, 76, 223, 43);
        jLabel2 = new JLabel();
        jLabel2.setBounds(317, 29, 161, 27);
        jLabel1 = new JLabel();
        jLabel1.setBounds(317, 85, 118, 20);
        jLabel3 = new JLabel();
        jLabel3.setBounds(317, 149, 106, 20);
        jLabel4 = new JLabel();
        jLabel4.setBounds(576, 213, 90, 20);
        jLabel5 = new JLabel();
        jLabel5.setBounds(317, 213, 90, 20);
        jLabel6 = new JLabel();
        jLabel6.setBounds(317, 290, 106, 20);
        criarAgendamento = new JButton();
        criarAgendamento.setIcon(new ImageIcon(AgendarEventos.class.getResource("/view/icons/icons8-forward-26.png")));
        criarAgendamento.setBounds(433, 378, 212, 36);
        campoDescricao = new JFormattedTextField();
        campoDescricao.setBounds(317, 175, 471, 28);
        campoDescricao.setBackground(Color.WHITE);
        campoNome = new JFormattedTextField();
        campoNome.setBounds(317, 111, 212, 28);
        campoNome.setBackground(Color.WHITE);
        campoLocal = new JFormattedTextField();
        campoLocal.setBounds(317, 323, 471, 33);
        campoLocal.setBackground(Color.WHITE);
        campoHorario = new JFormattedTextField();
        campoHorario.setBounds(576, 243, 212, 28);
        campoHorario.setBackground(Color.WHITE);
        campoData = new JFormattedTextField();
        campoData.setBounds(317, 243, 212, 28);
        campoData.setBackground(Color.WHITE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setPreferredSize(new Dimension(709, 523));

        jPanel1.setBackground(new Color(9, 91, 176));

        botaoGerenciarAgendamentos.setBackground(new Color(36, 135, 219));
        botaoGerenciarAgendamentos.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoGerenciarAgendamentos.setForeground(new Color(255, 255, 255));
        botaoGerenciarAgendamentos.setIcon(new ImageIcon(AgendarEventos.class.getResource("/view/icons/iconizer-editar.png")));
        botaoGerenciarAgendamentos.setText("Gerenciar agendamentos");
        botaoGerenciarAgendamentos.setBorderPainted(false);
        botaoGerenciarAgendamentos.setHorizontalTextPosition(SwingConstants.RIGHT);
        
        JLabel msg = new JLabel("evento criado");
        msg.setBounds(408, 434, 237, 36);
        msg.setForeground(SystemColor.textHighlight);
        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
        msg.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel msgerro = new JLabel("Outro evento ja existe");
        msg.setBounds(408, 434, 237, 36);
        msg.setForeground(SystemColor.textHighlight);
        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
        msg.setHorizontalAlignment(SwingConstants.CENTER);

        botaoAgendarEvento.setBackground(new Color(36, 135, 219));
        botaoAgendarEvento.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botaoAgendarEvento.setForeground(new Color(255, 255, 255));
        botaoAgendarEvento.setIcon(new ImageIcon(getClass().getResource("/view/icons/iconizer-agenda.png")));
        botaoAgendarEvento.setText("Agendar evento  ");
        botaoAgendarEvento.setBorderPainted(false);
        botaoAgendarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        botaoPaginainicial.setBackground(new Color(36, 135, 219));
        botaoPaginainicial.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botaoPaginainicial.setForeground(new Color(255, 255, 255));
        botaoPaginainicial.setIcon(new ImageIcon(getClass().getResource("/view/icons/icons8-casa-64.png")));
        botaoPaginainicial.setText(" Página inicial      ");
        botaoPaginainicial.setBorderPainted(false);
        botaoPaginainicial.addActionListener(new ActionListener() {
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
        
        criarAgendamento.setBackground(new Color(36, 135, 219));
        criarAgendamento.setFont(new Font("Segoe UI", Font.BOLD, 14));
        criarAgendamento.setForeground(new Color(255, 255, 255));
        criarAgendamento.setText("Avançar");
        criarAgendamento.setBorderPainted(false);
        criarAgendamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                criarEventoActionPerformed(evt);
                
          
                EventoDAO eventoDAO = new EventoDAO();
                Evento evento = new Evento();
                
                
                try {
                	
                	//captura os dados inseridos pelo usuario
                    evento.setNome_evento(campoNome.getText());
                    evento.setTipo_evento(campoTipo.getText());
                    evento.setDescricao(campoDescricao.getText());
                    evento.setLocal(campoLocal.getText());
                    evento.setData(campoData.getText());
                    evento.setHorario(campoHorario.getText());  
                    
                    //caso consiga cadasrar o evento
                    if(eventoDAO.cadastrarEvento(evento) == true) {
                    	new CadastrarOrganizador().setVisible(true);
                    	dispose();  
                    //caso não consiga
                    }else {
                        JOptionPane.showMessageDialog(null, "Já existe um evento cadastrado com a mesma data, hora e local, altere alguma dessas opções");
                    }
                     
                } catch (NumberFormatException | SQLException erro) {
                    erro.printStackTrace();
                } 
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
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);
        jPanel2.setLayout(null);
        jPanel2.add(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.add(botaoGerenciarAgendamentos);
        jPanel1.add(botaoAgendarEvento);
        jPanel1.add(botaoPaginainicial);
        
        botaoSair = new JButton();
        botaoSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	dispose();
                
        	}
        });
        botaoSair.setIcon(new ImageIcon(AgendarEventos.class.getResource("/view/icons/icons8-sair-26.png")));
        botaoSair.setText(" Sair                        ");
        botaoSair.setHorizontalTextPosition(SwingConstants.RIGHT);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoSair.setBorderPainted(false);
        botaoSair.setBackground(new Color(36, 135, 219));
        botaoSair.setBounds(0, 275, 223, 41);
        jPanel1.add(botaoSair);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel4);
        jPanel2.add(criarAgendamento);
        jPanel2.add(campoHorario);
        jPanel2.add(campoData);
        jPanel2.add(campoLocal);
        jPanel2.add(campoDescricao);
        jPanel2.add(campoNome);
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel3);
        
        lblDescrio = new JLabel();
        lblDescrio.setBounds(576, 85, 106, 20);
        lblDescrio.setText("Tipo de evento");
        lblDescrio.setForeground(new Color(36, 135, 219));
        lblDescrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jPanel2.add(lblDescrio);
        
        campoTipo = new JFormattedTextField();
        campoTipo.setBounds(576, 111, 212, 28);
        campoTipo.setHorizontalAlignment(SwingConstants.CENTER);
        campoTipo.setForeground(Color.LIGHT_GRAY);
        campoTipo.setBackground(Color.WHITE);
        jPanel2.add(campoTipo);
        

        pack();
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
        // Implementar a lógica para o botão jButton18, se necessário
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
       	new Paginainicial().setVisible(true);
    	dispose();
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
