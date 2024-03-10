package co.edu.uniquindio.inventariotienda.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

public class Cliente implements Serializable, Comparable<Cliente> {
    private String nombre;
    private String numeroIdentificacion;
    private String direccion;
    private HashMap<String,Venta> ventas;
    private CarritoCompras carritoCompras;

    public Cliente(String nombre, String numeroIdentificacion, String direccion, HashMap<String, Venta> ventas, CarritoCompras carritoCompras) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.ventas = ventas;
        this.carritoCompras = carritoCompras;
    }

    public Cliente() {}

    public HashMap<String, Venta> getVentas() {
        return ventas;
    }

    public void setVentas(HashMap<String, Venta> ventas) {
        this.ventas = ventas;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "co.edu.uniquindio.tienda.model.Cliente{" +
                "nombre='" + nombre + '\'' +
                ", numero identificacion='" + numeroIdentificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public void updateInfo(Cliente clienteActualizado) {
        this.nombre =clienteActualizado.getNombre();
        this.direccion = clienteActualizado.getDireccion();
        this.numeroIdentificacion = clienteActualizado.getNumeroIdentificacion();
    }


    @Override
    public int compareTo(Cliente o) {
        return this.numeroIdentificacion.compareTo(o.numeroIdentificacion);
    }
}
