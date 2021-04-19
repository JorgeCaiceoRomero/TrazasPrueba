package modelo;

public class Paciente extends Persona implements Infectable, Moveable{
	
	public Paciente(int id, int idCiudad, String nombre, int infectado) {
		this.setId(id);
		this.setIdCiudad(idCiudad);
		this.setNombre(nombre);
		this.setTipo('P');
		this.setInfectado(infectado);
	}
	
	public Paciente() {
		super();
	}
	
	@Override
	public void infectar(boolean infecta) {
		// TODO Auto-generated method stub
		if(infecta) {
			setInfectado(1);
		}
		else {
			setInfectado(0);
		}
	}
	
	
}
