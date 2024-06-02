package view;

import model.EventoDAO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class GerenciarAgendamentos extends JFrame {

    private JPanel jPanel2;
    private JPanel jPanel1;
    private JButton botaoGerenciarAgendamentos;
    private JButton botaoAgendarEvento;
    private JButton botaoPaginainicial;
    private JLabel jLabel2;
    private JButton botaoSair;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    public GerenciarAgendamentos() {
        initComponents();
        carregarDados();
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 212, 725);
        botaoGerenciarAgendamentos = new JButton();
        botaoGerenciarAgendamentos.setBounds(0, 210, 223, 41);
        botaoAgendarEvento = new JButton();
        botaoAgendarEvento.setBounds(0, 143, 223, 43);
        botaoPaginainicial = new JButton();
        botaoPaginainicial.setBounds(0, 76, 223, 43);
        jLabel2 = new JLabel();
        jLabel2.setBounds(317, 29, 328, 27);

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
        
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(322, 150, 531, 121);
        jTable1 = new JTable();
        jTable1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.setBackground(new Color(0, 191, 255));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "id", "Nome", "Tipo", "Descricao", "Data", "Horario", "Local", "Oganizador"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jPanel2.add(jScrollPane1);

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
        botaoSair.setBounds(0, 275, 223, 41);
        jPanel1.add(botaoSair);
        jPanel2.add(jLabel2);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(322, 96, 85, 27);
        btnEditar.setForeground(SystemColor.textHighlight);
        btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnEditar);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(465, 96, 85, 27);
        btnExcluir.setForeground(SystemColor.textHighlight);
        btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnExcluir);

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Ação do botão Editar
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Ação do botão Excluir
            }
        });

        pack();
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
    	new Paginainicial().setVisible(true);
    	dispose();
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
    	new AgendarEventos().setVisible(true);
    	dispose();
    }

    private void carregarDados() {
        EventoDAO eventoDAO = new EventoDAO();
        try {
            DefaultTableModel tabela = eventoDAO.mostrarEventos();
            jTable1.setModel(tabela);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarAgendamentos().setVisible(true);
            }
        });
    }
}
