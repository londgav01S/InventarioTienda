package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.*;
import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.HashSet;

public class VentaController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public double obtenerPrecio(String productosId) {
        return mfm.obtenerPrecioProducto(productosId);
    }

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

    public void actualizarCliente(Cliente clienteActualizado, Cliente clienteSeleccionado) {
        mfm.actualizarCliente(clienteActualizado, clienteSeleccionado);
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

    public void crearCarrito(String codigoCarrito, Cliente cliente) {
        mfm.crearCarrito(codigoCarrito, cliente);
    }

    public void eliminarCarrito(String codigo) {
        mfm.eliminarCarrito(codigo);
    }

    public Venta crearVenta(String codigo, String fecha, double total, DetalleVenta detallesVentas, CarritoCompras carritoCompras, Cliente cliente) {
        Venta venta = mfm.crearVenta(codigo, fecha, total, detallesVentas, carritoCompras, cliente);
        return venta;
    }

    public void eliminarProductoDeCarrito(String codigoProducto, String id) {
        mfm.eliminarProductoDeCarrito(codigoProducto, id);
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

    public String crearCode(int l){
        return mfm.generarCode(l);
    }

    public Producto obtenerProducto(String prodID) {
        return mfm.obtenerProducto(prodID);
    }

    public boolean hasCarrito(Cliente clienteSeleccionado) {
        return mfm.hasCarrito(clienteSeleccionado);
    }

    public void addProductCart(Cliente clienteSeleccionado, String codigo) {
        mfm.addProductCart(clienteSeleccionado,codigo);
    }
}
