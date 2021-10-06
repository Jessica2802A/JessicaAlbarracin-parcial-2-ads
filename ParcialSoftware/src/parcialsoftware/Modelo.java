package parcialsoftware;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jessica Albarracín
 */
public class Modelo
{
    private Singleton single = Singleton.single();
    private ArrayList<Producto> productos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Compra> compras;

    public Modelo()
    {
        this.productos = new ArrayList<Producto>();
        this.usuarios = new ArrayList<Usuario>();
        this.compras = new ArrayList<Compra>();
        this.crearCajero();
        this.crearAdmi();
    }

    public void crearCajero()
    {
        Cajero cajero = new Cajero("Jose","Jose@gmail.com","12345678");
        
        try {
            
        this.registrarUsuario(cajero);
        } catch (Exception e) {
            
        }
    }
    
    public void crearAdmi()
    {
        Administrador admi = new Administrador("Daniel","Dani@yahoo.es","12345678");
        try {
            
        this.registrarUsuario(admi);
        } catch (Exception e) {
            
        }
    }
    
    public ProductoCompra asignarProductoComprado(String codigo, int cantidad) throws Exception
    {
        Producto elproducto;
        elproducto = this.buscarProducto(codigo);
        ProductoCompra producom;
        if (elproducto.getCantidad() >= cantidad)
        {
            producom = new ProductoCompra(elproducto.getCodigo(), cantidad, elproducto.getPrecio());
        } else
        {
            throw new Exception("No hay esa cantidad");
        }
        return producom;
    }

    public ProductoCompra buscarProductoComprado(String codigo, ArrayList<ProductoCompra> productosComprados) throws Exception
    {
        Iterator itera = productosComprados.iterator();
        while (itera.hasNext())
        {
            ProductoCompra prod = (ProductoCompra) itera.next();
            if (prod.getCodigo().equals(codigo))
            {
                return prod;
            }
        }
        throw new Exception("No hay un producto con ese codigo.");
    }

    public void eliminarProductoComprado(String codigo, ArrayList<ProductoCompra> productosComprados) throws Exception
    {
        ProductoCompra elprodu;
        elprodu = this.buscarProductoComprado(codigo, productosComprados);
        productosComprados.remove(elprodu);
    }

    public Compra buscarCompra(String documentodeidentidad) throws Exception
    {
        Iterator itera = compras.iterator();
        while (itera.hasNext())
        {
            Compra compra = (Compra) itera.next();
            if (compra.getDocumentodeidentidad().equals(documentodeidentidad))
            {
                return compra;
            }
        }
        throw new Exception("Este documento no ha realizado compras.");
    }

    public Usuario buscarCliente(String documentodeidentidad) throws Exception
    {
        Iterator itera = usuarios.iterator();
        while (itera.hasNext())
        {
            Usuario usuario = (Usuario) itera.next();
            if (usuario instanceof Cliente)
            {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getDocumentodeidentidad().equals(documentodeidentidad))
                {
                    return cliente;
                }
            }
        }
        throw new Exception("No existe un cliente con ese codigo");
    }

    public ArrayList<Compra> getCompras()
    {
        return compras;
    }
    
    public void afterCompra(String codigo, int existencias)
    {
        Iterator itera = productos.iterator();
        while (itera.hasNext())
        {
            Producto produ = (Producto) itera.next();
            if (produ.getCodigo().equals(codigo))
            {
                produ.setCantidad(produ.getCantidad() - existencias);
            }
        }
    }

    public void finalizarCompra(String documentodeidentidad, String fecha, ArrayList<ProductoCompra> productosComprados) throws Exception
    {
        int factura = this.compras.size() + 1;
        String fac = String.valueOf(factura);
        this.buscarCliente(documentodeidentidad);
        Compra compra = new Compra(documentodeidentidad, fecha, fac, productosComprados, this.gettotal(productosComprados));
        this.compras.add(compra);
        //hacer iterator para decrementar
        Iterator itera = productosComprados.iterator();
        while (itera.hasNext())
        {
            ProductoCompra prodcom = (ProductoCompra) itera.next();
            this.afterCompra(prodcom.getCodigo(), prodcom.getExistencias());
        }
    }

    public float gettotal(ArrayList<ProductoCompra> productosComprados)
    {
        float total = 0;
        Iterator itera = productosComprados.iterator();
        while (itera.hasNext())
        {
            ProductoCompra prodcom = (ProductoCompra) itera.next();
            total += prodcom.getPrecio();
        }
        return total;
    }

    public void registrarUsuario(Usuario elusuario) throws Exception
    {
        if (elusuario.getClave().length() >= 8)
        {
            Iterator itera = usuarios.iterator();
            while (itera.hasNext())
            {
                Usuario usuario = (Usuario) itera.next();
                if (usuario.getEmail().equals(elusuario.getEmail()))
                {
                    throw new Exception("Ya existe ese email.");
                }
            }
            usuarios.add(elusuario);
        } else
        {
            throw new Exception("La contraseña tiene que ser de 8 digitos");
        }
    }

    public Usuario buscarUsuario(String email, String clave) throws Exception
    {
        Iterator itera = usuarios.iterator();
        while (itera.hasNext())
        {
            Usuario usuario = (Usuario) itera.next();
            if (usuario.getEmail().equals(email) && usuario.getClave().equals(clave))
            {
                return usuario;
            }
        }
        throw new Exception("No existe un usuario con esas credenciales.");
    }

    public String validaUsuario(String correo, String clave) throws Exception
    {
        String ser = "";
        Usuario usu = this.buscarUsuario(correo, clave);
        if (usu instanceof Administrador)
        {
            return single.menuAdmi();
        } else if (usu instanceof Cajero)
        {
            return single.menuCajero();
        } else if (usu instanceof Cliente)
        {
            return single.menuCliente();
        }
        return ser;
    }
    
    public int validarUsuario(String correo, String clave) throws Exception
    {
        int ser = 0;
        Usuario usu = this.buscarUsuario(correo, clave);
        if (usu instanceof Administrador)
        {
            ser = 1;
        } else if (usu instanceof Cajero)
        {
            ser = 2;
        } else if (usu instanceof Cliente)
        {
            ser = 3;
        }
        return ser;
    }
    
    public void agregarProducto(Producto elproducto) throws Exception
    {
        Iterator itera = this.productos.iterator();
        while (itera.hasNext())
        {
            Producto estudiante = (Producto) itera.next();
            if (estudiante.getCodigo().equals(elproducto.getCodigo()))
            {
                throw new Exception("Ese codigo ya existe.");
            }
        }
        this.productos.add(elproducto);
    }

    public Producto buscarProducto(String codigo) throws Exception
    {
        Iterator itera = this.productos.iterator();
        while (itera.hasNext())
        {
            Producto elproducto = (Producto) itera.next();
            if (elproducto.getCodigo().equals(codigo))
            {
                return elproducto;
            }
        }
        throw new Exception("No hay un producto con ese codigo.");
    }
    
    public void eliminarProducto(String codigo) throws Exception
    {
        Producto elProducto;
        elProducto = this.buscarProducto(codigo);
        productos.remove(elProducto);
    }
}
