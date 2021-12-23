package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumnos;
import modelo.AlumnosDAO;


@WebServlet(name = "AlumnosController", urlPatterns = {"/AlumnosController"})
public class AlumnosController extends HttpServlet {

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            AlumnosDAO alumnosDao = new AlumnosDAO();
            String accion;
            RequestDispatcher dispatcher = null;
            accion = request.getParameter("accion");
            if(accion == null || accion.isEmpty()){
                dispatcher = request.getRequestDispatcher("index.jsp");
            }else if(accion.equals("modificar")){
                dispatcher = request.getRequestDispatcher(
                        "Vistas/modificar.jsp");
            }else if(accion.equals("actualizar")){
                int id = Integer.parseInt(request.getParameter("id"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String telefono = request.getParameter("teléfono");
                Alumnos alumno = new Alumnos(id,nombres,apellidos,email,telefono);
                alumnosDao.actualizarAlumno(alumno);
                dispatcher = request.getRequestDispatcher(
                        "Vistas/alumnos.jsp");
            }else if(accion.equals("nuevo")){
              dispatcher = request.getRequestDispatcher(
                        "Vistas/nuevo.jsp");
            }else if(accion.equals("insert")){
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String teléfono = request.getParameter("teléfono");
                Alumnos alumno;
                alumno = new Alumnos(0,nombres,apellidos,email,teléfono);
                alumnosDao.insertarAlumno(alumno);
                dispatcher = request.getRequestDispatcher(
                        "Vistas/alumnos.jsp");
            }else if(accion.equals("eliminar")){
                int id = Integer.parseInt(request.getParameter("id"));
                alumnosDao.eliminarAlumno(id);
                dispatcher = request.getRequestDispatcher(
                        "Vistas/alumnos.jsp");
            }else if(accion.equals("ingresar")){
                String usuario = request.getParameter("email");
                String clave = request.getParameter("password");
                boolean ingreso = alumnosDao.ingresarUsuario(usuario, clave);
                if (ingreso){
                    dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
                }else{
                    dispatcher = request.getRequestDispatcher("index.jsp");
                } 
                
            }           
            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request,response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}