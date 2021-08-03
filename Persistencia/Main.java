package Persistencia;

public class Main
{
    public static void main(String [] args)
    {
         DAOEjemplo dao = new DAOEjemplo();
         dao.consultarContactos();
         dao.insertarContacto();
         dao.consultarContactos();
    }
}

