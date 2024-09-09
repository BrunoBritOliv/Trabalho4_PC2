package hotelaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import hotelaria.controller.ChaleController;
import hotelaria.controller.ClienteController;
import hotelaria.controller.HospedagemController;
import hotelaria.model.Chale;
import hotelaria.model.Cliente;
import hotelaria.model.Hospedagem;
import hotelaria.util.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class FrmHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodHospedagem;
	private JTextField txtEstado;
	private JTextField txtQtdePessoas;
	private JTextField txtDesconto;
	private JTextField txtValorFinal;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	private JComboBox cbxCodCliente;
	private JComboBox cbxCodChale;
	private JLabel lblMensagem;
	private JTable tblConsulta;
	private List<Cliente> listaCliente;
	private List<Chale> listaChale;
	private List<Hospedagem> listaHotel;
	private MaskFormatter mascaraDataInicio = null;
	private MaskFormatter mascaraDataFim = null;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */

	
	/**
	 * Create the frame.
	 */
	public FrmHospedagem() {
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 735, Short.MAX_VALUE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d. Hospedagem", "C\u00F3d. Cliente", "C\u00F3d. Chale", "Estado", "Data In\u00EDcio", "Data Fim", "Qtde Pessoas", "Desconto", "Valor Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		tblConsulta.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem dep = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				Integer pos = 0;
				Integer pos2 = 0;
				/*Recuperando o codCliente do cliente selecionado*/
				for (Cliente e1 : listaCliente) {
					if (e1.getNomeCliente().equals(cbxCodCliente.getSelectedItem())) {
					pos = listaCliente.indexOf(e1);
					}
				}
				dep.setCodCliente(listaCliente.get(pos).getCodCliente());
				
				for (Chale e2 : listaChale) {
					if (e2.getCodChale().equals(cbxCodCliente.getSelectedItem())) {
					pos2 = listaCliente.indexOf(e2);
					}
				}
				dep.setCodChale(listaCliente.get(pos2).getCodCliente());
				
				dep.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
				dep.setEstado(txtEstado.getText());
				dep.setDataInicio(Date.valueOf(txtDataInicio.getText()));
				dep.setDataFim(Date.valueOf(txtDataInicio.getText()));
				dep.setQtdPessoas(Integer.parseInt(txtQtdePessoas.getText()));
				dep.setDesconto(Double.parseDouble(txtDesconto.getText()));
				dep.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(dc.inserir(dep));
				mostrarDados();
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem dep = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				Integer pos = 0;
				Integer pos2 = 0;
				
				for (Cliente e1 : listaCliente) {
					if (e1.getNomeCliente().equals(cbxCodCliente.getSelectedItem())) {
						pos = listaCliente.indexOf(e1);
					}
				}
				dep.setCodCliente(listaCliente.get(pos).getCodCliente());
				
				for (Chale e2 : listaChale) {
					if (e2.getCodChale().equals(cbxCodCliente.getSelectedItem())) {
						pos2 = listaCliente.indexOf(e2);
					}
				}
				dep.setCodChale(listaCliente.get(pos2).getCodCliente());
				
				dep.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
				dep.setEstado(txtEstado.getText());
				dep.setDataInicio(Date.valueOf(txtDataInicio.getText()));
				dep.setDataFim(Date.valueOf(txtDataInicio.getText()));
				dep.setQtdPessoas(Integer.parseInt(txtQtdePessoas.getText()));
				dep.setDesconto(Double.parseDouble(txtDesconto.getText()));
				dep.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(dc.alterar(dep));
				mostrarDados();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem dep = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				dep.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir essa hospedagem de código: " + txtCodHospedagem.getText() + "?",
				"Exclusão", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
				lblMensagem.setText(dc.excluir(dep));
				}
				mostrarDados();
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarDados();
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodHospedagem.setText("");
				txtEstado.setText("");
				txtDataInicio.setText("");
				txtDataFim.setText("");
				txtQtdePessoas.setText("");
				txtDesconto.setText("");
				txtValorFinal.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
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
					.addPreferredGap(ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addGap(12))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Cód. Cliente");
		
		JLabel lblNewLabel_1 = new JLabel("Cód. Chale");
		
		JLabel lblNewLabel_2 = new JLabel("Cód. Hospedagem");
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		
		JLabel lblNewLabel_4 = new JLabel("Data Início");
		
		JLabel lblNewLabel_5 = new JLabel("Data Fim");
		
		JLabel lblNewLabel_6 = new JLabel("Qtde Pessoas");
		
		JLabel lblNewLabel_7 = new JLabel("Desconto");
		
		JLabel lblNewLabel_8 = new JLabel("Valor Final");
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(new Color(0, 0, 255));
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		
		ClienteController ec = new ClienteController();
		listaCliente = ec.listarTodos();
		cbxCodCliente = new JComboBox();
		for(Cliente e : listaCliente){
		cbxCodCliente.addItem(e.getNomeCliente());
		}
		
		ChaleController cc = new ChaleController();
		listaChale = cc.listarTodos();
		cbxCodChale = new JComboBox();
		for(Chale e : listaChale){
		cbxCodChale.addItem(e.getCodChale());
		}
		
		txtCodHospedagem = new JTextField();
		txtCodHospedagem.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		try {
			mascaraDataInicio = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			mascaraDataFim = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		txtQtdePessoas = new JTextField();
		txtQtdePessoas.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setColumns(10);
		
		JButton btnCriaCliente = new JButton("..");
		btnCriaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente fe = new FrmCliente();
				fe.setVisible(true);
			}
		});
		
		JButton btnCriaChale = new JButton("..");
		btnCriaChale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale fe = new FrmChale();
				fe.setVisible(true);
			}
		});
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		
		txtDataFim = new JTextField();
		txtDataFim.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("yyyy-MM-dd");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("yyyy-MM-dd");
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_8)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_6)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_4))
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(txtQtdePessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9)
										.addComponent(lblNewLabel_10))
									.addGap(83))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(42)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(cbxCodChale, 0, 216, Short.MAX_VALUE)
										.addComponent(cbxCodCliente, 0, 216, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCriaCliente)
								.addComponent(btnCriaChale))
							.addGap(390))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMensagem)
							.addContainerGap(692, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCodCliente, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnCriaCliente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnCriaChale))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtQtdePessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addGap(15)
					.addComponent(lblMensagem)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	public void mostrarDados() {
		List<Hospedagem> listaHotel = new ArrayList<>();
		HospedagemController dc = new HospedagemController();
		listaHotel = dc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Hospedagem dp : listaHotel) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(dp.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(dp.getCodCliente(), i, 1);
			tblConsulta.setValueAt(dp.getCodChale(), i, 2);
			tblConsulta.setValueAt(dp.getEstado(), i, 3);
			tblConsulta.setValueAt(dp.getDataInicio(), i, 4);
			tblConsulta.setValueAt(dp.getDataFim(), i, 5);
			tblConsulta.setValueAt(dp.getQtdPessoas(), i, 6);
			tblConsulta.setValueAt(dp.getDesconto(), i, 7);
			tblConsulta.setValueAt(dp.getValorFinal(), i, 8);
			i++;
		}
	}
}
