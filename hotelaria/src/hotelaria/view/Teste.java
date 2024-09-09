package hotelaria.view;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import hotelaria.controller.ChaleController;
import hotelaria.controller.ClienteController;
import hotelaria.controller.HospedagemController;
import hotelaria.model.Chale;
import hotelaria.model.Cliente;
import hotelaria.model.Hospedagem;
import hotelaria.persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		LocalDate data;
		Connection con = ConnectionFactory.getConnection();
		if(con != null){
		System.out.println("Conexão estabelecida com sucesso!\n");
		ConnectionFactory.close(con);
		}
		ClienteController controller = new ClienteController();
		ChaleController control = new ChaleController();
		HospedagemController ctrl = new HospedagemController();
		
		Chale tst = new Chale(1, "bloco a", 5, 350.5, 600.0);
		//Cliente teste1 = new Cliente(1,"William Soares","40028922","Residencial Paiva","Gama","Brasília","Distrito Federal",data = Date.valueOf("2003-11-30"));
		//Cliente teste2 = new Cliente(2,"Bruno Brito","89224002","Somewhere","Riacho Fundo II","Brasília","Distrito Federal",data = Date.valueOf("2001-09-18"));
		Hospedagem hosp = new Hospedagem();
		hosp.setCodHospedagem(1);
		hosp.setCodChale(1);
		hosp.setCodCliente(1);
		hosp.setEstado("DF");
		hosp.setQtdPessoas(2);
		//hosp.setDataInicio(data = LocalDate.parse("08/11/2022"));
		//hosp.setDataFim(data = LocalDate.parse("08/11/2022"));
		hosp.setDesconto(36.0);
		hosp.setValorFinal(60.0);
		//INSERIR
			//System.out.println(ctrl.inserir(hosp));
			//System.out.println(controller.inserir(teste2));
		
		//Cliente teste3 = new Cliente(2,"30037070","Bruno Brito","Somewhere","Riacho Fundo II","Brasília","Distrito Federal",data = Date.valueOf("2001-09-18"));
		//ALTERAR
			//System.out.println(controller.alterar(teste3));
		
		//EXCLUIR
			//System.out.println(controller.excluir(teste1));
			//System.out.println(controller.excluir(teste2));
		
		//LISTAR TODOS CLIENTES
		/*
		List<Cliente> lista = controller.listarTodos();
		if(lista != null){
			for(Cliente e : lista){
				System.out.println("Código: "+e.getCodCliente());
				System.out.println("Nome: "+e.getNomeCliente());
				System.out.println("Rg: "+e.getRgCliente());
				System.out.println("Endereço: "+e.getEndereco());
				System.out.println("Bairro: "+e.getBairro());
				System.out.println("Cidade: "+e.getCidade());
				System.out.println("Estado: "+e.getEstado());
				System.out.println("Data de Nascimento: "+e.getNascCliente()+" ");
			}
		}*/
		
		/*
		Cliente temp = new Cliente();
		temp = controller.pesquisarPorCodCliente(1);
		if (temp != null) {
			System.out.println("Código: "+temp.getCodCliente());
			System.out.println("Nome: "+temp.getNomeCliente());
			System.out.println("Rg: "+temp.getRgCliente());
			System.out.println("Endereço: "+temp.getEndereco());
			System.out.println("Bairro: "+temp.getBairro());
			System.out.println("Cidade: "+temp.getCidade());
			System.out.println("Estado: "+temp.getEstado());
			System.out.println("Data de Nascimento: "+temp.getNascCliente()+" ");
		}*/
	}
}
