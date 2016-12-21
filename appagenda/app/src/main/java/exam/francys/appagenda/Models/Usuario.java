package exam.francys.appagenda.Models;

/**
 * Created by Francys on 20/12/2016.
 */

public class Usuario {

    private    String  ID;
    private    String  Nombre;
    private    String  App;
    private    String  Direccion;
    private    String  Correo;
    private    String  Telefono;
    private    String  Estado;
    private    String  Usuario;
    private    String  Contrase ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApp() {
        return App;
    }

    public void setApp(String app) {
        App = app;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }


    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrase() {
        return Contrase;
    }

    public void setContrase(String contrase) {
        Contrase = contrase;
    }
}
