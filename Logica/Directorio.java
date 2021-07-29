package Logica;
import java.util.ArrayList;
import Persistencia.DAOContactos;

public class Directorio
{
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    
    public void addContacto(Contacto c)
    {
        contactos.add(c);
    }
    
    public ArrayList<Contacto> getContactos()
    {
        return this.contactos;
    }
      
    public Contacto getContacto(int index)
    {
        return this.contactos.get(index);
    }
    
    public void deleteContacto(int index)
    {
        this.contactos.remove(index);
    }
    
    public int getSize()
    {
        return this.contactos.size();
    }
    
    public void guardarContactos()
    {
        DAOContactos dao = new DAOContactos();
        dao.guardarTodosLosContactos(this);
    }
    
    public void leerContactos()
    {
        DAOContactos dao = new DAOContactos();
        this.contactos = dao.leerTodosLosContactos();
    }
}
