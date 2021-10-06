
package parcialsoftware;

/**
 * @author Jessica Albarracín
 */
public class ProductoCompra
{

    private String codigo;
    private int existencias;
    private float precio;

    public ProductoCompra()
    {
        this.codigo = "";
        this.existencias = 0;
        this.precio = 0.0f;
    }

    public ProductoCompra(String codigo, int existencias, float precio)
    {
        this.codigo = codigo;
        this.existencias = existencias;
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

    public int getExistencias()
    {
        return existencias;
    }

    public void setExistencias(int existencias)
    {
        this.existencias = existencias;
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
        return this.codigo + "," + this.existencias + "," + this.precio;
    }

}
