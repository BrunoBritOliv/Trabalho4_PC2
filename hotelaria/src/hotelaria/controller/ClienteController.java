package hotelaria.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hotelaria.model.Cliente;
import hotelaria.persistencia.ConnectionFactory;

public class ClienteController {
	
	public String inserir(Cliente emp){
		String sql = "insert into cliente(codCliente,nomeCliente,rgCliente,endereco,bairro,cidade,estado,nascCliente,cepCliente)values (?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getCodCliente());
			pst.setString(2, emp.getNomeCliente());
			pst.setString(3, emp.getRgCliente());
			pst.setString(4, emp.getEndereco());
			pst.setString(5, emp.getBairro());
			pst.setString(6, emp.getCidade());
			pst.setString(7, emp.getEstado());
			pst.setDate(8, emp.getNascCliente());
			pst.setString(9, emp.getCepCliente());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public String alterar(Cliente emp) {
		String sql = "update cliente set nomeCliente=?,rgCliente=?,endereco=?,bairro=?,cidade=?,estado=?,nascCliente=?,cepCliente=? where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getNomeCliente());
			pst.setString(2, emp.getRgCliente());
			pst.setString(3, emp.getEndereco());
			pst.setString(4, emp.getBairro());
			pst.setString(5, emp.getCidade());
			pst.setString(6, emp.getEstado());
			pst.setDate(7, emp.getNascCliente());
			pst.setString(8, emp.getCepCliente());
			pst.setInt(9, emp.getCodCliente());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Alterado com sucesso.";
			}else{
				return "Erro ao alterar.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public String excluir(Cliente emp){
		String sql = "delete from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getCodCliente());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Excluído com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public List<Cliente> listarTodos(){
		String sql = "select * from cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		PreparedStatement pst = null;
	    ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Cliente ep = new Cliente();
				ep.setCodCliente(rs.getInt("codCliente"));
				ep.setNomeCliente(rs.getString("nomeCliente"));
				ep.setRgCliente(rs.getString("rgCliente"));
				ep.setEndereco(rs.getString("endereco"));
				ep.setBairro(rs.getString("bairro"));
				ep.setCidade(rs.getString("cidade"));
				ep.setEstado(rs.getString("estado"));
				ep.setNascCliente(rs.getDate("nascCliente"));
				ep.setCepCliente(rs.getString("cepCliente"));
				lista.add(ep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
	            if (rs != null) rs.close();  // Fechar ResultSet
	            if (pst != null) pst.close(); // Fechar PreparedStatement
	            if (con != null) con.close(); // Fechar Conexão
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
		}
		return lista;
	}
	
	
	public Cliente pesquisarPorCodCliente(int codCliente){
		String sql = "select * from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente ep = new Cliente();
				ep.setCodCliente(rs.getInt("codCliente"));
				ep.setNomeCliente(rs.getString("nomeCliente"));
				ep.setRgCliente(rs.getString("rgCliente"));
				ep.setEndereco(rs.getString("endereco"));
				ep.setBairro(rs.getString("bairro"));
				ep.setCidade(rs.getString("cidade"));
				ep.setEstado(rs.getString("estado"));
				ep.setNascCliente(rs.getDate("nascCliente"));
				ep.setCepCliente(rs.getString("cepCliente"));
				return ep;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
