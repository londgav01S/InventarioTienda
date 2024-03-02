package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.*;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelFactoryController {
    Tienda tienda = null;




    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        inicializarDatos();
    }


    private void inicializarDatos() {
        tienda = new Tienda();

    }

    //----------------------------------------  Singleton ---------------------------------------------------------------


    //-----------------------------------------Subasta--------------------------------------------------------------
    public Tienda getTienda() {
        return tienda;
    }

    public void setSubasta(Tienda tienda) {
        this.tienda= tienda;
    }
    //-----------------------------------------Subasta--------------------------------------------------------------


    //-----------------------------------------Persistencia--------------------------------------------------------------



    //-----------------------------------------Persistencia-------------------------------------------------------------





    public Cliente crearCliente(String nombre, String numeroIdentificacion, String direccion) throws Exception {
        Cliente cliente = tienda.crearCliente(nombre, numeroIdentificacion, direccion);
        return cliente;

    }

    public void eliminarCliente(String id) {
        tienda.eliminarCliente(id);


    }


    public CarritoCompras crearCarrito (String codigo){
        CarritoCompras carritoCompras= tienda.crearCarritoCompras(codigo);
        return  carritoCompras;
    }

    public void eliminarCarrito (String codigo){
        tienda.eliminarCarrito(codigo);
    }


    public Producto crearProducto (String codigo, String nombre, int cantidad, double precio ) throws Exception {
        Producto producto = tienda.crearProducto(codigo, nombre, cantidad, precio);
        return producto;
    }

    public void eliminarProducto (String codigo){
        tienda.eliminarProducto(codigo);
    }
    public Producto encontrarProducto(String codigo) {
        Producto producto = tienda.buscarProducto(codigo);
        return producto;
    }
    public void actualizarProducto (Producto producto, int cantidad, double precio) throws Exception {
        tienda.actualizarProducto(producto, cantidad, precio);
    }

    public Venta crearVenta (String codigo, Date fecha, double total){
        Venta venta = tienda.crearVenta(codigo, fecha, total);
        return venta;
    }

    public DetalleVenta crearDetalleVenta (int cantidad, double subTotal){
        DetalleVenta detalleVenta= tienda.crearDetalleVenta(cantidad, subTotal);
        return detalleVenta;
    }
    //-----------------------------------------Usuario--------------------------------------------------------------


}
