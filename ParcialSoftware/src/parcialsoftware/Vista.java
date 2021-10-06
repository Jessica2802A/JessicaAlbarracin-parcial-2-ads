package parcialsoftware;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Jessica Albarracín
 */
public class Vista
{
    public String leerporDialogo(String mensaje) throws Exception
    {
        String a;
        a = JOptionPane.showInputDialog(mensaje);
        if (a.equals(""))
        {
            throw new Exception("Por favor digite un caracter.");
        }
        return a;
    }
    
    public void salidaporDialogo(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void salidaporConsola(String mensaje)
    {
        System.out.println(mensaje);
    }
}
