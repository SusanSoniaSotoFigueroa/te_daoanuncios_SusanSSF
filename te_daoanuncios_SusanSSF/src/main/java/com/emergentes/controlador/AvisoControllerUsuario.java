
package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAOimplusuario;
import com.emergentes.dao.AvisoDAOusuario;
import com.emergentes.modelo.Avisousuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AvisoControllerUsuario", urlPatterns = {"/AvisoControllerUsuario"})
public class AvisoControllerUsuario extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        AvisoDAOusuario dao = new AvisoDAOimplusuario();
        
        Avisousuario avi = new Avisousuario();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("avisousuario", avi);
                request.getRequestDispatcher("frmavisousuario.jsp").forward(request, response);
                break;
            case "edit":
                // AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    // obtener el objeto que corresponde al registro
                    avi = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                // Colocar como atributo
                request.setAttribute("avisousuario", avi);
                // Transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmavisousuario.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Erro al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("AvisoControllerUsuario");
                break;
            case "view":
                List<Avisousuario> lista = new ArrayList<Avisousuario>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("avisosusuario", lista);
                request.getRequestDispatcher("avisosusuario.jsp").forward(request, response);
                break;
            default:
                break;
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre =  request.getParameter("nombre");
        String correo =  request.getParameter("correo");
        String clave =  request.getParameter("clave");
        
        Avisousuario avi = new Avisousuario();
        
        avi.setId(id);
        avi.setNombre(nombre);
        avi.setCorreo(correo);
        avi.setClave(clave);
        
        AvisoDAOusuario dao = new AvisoDAOimplusuario();
        
        if (id == 0){
            try {
                // Nuevo
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("AvisoControllerUsuario");
    
        

    }

}
