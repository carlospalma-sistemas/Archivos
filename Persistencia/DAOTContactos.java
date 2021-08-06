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
    
    
    public ArrayList<Contacto> consultarContactos(int idBuscar, String nombreBuscar, String apellidoBuscar, String correoBuscar, int telefonoBuscar)
    {
        String sql = "SELECT id, nombre, apellido, correo, telefono FROM TContactos ";
        String sqlQuery = "";   // WHERE .........
        ArrayList<Contacto> lista = new ArrayList<Contacto>();
        if (idBuscar>0)
        {
            sqlQuery = "WHERE id LIKE '%" + idBuscar + "%' ";
        }
        if (!nombreBuscar.equals(""))
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(nombre) LIKE '%" + nombreBuscar.toLowerCase() + "%' ";
        }
        if (!apellidoBuscar.equals(""))
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(apellido) LIKE '%" + apellidoBuscar.toLowerCase() + "%' ";
        }
        if (!correoBuscar.equals(""))
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(correo) LIKE '%" + correoBuscar.toLowerCase() + "%' ";
        }
        if (telefonoBuscar>0)
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "id LIKE '%" + telefonoBuscar + "%' ";
        }
        sql += sqlQuery;
        System.out.println(sql);
        
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
        con.cerrarConexion();
        return id;
    }
    
    
    public boolean modificarContacto(Contacto c)
    {
        boolean modificado;
        String sql = "UPDATE TContactos " +
                     "SET nombre = '"+ c.getNombre() +"', apellido = '"+ c.getApellido() +"', correo = '"+ c.getCorreo() +"', telefono = "+ c.getTelefono() +" " + 
                     "WHERE id = "+ c.getId() +"";
        Conexion con = new Conexion();
        con.crearConexion();
        try
        {
            con.ejecutarUpdate(sql);
            modificado = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            modificado = false;
        }
        con.cerrarConexion();
        return modificado;
    }
    
    public boolean borrarContacto(Contacto c)
    {
        boolean borrado;
        String sql = "DELETE FROM TContactos " +
                     "WHERE id = "+ c.getId() +"";
        Conexion con = new Conexion();
        con.crearConexion();
        try
        {
            con.ejecutarUpdate(sql);
            borrado = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            borrado = false;
        }
        con.cerrarConexion();
        return borrado;
    }
}
