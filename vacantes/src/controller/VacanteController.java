package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.VacanteDao;
import excepciones.CamposVaciosException;

import modelo.Vacantes;




public class VacanteController {

	private List<Vacantes> listadoVacantes;
	Connection cn;
	public VacanteController(Connection cn) {
		
		this.cn=cn;
		
	}
	
	public List<Vacantes> getLibros(String sql) throws SQLException, CamposVaciosException{
		
		VacanteDao vacantes=new VacanteDao (cn);
		
		return vacantes.getConsulta(sql);
		
		
	}
	
	public boolean agregarVacante( String nombre, String descripcion, String detalle) throws CamposVaciosException, SQLException {
		
		
		boolean agregado=false;
		
		VacanteDao vacantes=new VacanteDao(cn);
		
		Vacantes vacante=new Vacantes(nombre, descripcion, detalle);
		
		return vacantes.agregarVacante(vacante);
	}

	public int modificarTipoVacuna() throws SQLException, CamposVaciosException {
		int rows=0;
		List<Vacantes>listaVacante=new ArrayList<Vacantes>();
		VacanteDao modificarVacante=new VacanteDao(cn);
		String id="13";
		String nombre="PROYECTISTA";
		
		String sqlBuscar="select * from vacante where id = '"+id+"'";
		
		listaVacante=modificarVacante.getConsulta(sqlBuscar);
		
		if (listaVacante.size()!=0) {
			String sql="Update vacante set nombre=? where id = '"+id+"'";
			
			rows= modificarVacante.modificarNombre(sql,listaVacante,nombre);
		}
		
		
		
		return rows;
	}

	public int borrarVacante() throws SQLException {
		int rows=0;
		
		VacanteDao borrarVacante=new VacanteDao(cn);
		String nombre="PROYECTISTA";
		String sql="delete from vacante where nombre = '"+nombre+"'";
		
		rows=borrarVacante.borrarVacante(sql);
		
		
		return rows;
	}

}
