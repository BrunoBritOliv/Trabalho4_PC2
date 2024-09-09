package hotelaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hotelaria.controller.ChaleController;
import hotelaria.model.Chale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmChale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodChale;
	private JTextField txtLocalizacao;
	private JTextField txtCapacidade;
	private JTextField txtValorBaixaEstacao;
	private JTextField txtValorAltaEstacao;
	private JLabel lblMensagem;
	List<Chale> listaEmp = new ArrayList();
	private JTable tblConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void pesquisar(){
		ChaleController ec = new ChaleController();
		listaEmp = ec.listarTodos();
		DefaultTableModel tbm =(DefaultTableModel)tblConsulta.getModel();
		for(int i = tbm.getRowCount()-1; i >= 0; i--){
			tbm.removeRow(i);
		}
		int i = 0;
		for(Chale ep : listaEmp){
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ep.getCodChale(), i, 0);
			tblConsulta.setValueAt(ep.getLocalizacao(), i, 1);
			tblConsulta.setValueAt(ep.getCapacidade(), i, 2);
			tblConsulta.setValueAt(ep.getValorBaixaEstacao(), i, 3);
			tblConsulta.setValueAt(ep.getValorAltaEstacao(), i, 4);
			i++;
		}
	}

	/**
	 * Create the frame.
	 */
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Localiza\u00E7\u00E3o", "Capacidade", "Valor Baixa Esta\u00E7\u00E3o", "Valor Alta Esta\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(new Color(0, 0, 255));
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtCodChale.getText()));
				emp.setLocalizacao(txtLocalizacao.getText());
				emp.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				emp.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				emp.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				lblMensagem.setText(ec.inserir(emp));
				pesquisar();
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtCodChale.getText()));
				emp.setLocalizacao(txtLocalizacao.getText());
				emp.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				emp.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				emp.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				lblMensagem.setText(ec.alterar(emp));
				pesquisar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtCodChale.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse chale: "+txtCodChale.getText()+"?","Exclusão",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(ec.excluir(emp));
				}
				pesquisar();
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale.this.dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodChale.setText("");
				txtLocalizacao.setText("");
				txtCapacidade.setText("");
				txtValorBaixaEstacao.setText("");
				txtValorAltaEstacao.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnPesquisar)
						.addComponent(btnSair)
						.addComponent(btnLimpar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Código");
		
		JLabel lblNewLabel_1 = new JLabel("Localização");
		
		JLabel lblNewLabel_2 = new JLabel("Capacidade");
		
		JLabel lblNewLabel_3 = new JLabel("Valor Alta Estação");
		
		JLabel lblNewLabel_4 = new JLabel("Valor Baixa Estação");
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setColumns(10);
		
		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(49)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCapacidade, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(txtLocalizacao, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(txtCodChale, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValorBaixaEstacao, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(txtValorAltaEstacao, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)))
						.addComponent(lblMensagem))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMensagem))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
