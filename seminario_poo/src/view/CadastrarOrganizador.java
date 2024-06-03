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

public class CadastrarOrganizador extends JFrame {

    private JPanel jPanel2;
    private JPanel jPanel1;
    private JButton botaoGerenciarAgendamentos;
    private JButton botaoAgendarEvento;
    private JButton botaoPaginainicial;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JButton adicionarOrganizador;
    private JFormattedTextField campoEmail;
    private JFormattedTextField campoEndereco;
    private JFormattedTextField campoTelefone;
    private JFormattedTextField campoCPF;
    private JLabel lblDescrio;
    private JFormattedTextField campoNome;
    private JButton botaoSair;

    public CadastrarOrganizador() {
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
        botaoGerenciarAgendamentos.setBounds(0, 211, 223, 41);
        botaoAgendarEvento = new JButton();
        botaoAgendarEvento.setBounds(0, 148, 223, 43);
        botaoPaginainicial = new JButton();
        botaoPaginainicial.setBounds(0, 82, 223, 43);
        jLabel2 = new JLabel();
        jLabel2.setBounds(317, 29, 316, 27);
        jLabel3 = new JLabel();
        jLabel3.setBounds(317, 149, 106, 20);
        jLabel4 = new JLabel();
        jLabel4.setBounds(576, 213, 90, 20);
        jLabel5 = new JLabel();
        jLabel5.setBounds(317, 213, 154, 20);
        jLabel6 = new JLabel();
        jLabel6.setBounds(317, 290, 132, 20);
        adicionarOrganizador = new JButton();
        adicionarOrganizador.setBounds(433, 378, 212, 36);
        campoEmail = new JFormattedTextField();
        campoEmail.setBounds(317, 175, 471, 28);
        campoEmail.setBackground(Color.WHITE);
        campoEndereco = new JFormattedTextField();
        campoEndereco.setBounds(317, 323, 471, 33);
        campoEndereco.setBackground(Color.WHITE);
        campoTelefone = new JFormattedTextField();
        campoTelefone.setBounds(576, 243, 212, 28);
        campoTelefone.setBackground(Color.WHITE);
        campoCPF = new JFormattedTextField();
        campoCPF.setBounds(317, 243, 212, 28);
        campoCPF.setBackground(Color.WHITE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setPreferredSize(new Dimension(709, 523));

        jPanel1.setBackground(new Color(9, 91, 176));

        botaoGerenciarAgendamentos.setBackground(new Color(36, 135, 219));
        botaoGerenciarAgendamentos.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoGerenciarAgendamentos.setForeground(new Color(255, 255, 255));
        botaoGerenciarAgendamentos.setIcon(new ImageIcon(CadastrarOrganizador.class.getResource("/view/icons/iconizer-editar.png")));
        botaoGerenciarAgendamentos.setText("Gerenciar agendamentos");
        botaoGerenciarAgendamentos.setBorderPainted(false);
        botaoGerenciarAgendamentos.setHorizontalTextPosition(SwingConstants.RIGHT);

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
        jLabel2.setText("Cadastrar Organizador do evento");

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel3.setForeground(new Color(36, 135, 219));
        jLabel3.setText("E-mail");

        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel4.setForeground(new Color(36, 135, 219));
        jLabel4.setText("Telefone");

        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel5.setForeground(new Color(36, 135, 219));
        jLabel5.setText("CPF(somente números)");

        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel6.setForeground(new Color(36, 135, 219));
        jLabel6.setText("Endereço (opcional)");

        adicionarOrganizador.setBackground(new Color(36, 135, 219));
        adicionarOrganizador.setFont(new Font("Segoe UI", Font.BOLD, 14));
        adicionarOrganizador.setForeground(new Color(255, 255, 255));
        adicionarOrganizador.setText("Adicionar organizador");
        adicionarOrganizador.setBorderPainted(false);
        adicionarOrganizador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                criarEventoActionPerformed(evt);
                
                Organizador org = new Organizador();
                OrganizadorDAO orgDAO = new OrganizadorDAO();
                              
                try {
					org.setNome(campoNome.getText());
					org.setEmail(campoEmail.getText());
					org.setCpf(Integer.parseInt(campoCPF.getText()));
					org.setTelefone(campoTelefone.getText());
					org.setEndereco(campoEndereco.getText());
						
					if(orgDAO.cadastrarOrg(org) == true) {		
						JOptionPane.showMessageDialog(null, "Organizador do evento cadastrado");
						new Paginainicial().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "erro ao cadastrar organizador");
						
					}
				} catch (NumberFormatException | SQLException e) {
					JOptionPane.showMessageDialog(null, "O campo CPF aceita apenas números");
					e.printStackTrace();
				}
                
                dispose(); 
            }
        });

        campoEmail.setForeground(new Color(36, 135, 219));
        campoEmail.setHorizontalAlignment(JTextField.CENTER);

        campoEndereco.setForeground(new Color(36, 135, 219));
        campoEndereco.setHorizontalAlignment(JTextField.CENTER);

        campoTelefone.setForeground(new Color(36, 135, 219));
        campoTelefone.setHorizontalAlignment(JTextField.CENTER);

        campoCPF.setForeground(new Color(36, 135, 219));
        campoCPF.setHorizontalAlignment(JTextField.CENTER);
        

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
        botaoSair.setIcon(new ImageIcon(CadastrarOrganizador.class.getResource("/view/icons/icons8-sair-26.png")));
        botaoSair.setText(" Sair                        ");
        botaoSair.setHorizontalTextPosition(SwingConstants.RIGHT);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoSair.setBorderPainted(false);
        botaoSair.setBackground(new Color(36, 135, 219));
        botaoSair.setBounds(0, 274, 223, 41);
        jPanel1.add(botaoSair);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel4);
        jPanel2.add(adicionarOrganizador);
        jPanel2.add(campoTelefone);
        jPanel2.add(campoCPF);
        jPanel2.add(campoEndereco);
        jPanel2.add(campoEmail);
        jPanel2.add(jLabel3);
        
        lblDescrio = new JLabel();
        lblDescrio.setBounds(317, 84, 178, 20);
        lblDescrio.setText("Nome do organizador");
        lblDescrio.setForeground(new Color(36, 135, 219));
        lblDescrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jPanel2.add(lblDescrio);
        
        campoNome = new JFormattedTextField();
        campoNome.setBounds(317, 111, 471, 28);
        campoNome.setHorizontalAlignment(SwingConstants.CENTER);
        campoNome.setForeground(Color.LIGHT_GRAY);
        campoNome.setBackground(Color.WHITE);
        jPanel2.add(campoNome);

        pack();
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
    	new AgendarEventos().setVisible(true);
    	dispose();
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
                new CadastrarOrganizador().setVisible(true);
            }
        });
    }
}