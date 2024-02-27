package co.edu.uniquindio.inventariotienda.model;

public class Cliente {
    private String nombre;
    private String numeroIdentificacion;
    private String direccion;

    public Cliente(String nombre, String numeroIdentificacion, String direccion) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
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
}
