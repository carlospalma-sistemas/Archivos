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
        directorio.leerContactos();
        String [] opciones = {
            "Listar contactos",
            "Ingresar nuevo contacto",
            "Borrar contacto",
            "Salir"
        };
        do
        {
            String opcion = (String)JOptionPane.showInputDialog(null,
                                                    "Seleccione opción", 
                                                    "Menú principal", 
                                                    JOptionPane.DEFAULT_OPTION, 
                                                    null, 
                                                    opciones, 
                                                    opciones[0]);
        
            if (opcion.equals(opciones[0]))
            {
                String mensaje = "";
                for (int i = 0; i < directorio.getSize() ; i++)
                {
                    mensaje = mensaje + i + ") " + directorio.getContacto(i) + "\n";
                }
                if (directorio.getSize() == 0)
                {
                    mensaje = "No hay contactos registrados";
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
                directorio.guardarContactos();
                JOptionPane.showMessageDialog(null, "Contacto agregado");
            }
            else if (opcion.equals(opciones[2]))
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese índice de contacto para borrar"));
                if (index < 0 || index > directorio.getSize() - 1)
                {
                    JOptionPane.showMessageDialog(null, "No se puede borrar contacto");
                }
                else 
                {
                    directorio.deleteContacto(index);  
                    JOptionPane.showMessageDialog(null, "Contacto borrado");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            }
        } while(true);
    }
}
