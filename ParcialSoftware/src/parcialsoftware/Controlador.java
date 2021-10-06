package parcialsoftware;

import java.util.ArrayList;

/**
 *
 * @author Jessica Albarracín
 */
public class Controlador {

    private Singleton single;
    private Modelo elmodelo;
    private Vista lavista;

    public Controlador() {
        this.single = Singleton.single();
        this.elmodelo = new Modelo();
        this.lavista = new Vista();
    }

    public void iniciarsesion() {
        String Opcion = "";
        do {
            try {
                Opcion = lavista.leerporDialogo(this.single.inicio());
                if (Opcion.equals("1")) {
                    String correo = lavista.leerporDialogo(single.Correo()), clave = lavista.leerporDialogo(single.clave());
                    elmodelo.buscarUsuario(correo, clave);
                    this.cuenta(elmodelo.validarUsuario(correo, clave), correo, clave);
                } else if (Opcion.equals("2")) {
                    String correo = lavista.leerporDialogo(single.Correo()),
                            clave = lavista.leerporDialogo(single.clave()),
                            nombre = lavista.leerporDialogo(single.nombre()),
                            id = lavista.leerporDialogo(single.id());
                    //Solo se crean clientes porque el cajero y el admi, tienen que crearse directamente en la BD y no desde la Interfaz.
                    elmodelo.registrarUsuario(new Cliente((String.valueOf(id)), nombre, correo, clave));
                } else if (Opcion.equals("0")) {
                    lavista.salidaporDialogo("Volviendo a menu principal.");
                }
            } catch (Exception ex) {
                lavista.salidaporDialogo(ex.toString());
            }
        } while (!Opcion.equals("0"));
    }

    public void cuenta(int tipo, String correo, String clave) {

        try {
            if (tipo == 1) {
                this.menuAdmi(correo, clave);
            } else if (tipo == 2) {
                this.menuCajero(correo, clave);
            } else if (tipo == 3) {
                this.menuCliente(correo, clave);
            }
        } catch (Exception ex) {
            lavista.salidaporDialogo(ex.toString());
        }
    }

    public void menuAdmi(String correo, String clave) {
        String Opcion = "";
        do {
            try {
                Opcion = lavista.leerporDialogo(elmodelo.validaUsuario(correo, clave));
                if (Opcion.equals("1")) {
                    String id = lavista.leerporDialogo(single.CodProducto()),
                            nombre = lavista.leerporDialogo(single.nombre());
                    int cantidad = Integer.parseInt(lavista.leerporDialogo(single.Cantidad()));
                    float precio = Float.parseFloat(lavista.leerporDialogo(single.precio()));
                    Producto produ = new Producto(id, nombre, cantidad, precio);
                    elmodelo.agregarProducto(produ);
                } else if (Opcion.equals("2")) {
                    String id = lavista.leerporDialogo(single.CodProducto());
                    lavista.salidaporDialogo(this.elmodelo.buscarProducto(id).toString());
                } else if (Opcion.equals("3")) {
                    String id = lavista.leerporDialogo(single.CodProducto());
                    this.elmodelo.eliminarProducto(id);
                    lavista.salidaporDialogo("Producto eliminado");
                } else if (Opcion.equals("4")) {
                    String cedula = lavista.leerporDialogo(single.id());
                    lavista.salidaporDialogo(this.elmodelo.buscarCompra(cedula).toString());
                } else if (Opcion.equals("0")) {
                    lavista.salidaporDialogo("Volviendo a menu principal.");
                }
            } catch (Exception ex) {
                lavista.salidaporDialogo(ex.toString());
            }
        } while (!Opcion.equals("0"));
    }

    public void menuCajero(String correo, String clave) {
        String Opcion = "";
        int p = 0;
        ArrayList<ProductoCompra> recibo = new ArrayList<ProductoCompra>();
        do {
            try {
                Opcion = lavista.leerporDialogo(elmodelo.validaUsuario(correo, clave));
                if (Opcion.equals("1")) {

                    String OpcionP = "";
                    do {
                        OpcionP = lavista.leerporDialogo(single.menucompra());
                        if (OpcionP.equals("1")) {
                            String id = lavista.leerporDialogo(single.CodProducto());
                            int existencias = Integer.parseInt(lavista.leerporDialogo(single.Cantidad()));
                            recibo.add(this.elmodelo.asignarProductoComprado(id, existencias));
                            this.elmodelo.afterCompra(id, existencias);
                            p++;
                        } else if (OpcionP.equals("2")) {
                            if (p == 0) {
                                String id = lavista.leerporDialogo(single.CodProducto());
                                this.elmodelo.buscarProductoComprado(id, recibo);
                                elmodelo.eliminarProductoComprado(id, recibo);
                            }
                        } else if (OpcionP.equals("0")) {
                            String persona = lavista.leerporDialogo(single.id());
                            this.elmodelo.buscarCliente(persona);
                            this.elmodelo.finalizarCompra(persona, single.getHora(), recibo);
                            lavista.salidaporConsola(single.getHora());
                            lavista.salidaporDialogo("Factura terminada.");
                            lavista.salidaporDialogo("Volviendo a menu principal.");
                        }
                    } while (!OpcionP.equals("0"));
                } else if (Opcion.equals("0")) {
                    lavista.salidaporDialogo("Volviendo a menu principal.");
                }
            } catch (Exception ex) {
                lavista.salidaporDialogo(ex.toString());
            }
        } while (!Opcion.equals("0"));
    }

    public void menuCliente(String correo, String clave) {
        String Opcion = "";
        do {
            try {
                Opcion = lavista.leerporDialogo(elmodelo.validaUsuario(correo, clave));
                if (Opcion.equals("1")) {
                    String id = lavista.leerporDialogo(single.CodProducto());
                    lavista.salidaporDialogo(this.elmodelo.buscarProducto(id).toString());
                } else if (Opcion.equals("2")) {
                    String cedula = lavista.leerporDialogo(single.id());
                    lavista.salidaporDialogo(this.elmodelo.buscarCompra(cedula).toString());
                } else if (Opcion.equals("0")) {
                    lavista.salidaporDialogo("Volviendo a menu principal.");
                }
            } catch (Exception ex) {
                lavista.salidaporDialogo(ex.toString());
            }
        } while (!Opcion.equals("0"));
    }
}
