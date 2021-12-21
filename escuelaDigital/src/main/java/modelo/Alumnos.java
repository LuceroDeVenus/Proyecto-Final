package modelo;


public class Alumnos {
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private int teléfono;

    public Alumnos(int i, String nombres, String apellidos, String email, String teléfono) {
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

    public int getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(int teléfono) {
        this.teléfono = teléfono;
    }
    
    public Alumnos(int id,String n, String apellidos,
            String email,int teléfono){
        this.id=id;
        this.nombres=n;
        this.apellidos=apellidos;
        this.email=email;
        this.teléfono=teléfono;
    }

  
    
}