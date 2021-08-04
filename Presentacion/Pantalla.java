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
            "Modificar contacto",
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
                listarContactos();
            }
            else if (opcion.equals(opciones[1]))
            {
                ingresarContacto();
            }
            else if (opcion.equals(opciones[2]))
            {
                modificarContacto();
            }
            else if (opcion.equals(opciones[3]))
            {
                borrarContacto();   
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            }
        } while(true);
    }
    
    
    public void listarContactos()
    {
        directorio.leerContactos();
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
    
    
    public void ingresarContacto()
    {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de nuevo contacto");
        String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido de nuevo contacto");
        String correo = JOptionPane.showInputDialog(null, "Ingrese correo de nuevo contacto");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese teléfono de nuevo contacto"));
        
        Contacto c = new Contacto(nombre, apellido, correo, telefono);
        boolean guardado = directorio.guardarContacto(c);
        if (guardado == true)
        {
            JOptionPane.showMessageDialog(null, "Contacto agregado");    
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Contacto no agregado. Intente de nuevo");    
        }
    }
    
    
    public void modificarContacto()
    {
        listarContactos();
        if (directorio.getSize()==0) return;
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese índice de contacto para modificar"));
        if (index < 0 || index > directorio.getSize() - 1)
        {
            JOptionPane.showMessageDialog(null, "No se puede modificar contacto");
        }
        else 
        {
            Contacto c = directorio.getContacto(index);
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de contacto a modificar", c.getNombre());
            String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido de contacto a modificar", c.getApellido());
            String correo = JOptionPane.showInputDialog(null, "Ingrese correo de contacto a modificar", c.getCorreo());
            int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese teléfono de contacto a modificar", c.getTelefono()));
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setCorreo(correo);
            c.setTelefono(telefono);
            directorio.actualizarContacto(index, c);
            JOptionPane.showMessageDialog(null, "Contacto actualizado");
        }
    }
    
    
    public void borrarContacto()
    {
        listarContactos();
        if (directorio.getSize()==0) return;
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese índice de contacto para borrar"));
        if (index < 0 || index > directorio.getSize() - 1)
        {
            JOptionPane.showMessageDialog(null, "No se puede borrar contacto");
        }
        else 
        {
            directorio.borrarContacto(index);  
            JOptionPane.showMessageDialog(null, "Contacto borrado");
        }
    }
}
