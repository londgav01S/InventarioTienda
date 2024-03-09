package co.edu.uniquindio.inventariotienda.model;

import java.util.HashMap;

public class DetalleVenta {
    private int cantidad ;
    private double subTotal;

    private HashMap<String,Producto> productos;

    public DetalleVenta(int cantidad, double subTotal, HashMap<String, Producto> productos) {
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.productos = productos;
    }

    public DetalleVenta() {}

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
