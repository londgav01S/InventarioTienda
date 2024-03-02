package co.edu.uniquindio.inventariotienda.model;

import java.util.*;

public class Tienda {
    private HashMap<String, Producto> productos = new HashMap<>();
    private HashMap<String, Cliente> clientes = new HashMap<>();

    private List <Venta> ventas = new ArrayList<>();

    private HashSet <CarritoCompras> carritosCompras = new HashSet<>();

    private List <DetalleVenta> detallesVentas = new ArrayList<>();

    public boolean existeProducto (String codigo ){
       if  ( productos.containsKey(codigo)){
            return true;
        }
       return false;
    }

    public Producto buscarProducto(String codigo){
        return productos.get(codigo);
    }

    public Producto crearProducto(String codigo, String nombre, int cantidad, double precio) throws Exception {
        if (!existeProducto(codigo)) {
            Producto producto = new Producto(codigo, nombre, cantidad, precio);
            productos.put(codigo, producto);
            return producto;
        } else {
            throw new Exception("El Producto ya existe");
        }
    }

    public void eliminarProducto(String codigo) {
        productos.remove(codigo);
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


    public boolean existeCliente (String numeroIdentificacion ){

        if  ( clientes.containsKey(numeroIdentificacion)){
            return true;
        }
        return false;
    }

    public Cliente crearCliente(String nombre, String numeroIdentificacion, String direccion) throws Exception {
        if (!existeCliente(numeroIdentificacion)) {
            Cliente cliente = new Cliente(nombre, numeroIdentificacion, direccion);
            clientes.put(numeroIdentificacion, cliente);
            return cliente;
        } else {
            throw new Exception("El cliente ya existe");
        }
    }

    public  void eliminarCliente( String id) {
        clientes.remove(id);
    }


    public Venta crearVenta (String codigo, Date fecha, double total){
        Venta venta = new Venta(codigo, fecha, total);
        ventas.add(venta);
        return venta;
    }

    public CarritoCompras crearCarritoCompras ( String codigo){
        CarritoCompras carritoCompras = new CarritoCompras(codigo);
        carritosCompras.add(carritoCompras);
        return carritoCompras;
    }

    public  void eliminarCarrito(String codigo) {
        Iterator<CarritoCompras> iterator = carritosCompras.iterator();
        while (iterator.hasNext()) {
            CarritoCompras carritoCompras = iterator.next();
            if (carritoCompras.getCodigo().equals(codigo)) {
                iterator.remove();
                System.out.println("El carrito  " + codigo + " ha sido eliminado.");
                return; // Terminar después de eliminar al cliente
            }
        }
        System.out.println("El carrito " + codigo + " no fue encontrado.");
    }

    public DetalleVenta crearDetalleVenta (int cantidad, double subTotal){
        DetalleVenta detalleVenta = new DetalleVenta(cantidad, subTotal);
        detallesVentas.add(detalleVenta);
        return detalleVenta;
    }

}
