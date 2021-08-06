package Logica;
import java.util.ArrayList;
import Persistencia.DAOTContactos;

public class Directorio
{
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    private ArrayList<Contacto> contactosFiltrados = new ArrayList<Contacto>();
    
    public void addContacto(Contacto c)
    {
        contactos.add(c);
    }
    
    public Object[][] getMatrizContactos()
    {
        Object[][] matriz = new Object[getSize()][5];
        for (int i=0; i<getSize(); i++)
        {
            matriz[i] = getContacto(i).getArrayContacto();
        }
        return matriz;
    }
    
    public ArrayList<Contacto> getContactos()
    {
        return this.contactos;
    }
      
    public Contacto getContacto(int index)
    {
        return this.contactos.get(index);
    }
    
    public Contacto getContactoFiltrado(int index)
    {
        return this.contactosFiltrados.get(index);
    }
    
    public void setContacto(int index, Contacto c)
    {
        this.contactos.set(index, c);
    }
    
    public void deleteContacto(int index)
    {
        this.contactos.remove(index);
    }
    
    public int getSize()
    {
        return this.contactos.size();
    }
    
    public int getSizeFiltro()
    {
        return this.contactosFiltrados.size();
    }
    
    public boolean guardarContacto(Contacto c)
    {
        DAOTContactos dao = new DAOTContactos();
        int id = dao.insertarContacto(c);
        if (id >0 )
        {
            c.setId(id);
            addContacto(c);
            return true;
        }
        else {
            return false;
        }
    }
    
    public void leerContactos()
    {
        DAOTContactos dao = new DAOTContactos();
        this.contactos = dao.consultarContactos();
    }
    
    public void leerContactos(int id, String nombre, String apellido, String correo, int telefono)
    {
        DAOTContactos dao = new DAOTContactos();
        this.contactosFiltrados = dao.consultarContactos(id, nombre, apellido, correo, telefono);
    }
    
    
    public void actualizarContacto(int index, Contacto c)
    {
        DAOTContactos dao = new DAOTContactos();
        boolean modificado = dao.modificarContacto(c);
        if (modificado == true)
        {
            setContacto(index, c);
        }
    }
    
    public void borrarContacto(int index)
    {
        DAOTContactos dao = new DAOTContactos();
        boolean borrado = dao.borrarContacto(getContacto(index));
        if (borrado == true)
        { 
            deleteContacto(index);
        }
    }
}
