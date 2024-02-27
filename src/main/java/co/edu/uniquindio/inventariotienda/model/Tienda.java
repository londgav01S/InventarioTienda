package co.edu.uniquindio.inventariotienda.model;

import java.util.*;

public class Tienda {
    HashMap<String, Producto> productos = new HashMap<>();
    HashMap<String, Cliente> clientes = new HashMap<>();

    List <Venta> ventas = new ArrayList<Venta>();

    HashSet <CarritoCompras> carritosCompras = new HashSet<>();

    public boolean existeProducto (String codigo ){

       if  ( productos.containsKey(codigo)){
            return true;
        }
       return false;
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
}
