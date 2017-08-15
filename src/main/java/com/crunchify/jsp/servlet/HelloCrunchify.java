package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.DepartamentoDAO;
import edu.co.sergio.mundo.vo.Departamento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String id = request.getParameter("Nombre");
        String nombre = request.getParameter("Apellido");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        PersonaDAO dao = new PersonaDAO();
        
        Persona persona = new Persona();
        departamento.setNombre_Persona(Integer.parseInt(Nombre));
        departamento.setApellido_Persona(Apellido);
        dao.insert(persona);
        
        //Listando la informacion  
        List<Persona> personas =  dao.findAll();
        request.setAttribute("personas", personas);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
