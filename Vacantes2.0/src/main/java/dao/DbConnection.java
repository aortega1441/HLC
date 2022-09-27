package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static String bd = "vacantes";
	static String parametros = "?useSSL=false&serverTimezone=UTC";
	// static String parametros="?useSSL=false"; //DEPENDE DE LA VERSION DEL DRIVER
	static String user = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	// Esta variable va a guardar la conexion
	Connection conn = null;

	public DbConnection() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // esto es una forma de instanciar el driver
			// para poder usar sus clases
			// OBTENEMOS UNA CONEXION CON LOS PARAMETROS ESPECIFICADOS ANTERIORMENTE
			conn = DriverManager.getConnection(url, user, password);
			// SI CONN NO ES NULO, SIGNIFICA QUE PUDIMOS CONECTARNOS
			if (conn != null) {
				System.out.println("Connecting database [" + conn + "] OK");
				System.out.println("=====================================");
			}
		} catch (ClassNotFoundException e) { // EXCEPCION OCURRIDA POR NO ENCONTRAR EL DRIVER
			System.err.println("Excepcion driver: " + e.getMessage());
		} catch (SQLException e) { // EXCEPCION OCURRIDA POR LA CONEXION
			System.err.println("Excepcion conexion: " + e.getMessage());
		}
	}

	// Permite retornar la instancia de la conexion
	public Connection getConnection() {
		return conn;
	}

	// para la desconexion
	public void disconnect() {
		System.out.println("===================================");
		System.out.println("Closing database: [" + conn + "] OK");
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

}
