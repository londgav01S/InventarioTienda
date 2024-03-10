package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.*;
import co.edu.uniquindio.inventariotienda.utils.Persistencia;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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
        //1. inicializar datos y luego guardarlo en archivos
        //System.out.println("invocación clase singleton");

        guardarResourceXML();
        //cargarResourceXML();

    }

    ////////////////////////////////////////////////Alerts////////////////////////////////////////////////////////////////

    public void mostrarMensajeAlerta(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static boolean mostrarAlertaConfirmacion(String mensaje, String titulo) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        // Configura los botones (Aceptar y Cancelar)
        ButtonType botonAceptar = new ButtonType("Accept");
        ButtonType botonCancelar = new ButtonType("Canceler");
        alerta.getButtonTypes().setAll(botonAceptar, botonCancelar);

        // Muestra la alerta y espera a que el usuario elija una opción
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true); // Asegura que la alerta esté encima de otras ventanas

        alerta.showAndWait();

        // Devuelve true si se presionó "Aceptar", false si se presionó "Cancelar"
        return alerta.getResult() == botonAceptar;
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

    private void cargarResourceXML() {
        tienda = Persistencia.cargarRecursoTiendaXML();
        System.out.println("pasando por cargar xml");
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoTiendaXML(tienda);
        System.out.println("pasando por guardar xml");
    }

    private void cargarResourceBinario() {
        tienda = Persistencia.cargarRecursoTiendaBinario();
        System.out.println("cargando por cargar bin");
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoTiendaBinario(tienda);
        System.out.println("pasando por guardar bin");
    }

    //-----------------------------------------Persistencia-------------------------------------------------------------

    public Cliente crearCliente(String nombre, String numeroIdentificacion, String direccion, HashMap<String, Venta> ventas, CarritoCompras carritoCompras) throws Exception {
        Cliente cliente = tienda.crearCliente(nombre, numeroIdentificacion, direccion, ventas, carritoCompras);
        guardarResourceXML();
        return cliente;

    }

    public void eliminarCliente(String id) {
        tienda.eliminarCliente(id);
    }


    public CarritoCompras crearCarrito (String codigoCarrito, Cliente cliente, HashSet<String> codeProducts, Venta venta){
        CarritoCompras carritoCompras= tienda.crearCarritoCompras(codigoCarrito, cliente, codeProducts, venta);
        guardarResourceXML();
        return  carritoCompras;
    }

    public void eliminarCarrito (String codigo){
        tienda.eliminarCarrito(codigo);
        guardarResourceXML();
    }

    public void eliminarProductoDeCarrito(String codigoProducto,String id){
        tienda.eliminarProductoDeCarrito(codigoProducto,id);
        guardarResourceXML();
    }


    ///////////////////////////////////////////Producto/////////////////////////////////////////////////////////////////
    public Producto crearProducto (String codigo, String nombre, int cantidad, double precio, CarritoCompras carrito, DetalleVenta detalleVenta) throws Exception {
        Producto producto = tienda.crearProducto(codigo, nombre, cantidad, precio, carrito, detalleVenta);
        guardarResourceXML();
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
        guardarResourceXML();
    }


    //////////////////////////////////////////Venta////////////////////////////////////////////////////////////////

    public Venta crearVenta (String codigo, String fecha, double total, DetalleVenta detallesVentas, CarritoCompras carritoCompras, Cliente cliente){
        Venta venta = tienda.crearVenta(codigo, fecha, total, detallesVentas, carritoCompras, cliente);
        guardarResourceXML();
        return venta;
    }

    public DetalleVenta crearDetalleVenta (int cantidad, double subTotal, HashMap<String, Producto> productos){
        DetalleVenta detalleVenta= tienda.crearDetalleVenta(cantidad, subTotal, productos);
        guardarResourceXML();
        return detalleVenta;
    }

    public void eliminarVenta (String codigo){
        tienda.eliminarVenta(codigo);
        guardarResourceXML();
    }
}
