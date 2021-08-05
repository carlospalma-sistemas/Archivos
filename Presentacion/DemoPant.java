package Presentacion;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DemoPant extends JFrame implements ActionListener
{
    JButton button1;
    JButton button2;
    
    public DemoPant()
    {
        setTitle("Hola");
        setBounds(250, 200, 600, 480);
        setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0, 500, 300);
        getContentPane().add(tabbedPane);
        
        button1 = new JButton("Aceptar");
        button1.setBounds(50,350,150,50);
        button1.addActionListener(this);
        getContentPane().add(button1);
        
        button2 = new JButton("Cancelar");
        button2.setBounds(250,350,150,50);
        button2.addActionListener(this);
        getContentPane().add(button2);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        tabbedPane.addTab("Tab 1", null, panel1, "Este es el tab 1");

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        tabbedPane.addTab("Tab 2", null, panel2, "Este es el tab 2");
        
        JLabel lblHola = new JLabel("Hola mundo");
        lblHola.setBounds(50, 50, 100, 30);
        panel1.add(lblHola);
        
        JTextField txtMensaje = new JTextField();
        txtMensaje.setBounds(50, 50, 100, 30);
        panel2.add(txtMensaje);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button1) 
        {
            System.out.println("a");   
        }
        else if(e.getSource() == button2) 
        {
            System.out.println("b");   
        }
        
    }
}
