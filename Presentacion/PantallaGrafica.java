package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Directorio;
import Logica.Contacto;

public class PantallaGrafica extends JFrame implements ActionListener
{
    JButton btnListar;
    JButton btnIngresar;
    JButton btnModificar;
    JButton btnBorrar;
    private Directorio directorio = new Directorio();
    
    public PantallaGrafica()
    {
        directorio.leerContactos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setTitle("Directorio telefónico");
        setBounds(100, 50, 600, 480);
        setLayout(null);
        
        JLabel lblMenu = new JLabel("MENU PRINCIPAL");
        lblMenu.setBounds(50, 50, 200, 30);        
        add(lblMenu);
        
        btnListar = new JButton("Listar contactos");
        btnListar.setBounds(50, 100, 150, 30);
        btnListar.addActionListener(this);
        add(btnListar);
        
        btnIngresar = new JButton("Ingresar contactos");
        btnIngresar.setBounds(50, 150, 150, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnListar)
        {
            listarContactos();
        }
        else if (e.getSource() == btnIngresar)
        {
            ingresarContacto();
        }
        
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
        JOptionPane.showMessageDialog(this, mensaje);
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
            JOptionPane.showMessageDialog(this, "Contacto agregado");    
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Contacto no agregado. Intente de nuevo");    
        }
    }
}
