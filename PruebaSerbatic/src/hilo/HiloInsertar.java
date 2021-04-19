package hilo;

import java.util.ArrayList;

import controlador.DAOPersona;
import modelo.PersonaInforme;

public class HiloInsertar extends Thread{
	ArrayList<PersonaInforme> informe;
	
	
	public HiloInsertar(ArrayList<PersonaInforme> informe) {
		this.informe=informe;
	}
	
	public void run() {
		System.out.println("Ejecutando hilo");
		DAOPersona dp = new DAOPersona();
		dp.insertarInforme(informe);
	}
}
