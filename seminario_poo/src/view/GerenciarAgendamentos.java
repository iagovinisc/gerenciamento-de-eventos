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

public class GerenciarAgendamentos extends JFrame {

    private JPanel jPanel2;
    private JPanel jPanel1;
    private JButton botaoGerenciarAgendamentos;
    private JButton botaoAgendarEvento;
    private JButton botaoCadastrarOrganizador;
    private JButton botaoPaginainicial;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JButton salvarAlteracao;
    private JFormattedTextField campoDescricao;
    private JFormattedTextField campoLocal;
    private JFormattedTextField campoHorario;
    private JFormattedTextField campoData;
    private JLabel lblDescrio;
    private JButton botaoSair;
    private JButton btnNewButton;
    private JButton btnExcluir;
    private JComboBox comboBox;

    public GerenciarAgendamentos() {
        initComponents();
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 212, 725);
        botaoGerenciarAgendamentos = new JButton();
        botaoGerenciarAgendamentos.setBounds(0, 278, 223, 41);
        botaoAgendarEvento = new JButton();
        botaoAgendarEvento.setBounds(0, 143, 223, 43);
        botaoCadastrarOrganizador = new JButton();
        botaoCadastrarOrganizador.setBounds(0, 210, 223, 42);
        botaoPaginainicial = new JButton();
        botaoPaginainicial.setBounds(0, 82, 223, 43);
        jLabel2 = new JLabel();
        jLabel2.setBounds(317, 29, 328, 27);
        jLabel1 = new JLabel();
        jLabel1.setBounds(317, 85, 177, 20);
        jLabel3 = new JLabel();
        jLabel3.setBounds(317, 149, 128, 20);
        jLabel4 = new JLabel();
        jLabel4.setBounds(576, 213, 128, 20);
        jLabel5 = new JLabel();
        jLabel5.setBounds(317, 213, 90, 20);
        jLabel6 = new JLabel();
        jLabel6.setBounds(317, 290, 106, 20);
        salvarAlteracao = new JButton();
        salvarAlteracao.setBounds(433, 378, 212, 36);
        campoDescricao = new JFormattedTextField();
        campoDescricao.setBounds(317, 175, 471, 28);
        campoDescricao.setBackground(Color.WHITE);
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
        botaoGerenciarAgendamentos.setIcon(new ImageIcon(GerenciarAgendamentos.class.getResource("/view/icons/iconizer-editar.png")));
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

        botaoCadastrarOrganizador.setBackground(new Color(36, 135, 219));
        botaoCadastrarOrganizador.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoCadastrarOrganizador.setForeground(new Color(255, 255, 255));
        botaoCadastrarOrganizador.setIcon(new ImageIcon(GerenciarAgendamentos.class.getResource("/view/icons/icons8-usuário-50.png")));
        botaoCadastrarOrganizador.setText("Cadastrar organizador");
        botaoCadastrarOrganizador.setBorderPainted(false);
        botaoCadastrarOrganizador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton20ActionPerformed(evt);
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
        jLabel2.setText("Gerenciar Agendamentos");

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel1.setForeground(new Color(36, 135, 219));
        jLabel1.setText("Selecionar agendamento");

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel3.setForeground(new Color(36, 135, 219));
        jLabel3.setText("Alterar descrição");

        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel4.setForeground(new Color(36, 135, 219));
        jLabel4.setText("Alterar horário");

        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel5.setForeground(new Color(36, 135, 219));
        jLabel5.setText("Alterar data");

        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel6.setForeground(new Color(36, 135, 219));
        jLabel6.setText("Alterar local");
        
        /*JLabel msg = new JLabel("aguardando");
        msg.setBounds(408, 434, 237, 36);
        msg.setForeground(SystemColor.textHighlight);
        msg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        msg.setIcon(new ImageIcon("C:\\Users\\iagov\\Downloads\\sucesso (1).png"));
        msg.setHorizontalAlignment(SwingConstants.CENTER);
*/
        salvarAlteracao.setBackground(new Color(36, 135, 219));
        salvarAlteracao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salvarAlteracao.setForeground(new Color(255, 255, 255));
        salvarAlteracao.setText("Salvar");
        salvarAlteracao.setBorderPainted(false);
        salvarAlteracao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	new Paginainicial().setVisible(true);
            	dispose();
                criarEventoActionPerformed(evt);
                JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
                
            }
        });

        campoDescricao.setForeground(new Color(36, 135, 219));
        campoDescricao.setHorizontalAlignment(JTextField.CENTER);

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
        jPanel1.add(botaoCadastrarOrganizador);
        jPanel1.add(botaoGerenciarAgendamentos);
        jPanel1.add(botaoAgendarEvento);
        jPanel1.add(botaoPaginainicial);
        
        botaoSair = new JButton();
        botaoSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	new Paginainicial().setVisible(true);
            	dispose();
        	}
        });
        botaoSair.setIcon(new ImageIcon(GerenciarAgendamentos.class.getResource("/view/icons/icons8-sair-26.png")));
        botaoSair.setText(" Sair                        ");
        botaoSair.setHorizontalTextPosition(SwingConstants.RIGHT);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botaoSair.setBorderPainted(false);
        botaoSair.setBackground(new Color(36, 135, 219));
        botaoSair.setBounds(0, 344, 223, 41);
        jPanel1.add(botaoSair);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel4);
        jPanel2.add(salvarAlteracao);
        jPanel2.add(campoHorario);
        jPanel2.add(campoData);
        jPanel2.add(campoLocal);
        jPanel2.add(campoDescricao);
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel3);
        
        lblDescrio = new JLabel();
        lblDescrio.setBounds(576, 85, 106, 20);
        lblDescrio.setText("Tipo de evento");
        lblDescrio.setForeground(new Color(36, 135, 219));
        lblDescrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jPanel2.add(lblDescrio);
        
        btnNewButton = new JButton("Editar");
        btnNewButton.setBounds(576, 111, 85, 27);
        btnNewButton.setForeground(SystemColor.textHighlight);
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnNewButton);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(692, 111, 85, 27);
        btnExcluir.setForeground(SystemColor.textHighlight);
        btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnExcluir);
        
        comboBox = new JComboBox();
        comboBox.setBounds(317, 111, 212, 27);
        jPanel2.add(comboBox);
        

        pack();
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
    	new AgendarEventos().setVisible(true);
    	dispose();
    	criarEventoActionPerformed(evt);
        // Implementar a lógica para o botão jButton18, se necessário
    }

    private void jButton20ActionPerformed(ActionEvent evt) {
    	new CadastrarOrganizador().setVisible(true);
    	dispose();
    	criarEventoActionPerformed(evt);
        // Implementar a lógica para o botão jButton20, se necessário
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
    	new Paginainicial().setVisible(true);
    	dispose();
    	criarEventoActionPerformed(evt);
        // Implementar a lógica para o botão jButton21, se necessário
    }

    private void criarEventoActionPerformed(ActionEvent evt) {
        
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarAgendamentos().setVisible(true);
            }
        });
    }
}