package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.*;
import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.HashSet;

public class VentaController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public Producto crearProducto(String codigo, String nombre, int cantidad, double precio, CarritoCompras carrito, DetalleVenta detalleVenta) throws Exception {
        Producto producto = mfm.crearProducto(codigo, nombre, cantidad, precio, carrito, detalleVenta);
        return producto;
    }

    public Cliente crearCliente(String nombre, String numeroIdentificacion, String direccion, HashMap<String, Venta> ventas, CarritoCompras carritoCompras) throws Exception {
        Cliente cliente = mfm.crearCliente(nombre, numeroIdentificacion, direccion, ventas, carritoCompras);
        return cliente;
    }

    public void eliminarCLiente(String id) {
        mfm.eliminarCliente(id);
    }

    public Producto encontrarProducto(String codigo) {
        Producto producto = mfm.encontrarProducto(codigo);
        return producto;
    }

    public void actualizarProducto(Producto producto, int cantidad, double precio) throws Exception {
        mfm.actualizarProducto(producto, cantidad, precio);
    }

    public void eliminarProducto(String codigo) {
        mfm.eliminarProducto(codigo);
    }

    public void crearCarrito(String codigoCarrito, Cliente cliente, HashSet<String> codeProducts, Venta venta) {
        mfm.crearCarrito(codigoCarrito, cliente, codeProducts, venta);
    }

    public void eliminarCarrito(String codigo) {
        mfm.eliminarCarrito(codigo);
    }

    public Venta crearVenta(String codigo, String fecha, double total, DetalleVenta detallesVentas, CarritoCompras carritoCompras, Cliente cliente) {
        Venta venta = mfm.crearVenta(codigo, fecha, total, detallesVentas, carritoCompras, cliente);
        return venta;
    }

    public DetalleVenta crearDetalleVenta(int cantidad, double subTotal, HashMap<String, Producto> productos) {
        DetalleVenta detalleVenta = mfm.crearDetalleVenta(cantidad, subTotal, productos);
        return detalleVenta;
    }

    public void eliminarVenta(String codigo) {
        mfm.eliminarVenta(codigo);
    }

    public void mostrarAlert(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        mfm.mostrarMensajeAlerta(titulo, header, contenido, tipoAlerta);
    }
}
