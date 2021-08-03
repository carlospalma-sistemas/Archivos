package Persistencia;
import Logica.Contacto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOTContactos
{
    public ArrayList<Contacto> consultarContactos()
    {
        ArrayList<Contacto> lista = new ArrayList<Contacto>();
        String sql = "SELECT id, nombre, apellido, correo, telefono FROM TContactos";
        Conexion con = new Conexion();
        con.crearConexion();
        try
        {
            ResultSet rs = con.ejecutarQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                int telefono = rs.getInt("telefono");
                Contacto c = new Contacto(id, nombre, apellido, correo, telefono);
                lista.add(c);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        con.cerrarConexion();
        return lista;
    }
    
    
    public int insertarContacto(Contacto c)
    {
        int id = 0;
        String sql = "INSERT INTO TContactos (nombre, apellido, correo, telefono) " + 
                     "VALUES ('"+ c.getNombre() +"', '"+ c.getApellido() +"', '"+ c.getCorreo() +"', "+ c.getTelefono() +")";
        Conexion con = new Conexion();
        con.crearConexion();
        try
        {
            ResultSet rs = con.ejecutarUpdate(sql);
            if(rs.next())
            {
                id = rs.getInt(1); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }
    
    
    public void modificarContacto(Contacto c)
    {
        String sql = "UPDATE TContactos " +
                     "SET nombre = '"+ c.getNombre() +"', apellido = '"+ c.getApellido() +"', correo = '"+ c.getCorreo() +"', telefono = "+ c.getTelefono() +" " + 
                     "WHERE id = "+ c.getId() +"";
        //ENVIAR SQL
        //RECIBIR LAS FILAS AFECTADAS
        //SI CANT > 0
           //SI SE PUDO HACER LA MODIFICAICON
        //SI NO 
           //NO SE PUDO HACER LA MODIFICACION
    }
    
    public void borrarContacto(Contacto c)
    {
        String sql = "DELETE FROM TContactos " +
                     "WHERE id = "+ c.getId() +"";
        //ENVIAR SQL
        //RECIBIR LAS FILAS AFECTADAS
        //SI CANT > 0
           //SI SE PUDO HACER LA eliminación
        //SI NO 
           //NO SE PUDO HACER LA eliminación
    }
}
