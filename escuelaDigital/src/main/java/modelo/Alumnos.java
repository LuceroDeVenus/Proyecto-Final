package modelo;


public class Alumnos {
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private int telefono;

    public Alumnos(int i, String nombres, String apellidos, String email, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public Alumnos(int id,String n, String apellidos,
            String email,int telefono){
        this.id=id;
        this.nombres=n;
        this.apellidos=apellidos;
        this.email=email;
        this.telefono=telefono;
    }

  
    
}