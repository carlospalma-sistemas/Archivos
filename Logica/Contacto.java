package Logica;

public class Contacto
{
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;

    public Contacto()
    {
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.telefono = 0;
    }
    
    public Contacto(String nombre, String apellido, String correo, int telefono)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Contacto(int id, String nombre, String apellido, String correo, int telefono)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    
    public Object[] getArrayContacto()
    {
        Object[] r = {id, nombre, apellido, correo, telefono};
        return r;
    }
    
    public String toString()
    {
        return "[" + this.id + "] " + this.nombre + " " + this.apellido + " - Correo: " + this.correo + " - Teléfono: " + this.telefono;
    }
}

