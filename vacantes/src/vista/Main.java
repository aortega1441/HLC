package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.VacanteController;
import dao.DbConnection;
import excepciones.CamposVaciosException;
import modelo.Vacantes;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		boolean repetir=false;
		Scanner leer=new Scanner(System.in);
		int opcion=0;
		do {
			
		System.out.println("ELIJE UNA OPCION");
		System.out.println("1-FILTRAR");
		System.out.println("2-AGREGAR");
		System.out.println("3-MODIFICAR");
		System.out.println("4-BORRAR");
		System.out.println("5-SALIR");
		opcion=leer.nextInt();
		
		switch (opcion) {
		case 1: {
			
			Scanner entrada=new Scanner(System.in);
			String id="";
			System.out.println("INTRODUCE EL ID DEL REGISTRO QUE QUIERA BUSCAR");
			id=leer.next();
			DbConnection dbc=new DbConnection();
			
			Connection cn=dbc.getConnection();
			
			VacanteController vacanteController=new VacanteController(cn);
			
			List<Vacantes>listadoVacante;
			
			String sql="select * from vacante where id = '"+id+"'";
			
			try {
				listadoVacante=vacanteController.getLibros(sql);
				
				for (Vacantes vacante : listadoVacante) {
					System.out.println(vacante);
				}
			} catch (SQLException | CamposVaciosException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			dbc.disconnect();
			dbc=null;
			repetir=true;
			break;
			
		}
		case 2: {
				
			DbConnection dbc=new DbConnection();
			Connection cn=dbc.getConnection();
			
			VacanteController vacante=new VacanteController(cn);
			
			String nombre="Proyectista";
			String descripcion="Ingeniero de Planos";
			String detalle="Requirimientos de AutoCad";
			
			boolean agregado=false;
			
			try {
				
				agregado=vacante.agregarVacante(nombre, descripcion, detalle);
				
				if (agregado) {
					System.out.println("AGREGADO CON EXITO");
				}else {
					System.err.println("NO SE HA PODIDO AGREGAR");
				}
				
				
			} catch (CamposVaciosException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dbc.disconnect();
			dbc=null;
			repetir=true;
			break;
				}
		
		case 3: {
			
			DbConnection dbc=new DbConnection();
			Connection cn=dbc.getConnection();
			
			VacanteController vacante=new VacanteController(cn);
			
			int rows=0;
			
			try {
				rows=vacante.modificarTipoVacuna();
				
				if (rows!=0) {
					System.out.println("EL REGISTRO SE MODIFICO CORRECTAMENTE");
				}else {
					System.err.println("NO SE ENCONTRO NINGUN REGISTRO CON EL PATRON ESPECIFICADO");
				}
				
			} catch (SQLException | CamposVaciosException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			dbc.disconnect();
			dbc=null;
			repetir=true;
			break;
		}
		
		case 4: {
			
			DbConnection dbc=new DbConnection();
			Connection cn=dbc.getConnection();
			
			VacanteController vacante=new VacanteController(cn);
			
			int rows;
			
			try {
				rows=vacante.borrarVacante();
				
				if (rows!=0) {
					System.out.println("SE HAN BORRADO "+rows+" REGISTROS");
				}else {
					System.out.println("NO SE HA BORRADO NINGUN REGISTRO");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
			dbc.disconnect();
			dbc=null;
			repetir=true;
			break;
		}
		
		case 5: {
			
			System.out.println("GRACIAS POR UTILIZAR NUESTRA APLICACION");
			repetir=false;
			break;
		}
		default:
			System.err.println("INTRODUCE UN VALOR COMPRENDIDO EN EL MENU");
			repetir=true;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		} while (repetir);
	}

}
