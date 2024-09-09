package hotelaria.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotelaria.model.Hospedagem;
import hotelaria.persistencia.ConnectionFactory;

public class HospedagemController {
	
	public String inserir(Hospedagem dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagem(codHospedagem,"
		+ "codChale,codCliente,estado,dataInicio,dataFim,qtdPessoas,desconto,valorFinal) "
		+ "values (?,?,?,?,?,?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst =con.prepareStatement(sql.toString());
			pst.setInt(1, dep.getCodHospedagem());
			pst.setInt(2, dep.getCodChale());
			pst.setInt(3, dep.getCodCliente());
			pst.setString(4, dep.getEstado());
			pst.setObject(5, dep.getDataInicio());
			pst.setObject(6, dep.getDataFim());
			pst.setInt(7, dep.getQtdPessoas());
			pst.setDouble(8, dep.getDesconto());
			pst.setDouble(9, dep.getValorFinal());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	public String alterar(Hospedagem dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("update hospedagem set CodChale=?CodCliente=?,estado=?,qtdPessoas=?,dataInicio=?,dataFim=?,desconto=?,valorFinal=? where CodHospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst =con.prepareStatement(sql.toString());
			pst.setInt(1, dep.getCodChale());
			pst.setInt(2, dep.getCodCliente());
			pst.setString(3, dep.getEstado());
			pst.setInt(4, dep.getQtdPessoas());
			pst.setObject(5, dep.getDataInicio());
			pst.setObject(6, dep.getDataFim());
			pst.setDouble(7, dep.getDesconto());
			pst.setDouble(8, dep.getValorFinal());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}

	}
	
	public String excluir(Hospedagem dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagem where codHospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, dep.getCodHospedagem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	public List<Hospedagem> listarTodos() {
	    String sql = "select * from hospedagem order by codHospedagem";
	    Connection con = ConnectionFactory.getConnection();
	    List<Hospedagem> lista = new ArrayList<>();
	    try (PreparedStatement pst = con.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {
	        while (rs.next()) {
	            Hospedagem dep = new Hospedagem();
	            dep.setCodHospedagem(rs.getInt(1));
	            dep.setCodChale(rs.getInt(2));
	            dep.setCodCliente(rs.getInt(3));
	            dep.setEstado(rs.getString(4));
	            dep.setDataInicio(rs.getDate(5));
	            dep.setDataFim(rs.getDate(6));
	            dep.setQtdPessoas(rs.getInt(7));
	            dep.setDesconto(rs.getDouble(8));
	            dep.setValorFinal(rs.getDouble(9));
	            lista.add(dep);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  // Logar exceção
	        throw new RuntimeException("Erro ao listar hospedagens", e);
	    } finally {
	        ConnectionFactory.close(con);
	    }
	    return lista;
	}

	public Hospedagem pesquisarPorHospedagem(int codHospedagem) {
		String sql = "select * from hospedagem where codHospedagem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codHospedagem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem ep = new Hospedagem();
				ep.setCodHospedagem(rs.getInt("codHospedagem"));
				ep.setCodCliente(rs.getInt("codCliente"));
				ep.setCodChale(rs.getInt("codChale"));
				ep.setEstado(rs.getString("estado"));
				ep.setDataInicio(rs.getDate("dataInicio"));
				ep.setDataFim(rs.getDate("dataFim"));
				ep.setDesconto(rs.getDouble("desconto"));
				ep.setValorFinal(rs.getDouble("valorFinal"));
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
