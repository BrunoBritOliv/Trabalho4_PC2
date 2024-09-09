package hotelaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hotelaria.controller.ClienteController;
import hotelaria.model.*;
import hotelaria.persistencia.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class FrmCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtCodCliente;
	private JTextField txtNomeCliente;
	private JTextField txtRgCliente;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCepCliente;
	private JLabel lblMensagem;
	List<Cliente> listaEmp = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void pesquisar(){
		ClienteController ec = new ClienteController();
		listaEmp = ec.listarTodos();
		DefaultTableModel tbm =(DefaultTableModel)tblConsulta.getModel();
		for(int i = tbm.getRowCount()-1; i >= 0; i--){
			tbm.removeRow(i);
		}
		int i = 0;
		for(Cliente ep : listaEmp){
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ep.getCodCliente(), i, 0);
			tblConsulta.setValueAt(ep.getNomeCliente(), i, 1);
			tblConsulta.setValueAt(ep.getRgCliente(), i, 2);
			tblConsulta.setValueAt(ep.getEndereco(), i, 3);
			tblConsulta.setValueAt(ep.getBairro(), i, 4);
			tblConsulta.setValueAt(ep.getCidade(), i, 5);
			tblConsulta.setValueAt(ep.getEstado(), i, 6);
			tblConsulta.setValueAt(ep.getNascCliente(), i, 7);
			tblConsulta.setValueAt(ep.getCepCliente(), i, 8);
			i++;
		}
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public FrmCliente() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Código");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		
		JLabel lblNewLabel_4 = new JLabel("Bairro");
		
		JLabel lblNewLabel_5 = new JLabel("Cidade");
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		
		JLabel lblNewLabel_7 = new JLabel("Nascimento");
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		
		txtRgCliente = new JTextField();
		txtRgCliente.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblMensagem.setForeground(new Color(0, 0, 255));
		
		JFormattedTextField txtNascCliente = new JFormattedTextField();
		
		JLabel lblNewLabel_8 = new JLabel("CEP");
		
		txtCepCliente = new JTextField();
		txtCepCliente.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCodCliente, 481, 481, Short.MAX_VALUE)
								.addComponent(txtNomeCliente, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(txtEndereco, 481, 481, Short.MAX_VALUE)
								.addComponent(txtBairro, 481, 481, Short.MAX_VALUE)
								.addComponent(txtCidade, 481, 481, Short.MAX_VALUE)
								.addComponent(txtRgCliente, 481, 481, Short.MAX_VALUE)
								.addComponent(txtEstado, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(txtNascCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(txtCepCliente, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(lblMensagem))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtNascCliente, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCepCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codCliente = tblConsulta.getValueAt(linha, 0).toString();
				String nomeCliente = tblConsulta.getValueAt(linha, 1).toString();
				String rgCliente = tblConsulta.getValueAt(linha, 2).toString();
				String endereco = tblConsulta.getValueAt(linha, 3).toString();
				String bairro = tblConsulta.getValueAt(linha, 4).toString();
				String cidade = tblConsulta.getValueAt(linha, 5).toString();
				String estado = tblConsulta.getValueAt(linha, 6).toString();
				String nascCliente = tblConsulta.getValueAt(linha, 7).toString();
				String cepCliente = tblConsulta.getValueAt(linha, 8).toString();
				txtCodCliente.setText(codCliente);
				txtNomeCliente.setText(nomeCliente);
				txtRgCliente.setText(rgCliente);
				txtEndereco.setText(endereco);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
				txtNascCliente.setText(nascCliente);
				txtCepCliente.setText(cepCliente);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codCliente", "nomeCliente", "rgCliente", "endereco", "bairro", "cidade", "estado", "nascCliente", "CEP"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
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
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController ec = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				emp.setNomeCliente(txtNomeCliente.getText());
				emp.setRgCliente(txtRgCliente.getText());
				emp.setEndereco(txtEndereco.getText());
				emp.setBairro(txtBairro.getText());
				emp.setCidade(txtCidade.getText());
				emp.setEstado(txtEstado.getText());
				emp.setNascCliente(Date.valueOf(txtNascCliente.getText()));
				emp.setCepCliente(txtCepCliente.getText());
				lblMensagem.setText(ec.inserir(emp));
				pesquisar();
			}
		});
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController ec = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				emp.setNomeCliente(txtNomeCliente.getText());
				emp.setRgCliente(txtRgCliente.getText());
				emp.setEndereco(txtEndereco.getText());
				emp.setBairro(txtBairro.getText());
				emp.setCidade(txtCidade.getText());
				emp.setEstado(txtEstado.getText());
				emp.setNascCliente(Date.valueOf(txtNascCliente.getText()));
				emp.setCepCliente(txtCepCliente.getText());
				lblMensagem.setText(ec.alterar(emp));
				pesquisar();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController ec = new ClienteController();
				emp.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse cliente: "+txtNomeCliente.getText()+"?","Exclusão",
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
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodCliente.setText("");
				txtNomeCliente.setText("");
				txtRgCliente.setText("");
				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
				txtNascCliente.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
