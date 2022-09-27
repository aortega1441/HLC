package modelo;
//Clase tipo "Modelo" que representa una entidad (registro) de la tabla de Usuario
public class Usuario {
	//Variables de instancia de la clase. Cada variable mapea un campo de la tabla de Usuario en la BD
	private int id;
	private String nombre;
	private String email;
	private String username;
	private String password;
	private String perfil;
	private String estatus="activo";

	public Usuario(int id) {
		// TODO Auto-generated constructor stub
		//constructor solo con el id
		this.id=id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", perfil=" + perfil + ", estatus=" + estatus + "]";
	}
	

}
