package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Directorio;
import Logica.Contacto;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class PantallaGrafica extends JFrame implements ActionListener
{
    JButton btnListar;
    JButton btnFiltrar;
    JButton btnIngresar;
    JButton btnModificar;
    JButton btnBorrar;
    JTextField txtNombre, txtApellido, txtCorreo, txtTelefono;
    private Directorio directorio = new Directorio();
    
    public PantallaGrafica()
    {
        directorio.leerContactos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setTitle("Directorio telefónico");
        setBounds(100, 50, 800, 600);
        setLayout(null);
        
        JLabel lblMenu = new JLabel("MENU PRINCIPAL");
        lblMenu.setBounds(50, 50, 200, 30);        
        add(lblMenu);
        
        btnListar = new JButton("Listar contactos");
        btnListar.setBounds(50, 100, 150, 30);
        btnListar.addActionListener(this);
        add(btnListar);
        
        btnFiltrar = new JButton("Filtrar contactos");
        btnFiltrar.setBounds(50, 150, 150, 30);
        btnFiltrar.addActionListener(this);
        add(btnFiltrar);
        
        btnIngresar = new JButton("Insertar contactos");
        btnIngresar.setBounds(50, 200, 150, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,0));
        panel.setBounds(300, 100, 400, 200);
        
        Object[][] data = directorio.getMatrizContactos();
        String[] columnNames = {"Id", "Nombres", "Apellidos", "Correo", "Telefono"};     
        DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
        
        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(600, 200));
        tabla.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll);
        add(panel);
        
        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBounds(300, 320, 400, 200);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50, 20, 150, 30);
        formulario.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 150, 30);
        formulario.add(txtNombre);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(50, 60, 150, 30);
        formulario.add(lblApellido);
        
        txtApellido = new JTextField();
        txtApellido.setBounds(150, 60, 150, 30);
        formulario.add(txtApellido);
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(50, 100, 150, 30);
        formulario.add(lblCorreo);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 100, 150, 30);
        formulario.add(txtCorreo);
        
        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(50, 140, 150, 30);
        formulario.add(lblTelefono);
        
        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 140, 150, 30);
        formulario.add(txtTelefono);
        
        add(formulario);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnListar)
        {
            listarContactos();
        }
        if (e.getSource() == btnFiltrar)
        {
            filtrarContactos();
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
    
    
    public void filtrarContactos()
    {
        
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese id de contacto a filtrar", 0));
        String nombreBuscar = JOptionPane.showInputDialog(null, "Ingrese nombre de contacto a filtrar");
        String apellidoBuscar = JOptionPane.showInputDialog(null, "Ingrese apellido de contacto a filtrar");
        String correoBuscar = JOptionPane.showInputDialog(null, "Ingrese correo de contacto a filtrar");
        int telefonoBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese teléfono de contacto a filtrar", 0));
        
        directorio.leerContactos(idBuscar, nombreBuscar, apellidoBuscar, correoBuscar, telefonoBuscar);
        String mensaje = "";
        for (int i = 0; i < directorio.getSizeFiltro() ; i++)
        {
            mensaje = mensaje + i + ") " + directorio.getContactoFiltrado(i) + "\n";
        }
        if (directorio.getSizeFiltro() == 0)
        {
            mensaje = "No hay contactos que cumplan con el filtro registrado";
        }
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    
    public void ingresarContacto()
    {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        int telefono = Integer.parseInt(txtTelefono.getText());
        
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
