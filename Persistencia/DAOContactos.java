package Persistencia;
import Logica.Contacto;
import Logica.Directorio;
import java.util.ArrayList;

public class DAOContactos
{
    public String convertirContactoACSV(Contacto c)
    {
        String texto = c.getNombre() + ";" + c.getApellido() + ";" + c.getCorreo() + ";" + c.getTelefono();
        return texto;
    }
    
    public Contacto convertirCSVAContacto(String texto)
    {
        String [] textoSeparado = texto.split(";");
        Contacto c = new Contacto();
        c.setNombre(textoSeparado[0]);
        c.setApellido(textoSeparado[1]);
        c.setCorreo(textoSeparado[2]);
        c.setTelefono(Integer.parseInt(textoSeparado[3]));
        return c;
    }
    
    public void guardarTodosLosContactos(Directorio dir)
    {
        String todoElTexto = "";
        for (Contacto c : dir.getContactos())
        {
            todoElTexto = todoElTexto + convertirContactoACSV(c) + "\n";
        }
        Archivo a = new Archivo();
        a.escribir(todoElTexto);
    }

    public ArrayList<Contacto> leerTodosLosContactos()
    {
        ArrayList<Contacto> contactosAPasar = new ArrayList<Contacto>();
        Archivo a = new Archivo();
        String todoElTexto = a.leer();
        String[] renglones = todoElTexto.split("\n");
        for (String renglon : renglones)
        {
            Contacto c = convertirCSVAContacto(renglon);
            contactosAPasar.add(c);
        }
        return contactosAPasar;
    }
}
