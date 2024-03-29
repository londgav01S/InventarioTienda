package co.edu.uniquindio.inventariotienda.utils;

import co.edu.uniquindio.inventariotienda.model.Tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public static final String RUTA_ARCHIVO_CLIENTE = "src/main/resources/persistencia/archivoCliente.txt";

    public static final String RUTA_ARCHIVO_PRODUCTO = "/src/main/resources/persistencia/archivoProducto.txt";
    public static final String RUTA_ARCHIVO_VENTA = "src/main/resources/persistencia/archivoVenta.txt";
    private static final String RUTA_ARCHIVO_MODELO_TIENDA_BINARIO = "src/main/resources/persistencia/archivoTiendaBin.dat";
    private static final String RUTA_ARCHIVO_MODELO_TIENDA_XML = "src/main/resources/persistencia/archivoTiendaXml.xml";


    public static void cargarDatosArchivos(Tienda tienda) throws FileNotFoundException, IOException {
        //cargar archivo de usuarios

        //cargar archivos Usuarios
        

    }

    public static Tienda cargarRecursoTiendaBinario() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;
    }

    public static void guardarRecursoTiendaBinario(Tienda tienda) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO, tienda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Tienda cargarRecursoTiendaXML() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TIENDA_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;

    }

    public static void guardarRecursoTiendaXML(Tienda tienda) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TIENDA_XML, tienda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
