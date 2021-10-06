
package parcialsoftware;

/**
 * @author Jessica Albarracín
 */
public class Administrador extends Usuario
{

    public Administrador()
    {
        super();
    }

    public Administrador(String nombre, String email, String clave)
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
        return "1. Crear Producto"
                + "\n 2. Buscar Producto"
                + "\n 3. Eliminar Producto"
                + "\n 4. Consultar Compra segun documento de identidad del cliente"
                + "\n 0. Cerrar cesion";
    }
}
