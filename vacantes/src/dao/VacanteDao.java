package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import excepciones.CamposVaciosException;
import modelo.Vacantes;

public class VacanteDao {

	java.sql.Connection cn;
	
	public VacanteDao(java.sql.Connection cn) {
		
		this.cn=cn;
	}
	
	public List<Vacantes> getConsulta(String sql) throws SQLException, CamposVaciosException {
		
		List<Vacantes> listado=new ArrayList<Vacantes>();
		
		
		
		PreparedStatement pst=cn.prepareStatement(sql);
		
		ResultSet rs=pst.executeQuery();
		
		Vacantes vacante;
		
		while (rs.next()) {
			
			int id=rs.getInt("id");
			Date fechaPublicacion=rs.getDate("fechaPublicacion");
			String nombre=rs.getString("nombre");
			String descripcion=rs.getString("descripcion");
			String detalle=rs.getString("detalle");
			
			
			
			vacante =new Vacantes(id, fechaPublicacion, nombre, descripcion, detalle);
			
			listado.add(vacante);
			
			vacante=null;
			
			
		}
		
		
		return listado;
	}

	public boolean agregarVacante(Vacantes vacante) throws SQLException {
		boolean agregado=false;
		
		
		String sql = "insert into vacante values (?,?,?,?,?)";
		
		PreparedStatement pst= cn.prepareStatement(sql);
		
		pst.setInt(1, 0);
		pst.setDate(2,vacante.getFechaPublicacion() );
		pst.setString(3, vacante.getNombre());
		pst.setString(4, vacante.getDescripcion());
		pst.setString(5, vacante.getDetalle());
		
		pst.executeUpdate();
		pst=null;
		
		agregado=true;
		
		return agregado;
	
	}

	public int modificarNombre(String sql, List<Vacantes> listaVacante, String nombre) throws SQLException {
		int rows=0;
		
		PreparedStatement pst=cn.prepareStatement(sql);
		
		for (Vacantes vacante : listaVacante) {
			
			pst.setString(1, nombre);
			
			rows=pst.executeUpdate();
			
		}
		
		pst=null;
		
		return rows;
	}

	public int borrarVacante(String sql) throws SQLException {
		
		int rows=0;
		
		PreparedStatement pst=cn.prepareStatement(sql);
		
		rows=pst.executeUpdate();
		
		return rows;
	}

}
