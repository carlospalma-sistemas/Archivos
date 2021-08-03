package Persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Logica.Contacto;

public class DAOEjemplo
{
    Conexion con = new Conexion();
    
    public void consultarContactos()
    {
        //ENVIAR SQL
        //RECIBIR RESULTSET
        //RECORRER RESULTSET
            //ARMAR CADA CONTACTO E INCLUIRLO EN MI ESTRUCTURA 
                
        try
        {
            con.crearConexion();
            String sql = "SELECT id, nombre, apellido, correo, telefono FROM TContactos";
            ResultSet rs = con.ejecutarQuery(sql);
            System.out.println("DATOS REGISTRADOS:");
            while(rs.next())
            {
                System.out.println("id = " + rs.getInt(1) + ", " +"nombre = " + rs.getString(2));
            }
            rs.close();
            con.cerrarConexion();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    
    public void insertarContacto()
    {
        //ENVIAR SQL
        //RECIBIR LAS FILAS AFECTADAS
        //SI CANT > 0
           //SI SE PUDO HACER LA INSERCIÓN
           //OBTENER EL ID QUE SE CREO
        //SI NO 
           //NO SE PUDO HACER LA INSERCIÓN
           
        try
        {
            con.crearConexion();
            Contacto c = new Contacto("Sergio Andrés", "Palma Torres", "sergio@uis.edu.co", 11041);
            String sql = "INSERT INTO TContactos (nombre, apellido, correo, telefono) " + 
                     "VALUES ('"+ c.getNombre() +"', '"+ c.getApellido() +"', '"+ c.getCorreo() +"', "+ c.getTelefono() +")";
            ResultSet rs = con.ejecutarUpdate(sql);
            while(rs.next())
            {
                c.setId(rs.getInt(1));
            }
            con.cerrarConexion();
            System.out.println("Dato ingresado: "+c);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void modificarContactos(Contacto c)
    {
        String sql = "UPDATE TContactos " +
                     "SET nombre = 'Carlos Andrés', apellido = 'Palma', correo = 'carlos@uis.edu', telefono = 55555 " + 
                     "WHERE id = 1";
        //ENVIAR SQL
        //RECIBIR LAS FILAS AFECTADAS
        //SI CANT > 0
           //SI SE PUDO HACER LA INSERCIÓN
        //SI NO 
           //NO SE PUDO HACER LA INSERCIÓN
    }
}
