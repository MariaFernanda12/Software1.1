package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Persona;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class PersonaDAO     {

      
	/**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Persona> Retorna la lista de Departamentos existentes en la base de datos
	 */
	public List<Persona> findAll() {
		List<Persona> personas= null;
	    String query = "SELECT * FROM Pers";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	 
	    String nombre = null;
	
	    while (rs.next()){
	    	if(personas == null){
	    		personas= new ArrayList<Persona>();
	    	}
	      
	        Persona registro= new Persona();
	      
	        nombre = rs.getString("nom_Persona");
	        registro.setNom_Persona(nombre) ;
	        
	        personas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Persona");
			e.printStackTrace();
		}
	    
	    return personas;
	}

	
	public boolean insert(Persona t) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Pers (nombre_Persona,apellido_Persona)"  + " values (?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, t.getNombre_Persona());
                        preparedStmt.setString (2, t.getApellido_Persona());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
