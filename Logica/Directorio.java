package Logica;
import java.util.ArrayList;

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
}
