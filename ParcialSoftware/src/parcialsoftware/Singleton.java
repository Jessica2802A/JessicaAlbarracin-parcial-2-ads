/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialsoftware;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author jessa
 */
public class Singleton {
    private static Singleton instanciaunica = null;
    
    private Singleton() {
    }

    public static Singleton single() {
        if (instanciaunica == null) {
            instanciaunica = new Singleton();
        }
        return instanciaunica;
    }
    
    public String getHora()
    {
        String tiempo = "";
        Locale locale1 = Locale.CANADA;
        TimeZone tz1 = TimeZone.getTimeZone("GMT-5");
        Calendar c = Calendar.getInstance(tz1, locale1);
        String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        int minutos = c.get(Calendar.MINUTE);
        int segundos = c.get(Calendar.SECOND);
        tiempo = hora + ":" + minutos + ":" + segundos;
        return tiempo;
    }
    public boolean seguridad(int clave)
    {
        if (clave==317853) {
            return true;
        }
        return false;
    }
    
    public String inicio()
    {
        String inicio;
        inicio="Digite la opcion que desea: "
                + "\n 1. Inicia sesion" 
                + "\n 2. Crear cuenta"
                + "\n 0. Salir" ;
        return inicio;
    }
    
    public String menucompra()
    {
        String inicio;
        inicio="Digite la opcion que desea: "
                + "\n 1. Añadir producto a la compra" 
                + "\n 2. Eliminar producto de la lista"
                + "\n 0. Salir" ;
        return inicio;
    }
    
    public String Correo()
    {
        return "Digite su correo";
    }
    
    public String clave()
    {
        return "Digite su Clave";
    }
    
    public String nombre()
    {
        return "Digite su nombre";
    }
    
    public String id()
    {
        return "Digite el documento de identidad";
    }
    
    public String CodProducto()
    {
        return "Digite el código del producto";
    }
    
    public String precio()
    {
        return "Digite el precio del producto";
    }
    
    public String Cantidad()
    {
        return "Digite la cantidad de unidades del producto";
    }
    
    public String menuAdmi()
    {
        Administrador admi = new Administrador();
        return admi.menu();
    }
    
    public String menuCliente ()
    {
        Cliente cli = new Cliente();
        return cli.menu();
    }
    
    public String menuCajero()
    {
        Cajero cajero = new Cajero();
        return cajero.menu();
    }
}
