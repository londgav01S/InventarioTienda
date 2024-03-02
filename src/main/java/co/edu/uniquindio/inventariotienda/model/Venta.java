package co.edu.uniquindio.inventariotienda.model;

import java.util.Date;

public class Venta {
    private String codigo ;
    private Date fecha;
    private double total;

    public Venta(String codigo, Date fecha, double total) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
