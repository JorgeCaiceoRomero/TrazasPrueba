package controlador;

import modelo.Enfermera;
import modelo.Paciente;
import modelo.Persona;
import modelo.PersonaInforme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DAOPersona extends Conexion{
		
	private static Connection c = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	
	public DAOPersona(){
		super();
	}
	
	 public ArrayList<Persona> buscarPersonas(int idCiudad) {
		 	ArrayList<Persona> personas = new ArrayList<Persona>();
		 	Persona p;
	       // DataSource ds = setUpPool();
	        printDbStatus();
	        try {

	         /*   if (getConnectionPool().getMaxActive() <= 5) {
	                c = ds.getConnection();
	            }*/

	            pstm =  c.prepareStatement("Select * from personas where id_ciudad="+idCiudad);

	            rs = pstm.executeQuery();

	            while (rs.next()) {
	            	
	            	//System.out.println(p.toString());
	            	//Comprueba si es paciente y lo introduce
	            	if(rs.getString("Tipo").charAt(0)=='P') {
	            		Paciente paciente = new Paciente(rs.getInt("id"),rs.getInt("id_ciudad"), rs.getString("Nombre"), rs.getInt("Infectado"));
	            		personas.add(paciente);
	            	}
	            	//Comprueba si es enfermera
	            	else if(rs.getString("Tipo").charAt(0)=='E') {
		            		Enfermera e = new Enfermera(rs.getInt("id"),rs.getInt("id_ciudad"), rs.getString("Nombre"), rs.getInt("Infectado"));
		            		personas.add(e);
		            	}
	            		            	
	            }
	            
	            printDbStatus();
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOPersona.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            desconectar();
	            return personas;
	        }
	        
	    }
	 
	 
	 public ArrayList<Persona> buscarTodasPersonas() {
		 	ArrayList<Persona> personas = new ArrayList<Persona>();
		 	Persona p;
	        //DataSource ds = setUpPool();
	        printDbStatus();
	        try {

	          /*  if (getConnectionPool().getMaxActive() <= 5) {
	                c = ds.getConnection();
	            }*/

	            pstm =  c.prepareStatement("Select * from personas");

	            rs = pstm.executeQuery();

	            while (rs.next()) {

	            	//Comprueba si es paciente y lo introduce
	            	if(rs.getString("Tipo").charAt(0)=='P') {
	            		Paciente paciente = new Paciente(rs.getInt("id"),rs.getInt("id_ciudad"), rs.getString("Nombre"), rs.getInt("Infectado"));
	            		personas.add(paciente);
	            	}
	            	//Comprueba si es enfermera
	            	else if(rs.getString("Tipo").charAt(0)=='E') {
		            		Enfermera e = new Enfermera(rs.getInt("id"),rs.getInt("id_ciudad"), rs.getString("Nombre"), rs.getInt("Infectado"));
		            		personas.add(e);
		            	}
	            		 
	            }
	            
	            printDbStatus();
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOPersona.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            desconectar();
	            return personas;
	        }
	        
	    }
	 
	 public synchronized void insertarInforme(ArrayList<PersonaInforme> informe) {

	       // DataSource dataSource = setUpPool();
	        printDbStatus();
	        try {

	         /*   if (getConnectionPool().getMaxActive() <= 5) {
	                c = dataSource.getConnection();
	            }*/

	            pstm = c.prepareStatement("INSERT INTO personas_informe  VALUES (?,?, ?, ?, ?)");

	            for (int i = 0; i < informe.size(); i++) {
	            	pstm.setInt(1, informe.get(i).getId() );
	                pstm.setInt(2, informe.get(i).getIdCiudad());
	                pstm.setString(3, informe.get(i).getNombre());
	                pstm.setString(4, informe.get(i).getTipo()+"");
	                pstm.setInt(5, informe.get(i).getInfectado());

	                System.out.println("Se ha insertado " + informe.get(i).toString());
	                pstm.execute();
	            }
	            


	            printDbStatus();
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOPersona.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            desconectar();
	        }
	    }

	
	
}
