package view;

import model.EventoDAO;
import control.Evento;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private int selectedRow;

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
        jLabel2.setBounds(276, 29, 328, 27);

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
        jScrollPane1.setBounds(276, 153, 599, 121);
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

        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        			.addGap(28))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        			.addGap(162))
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
        
        btnEditar = new JButton("Salvar alterações");
        btnEditar.setBounds(276, 107, 137, 27);
        btnEditar.setForeground(SystemColor.textHighlight);
        btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnEditar);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(443, 107, 85, 27);
        btnExcluir.setForeground(SystemColor.textHighlight);
        btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jPanel2.add(btnExcluir);

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	try {
					editarEvento();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
					excluirEvento();
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

    private void jTable1MouseClicked(MouseEvent evt) {
        selectedRow = jTable1.getSelectedRow();
    }

    private void editarEvento() throws SQLException {
        if (selectedRow != -1) {
        	Evento evento = new Evento();
        	EventoDAO eventodao = new EventoDAO();
        	
        	//pega os valores inseridos e envia para a classe evento
            int idEvento = (int) jTable1.getValueAt(selectedRow, 0);
            evento.setId_evento(idEvento);
            String nomeEvento = (String) jTable1.getValueAt(selectedRow, 1);
            evento.setNome_evento(nomeEvento);
            String tipo = (String) jTable1.getValueAt(selectedRow, 2);
            evento.setTipo_evento(tipo);
            String data = (String) jTable1.getValueAt(selectedRow, 3);
            evento.setData(data);
            String local = (String) jTable1.getValueAt(selectedRow, 4);
            evento.setLocal(local);
            String hora = (String) jTable1.getValueAt(selectedRow, 5);
            evento.setHorario(hora);
            
            //envia os valores de evento para eventodao.editarEvento
            eventodao.editarEvento(evento);
            
            JOptionPane.showMessageDialog(this,"Alterações salvas ");
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um evento para editar.");
        }
    }

    private void excluirEvento() throws SQLException {
    	EventoDAO eventoDAO = new EventoDAO();
        if (selectedRow != -1) {
        	//captura o id selecionado
            int idEvento = (int) jTable1.getValueAt(selectedRow, 0);
            //envia o dia para eventoDAO.excluirEvento
            eventoDAO.excluirEvento(idEvento);
            JOptionPane.showMessageDialog(this, "Evento excluido");
            ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um evento para excluir.");
        }
    }

    private void carregarDados() {
        EventoDAO eventoDAO = new EventoDAO();
        try {
        	//instancia um objeto para receber a tabela criada em eventoDAO.mostrarEventos
            DefaultTableModel tabela = eventoDAO.mostrarEventos();
            //envia a tabela para a interface
            jTable1.setModel(tabela);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados: " + e.getMessage(), 
            								"Erro", JOptionPane.ERROR_MESSAGE);
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
