package modelo;

public class Persona{
	
	private int id;
	private int idCiudad;
	private String nombre;
	private char tipo;
	private int infectado;
	
	public Persona() {
		
	}
	
	
	public Persona(int id, int idCiudad, String nombre, char tipo, int infectado) {
		super();
		this.id = id;
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.infectado = infectado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public char getTipo() {
		return tipo;
	}


	public void setTipo(char tipo) {
		this.tipo = tipo;
	}


	public int getInfectado() {
		return infectado;
	}


	public void setInfectado(int infectado) {
		this.infectado = infectado;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", idCiudad=" + idCiudad + ", nombre=" + nombre + ", tipo=" + tipo + ", infectado="
				+ infectado + "]";
	}



	
	
	
	
}
