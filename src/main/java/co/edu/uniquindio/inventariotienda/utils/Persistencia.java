package co.edu.uniquindio.inventariotienda.utils;

import co.edu.uniquindio.inventariotienda.model.Tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public static final String RUTA_ARCHIVO_CLIENTE = "src/main/resources/persistencia/archivoCliente.txt";

    public static final String RUTA_ARCHIVO_PRODUCTO = "/src/main/resources/persistencia/archivoProducto.txt";
    public static final String RUTA_ARCHIVO_VENTA = "src/main/resources/persistencia/archivoVenta.txt";





    public static void cargarDatosArchivos(Tienda tienda) throws FileNotFoundException, IOException {
        //cargar archivo de usuarios

        /*cargar archivos Usuarios
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        if (usuariosCargados.size() > 0)
            subasta.getListaUsuarios().addAll(usuariosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     *
     * @param
     * @param
     * @throws IOException
     */
   // public static void guardarClientes(ArrayList<Usuario> listaUsuarios) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        /*for (Usuario usuario : listaUsuarios) {
            contenido += usuario.getNombre() + "," + usuario.getTelefono() + "," + usuario.getIdentificacion() + ","
                    + "," + usuario.getCorreoElectronico() + "," + usuario.getNombreUsuario() + "," + usuario.getContrasenia() + "\n";
        }*/
        //ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
    //}


//	--------------------------------------------------------LOADS------------------------

    /**
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    /*public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
        String linea = "";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i); //juan,arias,125454,Armenia,uni1@,12454,125444
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(linea.split("@@")[0]);
            usuario.setContrasenia(linea.split("@@")[1]);

            usuarios.add(usuario);
        }
        return usuarios;
    }


    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios();

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if (usuarioAux.getNombreUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTO);
        String linea = "";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Producto producto = new Producto();
            producto.setNombre(linea.split("@@")[0]);
            //producto.setAnuncio(linea.split(",")[1]);
            productos.add(producto);
        }
        return productos;
    }


//                           	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     *
     * @param
     * @param ruta
     * @throws IOException
     */

    /*public static void guardarObjetos(ArrayList<Usuario> listaUsuarios, String ruta) throws IOException {
        String contenido = "";

        /*for (Usuario usuarioAux : listaUsuarios) {
            contenido += usuarioAux.getNombre() + "," + usuarioAux.getNombreUsuario() + "," + usuarioAux.getIdentificacion() + ","
                    + usuarioAux.getTelefono() + "," + usuarioAux.getCorreoElectronico() + "," + usuarioAux.getContrasenia() + "\n";
        }*/
      //  ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }


    /**
     * guarda usuarios
     *
     * @param listaUsuarios
     * @throws IOException
     */
    /*public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
        String contenido = "";

        for (Usuario usuarioAux : listaUsuarios) {
            contenido += usuarioAux.getNombreUsuario() + "@@" + usuarioAux.getContrasenia() + "@@"
                    + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, true);
    }

    public static void guardarUsuario(Usuario usuario) throws IOException {
        String contenido = "";
        contenido += usuario.getNombreUsuario() + "@@" + usuario.getContrasenia() + "\n";
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, true);
    }

    //-------------------------------------------------------------------------------------------------------------------
    public static void guardarAnunciante(Anunciante anunciante) throws IOException {
        String contenido = "";
        contenido +=  anunciante.getNombre()
                + "@@" + anunciante.getTelefono() + "@@" + anunciante.getIdentificacion()
                + "@@" + anunciante.getCorreoElectronico() + "@@" + anunciante.getFechaNacimiento().toString()
                + "@@" +"\n";

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIANTE, contenido, true);
    }

    public static ArrayList<Anunciante> cargarAnunciante( ) throws IOException {
        ArrayList<Anunciante> anunciantes = new ArrayList<Anunciante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIANTE);
        String linea = "";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i); //juan,arias,125454,Armenia,uni1@,12454,125444
            Anunciante anunciante = new Anunciante();
            anunciante.setNombre(linea.split("@@")[0]);
            anunciante.setTelefono(linea.split("@@")[1]);
            anunciante.setIdentificacion(linea.split("@@")[3]);
            anunciante.setCorreoElectronico(linea.split("@@")[4]);
            anunciante.setFechaNacimiento((linea.split("@@")[5]));
            anunciantes.add(anunciante);
        }
        return anunciantes;
    }*/

}
