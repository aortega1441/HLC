package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import modelo.Vacante;

public class VacanteDao {
	
	private DbConnection conn;

	public VacanteDao(DbConnection conn) {
		this.conn=conn;
	}
	
	public boolean insert(Vacante vacante) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			String sql="insert into vacante values (?,?,?,?,?)";
			PreparedStatement pst= conn.getConnection().prepareStatement(sql);
			pst.setInt(1, vacante.getId());
			pst.setString(2, format.format(vacante.getFechaPublicacion()));
			pst.setString(3, vacante.getNombre());
			pst.setString(4, vacante.getDescripcion());
			pst.setString(5, vacante.getDetalle());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Error VacanteDao.insert: "+ e.getMessage());
			return false;
		}
		
		
		
	}
	
public List<Vacante> getUltimas () {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			
			List<Vacante> list = new ArrayList<Vacante>();
			Vacante vacante;
			String sql="select * from Vacante order by id limit 3";
			PreparedStatement pst= conn.getConnection().prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				vacante=new Vacante(rs.getInt("id"));
				vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
				vacante.setNombre(rs.getString("nombre"));
				vacante.setDescripcion(rs.getString("descripcion"));
				vacante.setDetalle(rs.getString("detalle"));
				list.add(vacante);
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println("Error VacanteDao.insert: "+ e.getMessage());
			return null;
		}
		
		
		
	}

}
