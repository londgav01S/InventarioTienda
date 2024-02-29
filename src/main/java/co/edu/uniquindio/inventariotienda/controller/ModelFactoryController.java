package co.edu.uniquindio.inventariotienda.controller;

import co.edu.uniquindio.inventariotienda.model.CarritoCompras;
import co.edu.uniquindio.inventariotienda.model.Cliente;
import co.edu.uniquindio.inventariotienda.model.Tienda;



import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelFactoryController {
    Tienda tienda;





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

    public void actualizarUsuario() {
        //TODO: HACERLO

    }


    public CarritoCompras crearCarrito (String codigo){
        CarritoCompras carritoCompras= tienda.crearCarritoCompras(codigo);
        return  carritoCompras;
    }

    public void eliminarCarrito (String codigo){
        tienda.eliminarCarrito(codigo);
    }

    //-----------------------------------------Usuario--------------------------------------------------------------


}
