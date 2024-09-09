package hotelaria.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hotelaria.model.Chale;
import hotelaria.persistencia.ConnectionFactory;

public class ChaleController {
	
	public String inserir(Chale emp){
		String sql = "insert into chale(codChale,localizacao,capacidade,valorBaixaEstacao,valorAltaEstacao)values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getCodChale());
			pst.setString(2, emp.getLocalizacao());
			pst.setInt(3, emp.getCapacidade());
			pst.setDouble(4, emp.getValorBaixaEstacao());
			pst.setDouble(5, emp.getValorAltaEstacao());
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
	
	public String alterar(Chale emp) {
		String sql = "update chale set localizacao=?,capacidade=?,valorBaixaEstacao=?,valorAltaEstacao=? where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getLocalizacao());
			pst.setInt(2, emp.getCapacidade());
			pst.setDouble(3, emp.getValorBaixaEstacao());
			pst.setDouble(4, emp.getValorAltaEstacao());
			pst.setInt(5, emp.getCodChale());
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
	
	public String excluir(Chale emp){
		String sql = "delete from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getCodChale());
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
	
	public List<Chale> listarTodos(){
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		PreparedStatement pst = null;
	    ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Chale ep = new Chale();
				ep.setCodChale(rs.getInt("codChale"));
				ep.setLocalizacao(rs.getString("localizacao"));
				ep.setCapacidade(rs.getInt("capacidade"));
				ep.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
				ep.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
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
	
	
	public Chale pesquisarPorCodChale(int codChale){
		String sql = "select * from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale ep = new Chale();
				ep.setCodChale(rs.getInt("codChale"));
				ep.setLocalizacao(rs.getString("localizacao"));
				ep.setCapacidade(rs.getInt("capacidade"));
				ep.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
				ep.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
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
