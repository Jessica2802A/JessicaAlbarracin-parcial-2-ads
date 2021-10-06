package parcialsoftware;

/**
 * @author Jessica Albarracín
 */
public class Cajero extends Usuario
{

    public Cajero()
    {
        super();
    }

    public Cajero(String nombre, String email, String clave)
    {
        super(nombre, email, clave);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public String menu()
    {
        return "1. Crear Venta"
                + "\n 0. Cerrar cesion.";
    }

}
