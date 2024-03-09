package co.edu.uniquindio.inventariotienda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Venta implements Serializable {
    private String codigo ;
    private String fecha;
    private double total;
    private DetalleVenta detallesVentas;

    private CarritoCompras carritoCompras;

    private Cliente cliente;

    public Venta(String codigo, String fecha, double total, DetalleVenta detallesVentas, CarritoCompras carritoCompras, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.detallesVentas = detallesVentas;
        this.carritoCompras = carritoCompras;
        this.cliente = cliente;
    }

    public Venta() {}

    public DetalleVenta getDetallesVentas() {
        return detallesVentas;
    }

    public void setDetallesVentas(DetalleVenta detallesVentas) {
        this.detallesVentas = detallesVentas;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "co.edu.uniquindio.tienda.model.Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }

}
