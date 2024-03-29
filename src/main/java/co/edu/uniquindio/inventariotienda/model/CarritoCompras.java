package co.edu.uniquindio.inventariotienda.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CarritoCompras implements Serializable {
    private String codigoCarrito;

    private Cliente cliente;

    private HashSet<String> codeProducts;

    private Venta venta;

    public CarritoCompras(String codigoCarrito,Cliente cliente) {
        this.codigoCarrito = codigoCarrito;
    }

    public CarritoCompras() {}

    public HashSet<String> getCodeProducts() {
        return codeProducts;
    }

    public void setCodeProducts(HashSet<String> codeProducts) {
        this.codeProducts = codeProducts;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(String codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void add(String codigo) {
        if (codeProducts ==null){
            codeProducts = new HashSet<>();
        }
        codeProducts.add(codigo);
    }
}
