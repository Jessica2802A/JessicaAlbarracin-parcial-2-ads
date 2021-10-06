
package parcialsoftware;

/**
 * @author Jessica Albarracín
 */
public class Cliente extends Usuario
{

    private String documentodeidentidad;

    public Cliente()
    {
        super();
        this.documentodeidentidad = "";
    }

    public Cliente(String documentodeidentidad, String nombre, String email, String clave)
    {
        super(nombre, email, clave);
        this.documentodeidentidad = documentodeidentidad;
    }

    public String getDocumentodeidentidad()
    {
        return documentodeidentidad;
    }

    public void setDocumentodeidentidad(String documentodeidentidad)
    {
        this.documentodeidentidad = documentodeidentidad;
    }

    @Override
    public String toString()
    {
        return this.documentodeidentidad + "," + super.toString();
    }

    @Override
    public String menu()
    {
        return "1. Consultar caracteristicas de un Producto"
                + "\n 2. Consultar última compra"
                + "\n 0. Cerrar cesion";
    }

}
