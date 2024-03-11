package co.edu.uniquindio.inventariotienda.model;

import java.io.Serializable;
import java.util.*;

public class Tienda implements Serializable {


    private HashMap<String, Producto> productos = new HashMap<>();
    private HashMap<String, Cliente> clientes = new HashMap<>();

    private List <Venta> ventas = new ArrayList<>();

    private HashSet <CarritoCompras> carritosCompras = new HashSet<>();



    /////////////////////////////////////////Producto////////////////////////////////////////////////////////////////
    public boolean existeProducto (String codigo ){
       if  ( productos.containsKey(codigo)){
            return true;
        }
       return false;
    }

    public Producto buscarProducto(String codigo){
        return productos.get(codigo);
    }

    public Producto crearProducto(String codigo, String nombre, int cantidad, double precio, CarritoCompras carrito, DetalleVenta detalleVenta) throws Exception {
        if (!existeProducto(codigo)) {
            Producto producto = new Producto(codigo, nombre, cantidad, precio, carrito, detalleVenta);
            productos.put(codigo, producto);
            return producto;
        } else {
            throw new Exception("El Producto ya existe");
        }
    }

    public void eliminarProducto(String codigo) {
        productos.remove(codigo);
        System.out.println("El producto " + codigo + " ha sido eliminado.");
        System.out.println(productos.size());
    }

    public void actualizarProducto(Producto producto, int cantidad, double precio) throws Exception {
        if(cantidad >= 0){
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
        }
        else{
            throw new Exception("La cantidad ingresada no es valida");
        }
    }

    /////////////////////////////////////////Cliente////////////////////////////////////////////////////////////////


    public boolean existeCliente (String numeroIdentificacion ){

        if  ( clientes.containsKey(numeroIdentificacion)){
            return true;
        }
        return false;
    }

    public Cliente crearCliente(String nombre, String numeroIdentificacion, String direccion, HashMap<String, Venta> ventas, CarritoCompras carritoCompras) throws Exception {
        if (!existeCliente(numeroIdentificacion)) {
            Cliente cliente = new Cliente(nombre, numeroIdentificacion, direccion, ventas, carritoCompras);
            clientes.put(numeroIdentificacion, cliente);
            return cliente;
        } else {
            throw new Exception("El cliente ya existe");
        }
    }

    public  void eliminarCliente( String id) {
        clientes.remove(id);
    }


    /**
     * El metodo actualiza la PII del cliente.
     * @param clienteActualizado
     * @param clienteSeleccionado
     */
    public void actualizarCliente(Cliente clienteActualizado, Cliente clienteSeleccionado){
        clienteSeleccionado.updateInfo(clienteActualizado);
    }

    /////////////////////////////////////////Venta////////////////////////////////////////////////////////////////


    public Venta crearVenta (String codigo, String fecha, double total, DetalleVenta detallesVentas, CarritoCompras carritoCompras, Cliente cliente){
        Venta venta = new Venta(codigo, fecha, total, detallesVentas, carritoCompras, cliente);
        ventas.add(venta);
        return venta;
    }

    public void eliminarVenta(String code){
        Iterator<Venta> iterator = ventas.iterator();
        while (iterator.hasNext()) {
            Venta venta = iterator.next();
            if (venta.getCodigo().equals(code)) {
                iterator.remove();
                System.out.println("La venta  " + code + " ha sido eliminada.");
                return; // Terminar después de eliminar al cliente
            }
        }
        System.out.println("La venta " + code + " no fue encontrada.");
    }


    /////////////////////////////////////////CarritoCompras////////////////////////////////////////////////////////////////

    public CarritoCompras crearCarritoCompras ( String codigoCarrito,Cliente cliente){
        CarritoCompras carritoCompras = new CarritoCompras(codigoCarrito, cliente);
        carritosCompras.add(carritoCompras);
        return carritoCompras;
    }

    public  void eliminarCarrito(String codigo) {
        Iterator<CarritoCompras> iterator = carritosCompras.iterator();
        while (iterator.hasNext()) {
            CarritoCompras carritoCompras = iterator.next();
            if (carritoCompras.getCodigoCarrito().equals(codigo)) {
                iterator.remove();
                System.out.println("El carrito  " + codigo + " ha sido eliminado.");
                return; // Terminar después de eliminar al cliente
            }
        }
        System.out.println("El carrito " + codigo + " no fue encontrado.");
    }

    public void eliminarProductoDeCarrito(String codigoProducto, String id){
        if(existeCliente(id)){
            Cliente cliente = clientes.get(id);
            cliente.getCarritoCompras().getCodeProducts().remove(codigoProducto);
        }
    }

    /////////////////////////////////////////DetalleVenta////////////////////////////////////////////////////////////////

    public DetalleVenta crearDetalleVenta (int cantidad, double subTotal, HashMap<String, Producto> productos){
        DetalleVenta detalleVenta = new DetalleVenta(cantidad, subTotal, productos);
        return detalleVenta;
    }

    ////////////////////////////////////////////////////////////
    public String crearCode(int longitd){
        GeneradorCodigos generadorCodigos = new GeneradorCodigos();
        String codigo = generadorCodigos.generarCodigoAleatorio(longitd);
        return codigo;
    }

}

