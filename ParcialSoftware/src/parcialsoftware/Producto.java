
package parcialsoftware;

/**
 *
 * @author Jessica Albarracín
 */
public class Producto
{
    private String codigo;
    private String nombre;
    private int cantidad;
    private float precio;
    
    public Producto()
    {
        this.codigo = "";
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0f;
    }

    public Producto(String codigo, String nombre, int cantidad, float precio)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    @Override
    public String toString()
    {
        return this.codigo +","+ this.nombre+","+this.cantidad+","+this.precio;
    }
}
