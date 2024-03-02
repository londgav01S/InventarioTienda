package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.Cliente;
import co.edu.uniquindio.inventariotienda.model.Producto;

public class VentaController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public Producto crearProducto(String codigo, String nombre, int cantidadAux, double precioAux) throws Exception {
        Producto producto = mfm.crearProducto(codigo, nombre, cantidadAux, precioAux);
        return producto;
    }

    public Cliente crearCliente(String nombre, String numeroId, String direccion) throws Exception {
        Cliente cliente = mfm.crearCliente(nombre, numeroId, direccion);
        return cliente;
    }

    public void eliminarCLiente(String id) {
        mfm.eliminarCliente(id);
    }

    public Producto encontrarProducto(String codigo) {
        Producto producto = mfm.encontrarProducto(codigo);
        return producto;
    }
}
