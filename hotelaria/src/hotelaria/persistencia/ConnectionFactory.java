package hotelaria.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "hotel";
		String senha = "pc2";
		String url = "jdbc:postgresql://127.0.0.1:5432/Hotel";
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user,senha);
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return con;
	}
	
	public static void close(Connection con){
		try{
			con.close();
		}catch(SQLException e){
		}
	}
}