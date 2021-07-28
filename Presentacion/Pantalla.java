package Presentacion;
import javax.swing.JOptionPane;
import Logica.Directorio;
import Logica.Contacto;
import java.util.ArrayList;

public class Pantalla
{
    private Directorio directorio = new Directorio();
    
    public void presentarMenu()
    {
        String [] opciones = {
            "Listar contactos",
            "Ingresar nuevo contacto",
            "Borrar contacto",
            "Salir"
        };
        String opcion = (String)JOptionPane.showInputDialog(null,
                                                    "Seleccione opción", 
                                                    "Menú principal", 
                                                    JOptionPane.DEFAULT_OPTION, 
                                                    null, 
                                                    opciones, 
                                                    opciones[0]);
        do
        {
            if (opcion.equals(opciones[0]))
            {
                ArrayList<Contacto> contactos = directorio.getContactos();
                String mensaje = "";
                for (int i = 0; i < contactos.size() ; i++)
                {
                    mensaje = mensaje + i + ") " + directorio.getContacto(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);
            }
            else if (opcion.equals(opciones[1]))
            {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de nuevo contacto");
                String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido de nuevo contacto");
                String correo = JOptionPane.showInputDialog(null, "Ingrese correo de nuevo contacto");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese teléfono de nuevo contacto"));
                Contacto c = new Contacto(nombre, apellido, correo, telefono);
                directorio.addContacto(c);
            }
            else if (opcion.equals(opciones[2]))
            {
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            }
        } while(true);
    }
}
