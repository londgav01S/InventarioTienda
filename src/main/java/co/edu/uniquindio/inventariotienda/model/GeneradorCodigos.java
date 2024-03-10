package co.edu.uniquindio.inventariotienda.model;

import java.util.Random;
import java.util.StringJoiner;

public class GeneradorCodigos {
    private final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generarCodigoAleatorio(int longitud) {
        Random random = new Random();
        StringJoiner codigo = new StringJoiner("");
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(CARACTERES.length());
            char caracter = CARACTERES.charAt(indice);
            codigo.add(""+caracter);
        }
        return codigo.toString();
    }
}
