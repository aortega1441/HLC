package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static String bd = "vacantes";
	static String parametros = "?useSSL=false&serverTimezone=UTC";
	

	static String user = "root";
	static String password = "";

	static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;

	Connection conn = null;

	public DbConnection() {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			conn = DriverManager.getConnection(url, user, password);

			
			if (conn != null) {

				//System.out.println("Connecting database [" + conn + "] OK");

			}

		} catch (ClassNotFoundException e) { 

			System.out.println("Excepcion driver: " + e.getMessage());

		} catch (SQLException e) { 

			System.err.println("Excepcion conexion: " + e.getMessage());

		}

	}

	public Connection getConnection() {

		return conn;

	}

	public void disconnect() {

		//System.out.println("Closing database: [" + conn + "] OK");

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				System.out.println(e);
			}
		}

	}

}
