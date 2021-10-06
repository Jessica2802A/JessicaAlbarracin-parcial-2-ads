package parcialsoftware;

import java.util.ArrayList;

/**
 * @author Jessica Albarracín
 */
public class Compra
{

    private String documentodeidentidad;
    private String fecha;
    private String factura;
    private ArrayList<ProductoCompra> compras;
    private float total;

    public Compra()
    {
        this.documentodeidentidad = "";
        this.fecha = "";
        this.factura = "";
        this.compras = new ArrayList<ProductoCompra>();
        this.total = 0.0f;
    }

    public Compra(String documentodeidentidad, String fecha, String factura, ArrayList<ProductoCompra> compras, float total)
    {
        this.documentodeidentidad = documentodeidentidad;
        this.fecha = fecha;
        this.factura = factura;
        this.compras = compras;
        this.total = total;
    }

    public String getDocumentodeidentidad()
    {
        return documentodeidentidad;
    }

    public void setDocumentodeidentidad(String documentodeidentidad)
    {
        this.documentodeidentidad = documentodeidentidad;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getFactura()
    {
        return factura;
    }

    public void setFactura(String factura)
    {
        this.factura = factura;
    }

    public ArrayList<ProductoCompra> getCompras()
    {
        return compras;
    }

    public void setCompras(ArrayList<ProductoCompra> compras)
    {
        this.compras = compras;
    }

    public float getTotal()
    {
        return total;
    }

    public void setTotal(float total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        return this.documentodeidentidad + "," + this.factura + "," + this.fecha + "," + this.compras + ","
                + this.total;
    }

}
