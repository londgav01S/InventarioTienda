package co.edu.uniquindio.inventariotienda.model;

public class DetalleVenta {
    private int cantidad ;
    private double subTotal;

    public DetalleVenta(int cantidad, double subTotal) {

        this.cantidad = cantidad;
        this.subTotal = subTotal;
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
