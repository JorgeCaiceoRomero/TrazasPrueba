package vista;

import hilo.HiloInsertar;
import modelo.Infectable;
import modelo.Paciente;
import modelo.Persona;
import modelo.Vacunable;
import modelo.PersonaInforme;
import java.util.ArrayList;

import controlador.DAOPersona;


public class Main {
	
	static DAOPersona dp = new DAOPersona();
	static ArrayList<Persona> personas = dp.buscarTodasPersonas();
	static ArrayList<Vacunable> enfermeros = new ArrayList<Vacunable>();
	static ArrayList<Infectable> pacientes = new ArrayList<Infectable>();
	
	public static void main(String[] args) {
		

		for(Persona p:personas) {
			if (p instanceof Paciente) {
				//System.out.println("Se ha añadido un paciente");
				
				pacientes.add((Infectable) p);
			}
			else {
				if(p instanceof Vacunable) {
					//System.out.println("Se ha añadido un VACUNABLE");
					enfermeros.add((Vacunable) p);
				}
			}
		}
		/*System.out.println("PERSONAS");
		for(Persona persona:personas) {
			System.out.println(persona.toString());
		}
		System.out.println("FIN DE PERSONAS");*/
		//imprimeListaVacunable(enfermeros);
		//System.out.println("=========================================================================================================");
		//imprimeListaInfectable(pacientes);
		ArrayList<PersonaInforme> informe=simularDia(pacientes);
		//imprimeListaInfectable(pacientes);
		//imprimeListaInforme(informe);
		HiloInsertar h1 = new HiloInsertar(informe);
		h1.start();
		
	}
	
	public static void imprimeListaVacunable(ArrayList<Vacunable> enfermeros) {
		for(Vacunable o:enfermeros) {
			System.out.println(o.toString());
		}
	}
	
	public static void imprimeListaInfectable(ArrayList<Infectable> pacientes) {
		for(Infectable o:pacientes) {
			System.out.println(o.toString());
		}
	}
	
	public static void imprimeListaInforme(ArrayList<PersonaInforme> informe) {
		for(PersonaInforme o:informe) {
			System.out.println(o.toString());
		}
	}
	
	
	public static ArrayList<PersonaInforme> simularDia(ArrayList<Infectable> listaInfectables) {
        Paciente p;
        boolean comprobarInfectado;
        ArrayList<PersonaInforme> informe= new ArrayList<PersonaInforme>();


        for (int i = 0; i < listaInfectables.size(); i++) {
            p = (Paciente) listaInfectables.get(i);

            int infectado = p.getInfectado();

            if (infectado == 0) {
                if (!p.visitarSuper()) {
                    if (!p.visitarTrabajo()) {
                        if (!p.cogerTransporte()) {
                        } else {
                            p.infectar(true);
                        }
                    } else {
                        p.infectar(true);
                    }

                } else {
                    p.infectar(true);
                }

            }
            if (p.getInfectado() == 1) {
                listaInfectables.get(i).infectar(true);
            } else {
                listaInfectables.get(i).infectar(false);
            }

        }

        enfermeros.get(enfermeros.size() - 1).vacunar(pacientes);

        for (int i = 0; i < pacientes.size(); i++) {

            enfermeros.get(enfermeros.size() - 1).vacunar(pacientes.get(i));

            if(((Paciente) listaInfectables.get(i)).getInfectado()==1){
                PersonaInforme pi= new PersonaInforme((Paciente)pacientes.get(i));
                informe.add(pi);
            }


        }
        return informe;


    }
}
