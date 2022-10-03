package modelo;

import java.sql.Date;

import excepciones.CamposVaciosException;



public class Vacantes {
	
	private int id;
	private java.sql.Date fechaPublicacion;
	private String nombre;
	private String descripcion;
	private String detalle;
	
	
	


	public Vacantes(String nombre, String descripcion, String detalle) throws CamposVaciosException {
		super();
		
		java.util.Date fecha=new java.util.Date();
		this.setFechaPublicacion(new java.sql.Date(fecha.getTime()));
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		
		this.setDetalle(detalle);
	}


	public Vacantes(int id, Date fechaPublicacion, String nombre, String descripcion, String detalle) throws CamposVaciosException, NumberFormatException {
		super();
		this.id=id;
		this.setFechaPublicacion(fechaPublicacion);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDetalle(detalle);
	}


	public int getId() {
		return id;
	}

	public void setId( String id) throws CamposVaciosException, NumberFormatException {
		
		if (id.equals(" ")) {
			throw new CamposVaciosException("id");
		}else {
			
			int idInt=Integer.parseInt(id);
			this.id = idInt;
		}
		
		
		
	}

	public java.sql.Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CamposVaciosException {
		
		if (nombre.equals(" ")) {
			throw new CamposVaciosException("nombre");
		}else {
			this.nombre = nombre;
		}
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws CamposVaciosException {
		
		if (descripcion.equals(" ")) {
			throw new CamposVaciosException("descripcion");
		}else {
			this.descripcion = descripcion;
		}
		
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) throws CamposVaciosException {
		
		if (detalle.equals(" ")) {
			throw new CamposVaciosException("detalle");
		}else {
			this.detalle = detalle;
		}
		
		
	}
	
	@Override
	public String toString() {
		return  id + "," + fechaPublicacion + "," + nombre + ","+ descripcion
				+ "," + detalle;
	}
	
	

}
