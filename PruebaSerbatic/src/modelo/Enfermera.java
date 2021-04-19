package modelo;

import java.util.Collection;

public class Enfermera extends Persona implements Vacunable{
	
	public Enfermera(int id, int idCiudad, String nombre, int infectado) {
		this.setId(id);
		this.setIdCiudad(idCiudad);
		this.setNombre(nombre);
		this.setTipo('E');
		this.setInfectado(infectado);
	}
	
	
}
