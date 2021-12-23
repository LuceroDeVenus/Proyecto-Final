package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO {
    Connection conexion;
    public AlumnosDAO(){
        Conexion con = new Conexion();
        conexion = con.getConection();
    }
    public List<Alumnos> listarAlumnos(){
       PreparedStatement ps;
       ResultSet rs;
       List<Alumnos> lista = new ArrayList<>();
       
       try{
           ps = conexion.prepareStatement("SELECT * FROM participantes");
           rs = ps.executeQuery();
           
           while(rs.next()){
               int id = rs.getInt("id");
               String nombres = rs.getString("nombres");
               String apellidos = rs.getString("apellidos"); 
               String email = rs.getString("email");
               int teléfono = rs.getInt("teléfono");
               Alumnos alumnos = new Alumnos(id, nombres, apellidos,
               email, teléfono);
               lista.add(alumnos);
           }
           return lista;
           
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
    }
    public Alumnos mostrarAlumno(int _id){
       PreparedStatement ps;
       ResultSet rs;
       Alumnos alumno = null;
       
       try{
            ps = conexion.prepareStatement("SELECT * FROM participantes WHERE id=?");
            ps.setInt(1,_id);
           rs = ps.executeQuery();
           while(rs.next()){
               int id = rs.getInt("id");
               String nombres = rs.getString("nombres");
               String apellidos = rs.getString("apellidos"); 
               String email = rs.getString("email");
               int teléfono = rs.getInt("teléfono");
               
               alumno = new Alumnos(id,nombres,apellidos,
               email, teléfono);
           } return alumno;
           
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
       
    }
    public boolean insertarAlumno(Alumnos alumno){
        PreparedStatement ps;
        try{
             ps = conexion.prepareStatement("INSERT INTO participantes (nombres,apellidos,email,teléfono) VALUES (?,?,?,?)");
             ps.setString(1,alumno.getNombres());
             ps.setString(2,alumno.getApellidos());
             ps.setString(3,alumno.getEmail());
             ps.setInt(4, alumno.getTeléfono());
             ps.execute();
             return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
        
        
    }
    public boolean actualizarAlumno(Alumnos alumno){
        PreparedStatement ps;
        try{
             ps = conexion.prepareStatement("UPDATE participantes SET nombres=?, apellidos=?, email=?, teléfono=? where id=?");
             ps.setString(1,alumno.getNombres());
             ps.setString(2,alumno.getApellidos());
             ps.setString(3,alumno.getEmail());
             ps.setInt(4, alumno.getTeléfono());
             ps.setInt(5, alumno.getId());
             ps.execute();
             return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean eliminarAlumno(int _id){
        PreparedStatement ps;
          try{
            ps = conexion.prepareStatement("DELETE FROM participantes WHERE id=?");
            ps.setInt(1,_id);
            ps.execute();
            return true;
          }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    /*validacion*/
    public boolean ingresarUsuario(String usuario, String clave){
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE email=?");
            ps.setString(1,usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                return usuario.equals(rs.getString("email")) && clave.equals(rs.getString("password"));
            }return false;           
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}



