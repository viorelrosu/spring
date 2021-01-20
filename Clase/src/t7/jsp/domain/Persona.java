package t7.jsp.domain;

public class Persona {
	private String nombre;
	private int dni;
	
	public Persona(int dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
}

