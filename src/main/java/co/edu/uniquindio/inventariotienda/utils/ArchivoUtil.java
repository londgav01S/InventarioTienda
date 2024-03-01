package co.edu.uniquindio.inventariotienda.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {
    static String fechaSistema = "";

    /**
     * Este metodo recibe una cadena con el contenido que se quiere guardar en el archivo
     *
     * @param ruta es la ruta o path donde esta ubicado el archivo
     * @throws IOException
     */
    public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }

    /**
     * ESte metodo retorna el contendio del archivo ubicado en una ruta,con la lista de cadenas.
     *
     * @param ruta
     * @return
     * @throws IOException
     */
    public static ArrayList<String> leerArchivo(String ruta) throws IOException {

        ArrayList<String> contenido = new ArrayList<String>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String linea = "";
        while ((linea = bfr.readLine()) != null) {
            contenido.add(linea);
        }
        bfr.close();
        fr.close();
        return contenido;
    }



    private static void cargarFechaSistema() {

        String diaN = "";
        String mesN = "";
        String añoN = "";

        Calendar cal1 = Calendar.getInstance();


        int dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH) + 1;
        int año = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);


        if (dia < 10) {
            diaN += "0" + dia;
        } else {
            diaN += "" + dia;
        }
        if (mes < 10) {
            mesN += "0" + mes;
        } else {
            mesN += "" + mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = año + "-" + mesN + "-" + diaN;
        //		horaFechaSistema = hora+"-"+minuto;
    }


    //------------------------------------SERIALIZACIÓN  y XML

    /**
     * Escribe en el fichero que se le pasa el objeto que se le envia
     *
     * @param rutaArchivo path del fichero que se quiere escribir
     * @throws IOException
     */

    @SuppressWarnings("unchecked")
    public static Object cargarRecursoSerializado(String rutaArchivo) throws Exception {
        Object aux = null;
        ObjectInputStream ois = null;
        try {
            // Se crea un ObjectInputStream
            ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

            aux = ois.readObject();

        } catch (Exception e2) {
            throw e2;
        } finally {
            if (ois != null)
                ois.close();
        }
        return aux;
    }


    public static void salvarRecursoSerializado(String rutaArchivo, Object object)	throws Exception {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
            oos.writeObject(object);
        } catch (Exception e) {
            throw e;
        } finally {
            if (oos != null)
                oos.close();
        }
    }

}
