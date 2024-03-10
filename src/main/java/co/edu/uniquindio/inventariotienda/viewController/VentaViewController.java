package co.edu.uniquindio.inventariotienda.viewController;

import co.edu.uniquindio.inventariotienda.controller.VentaController;
import co.edu.uniquindio.inventariotienda.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class VentaViewController implements Initializable {

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btEliminarProduct;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnAgregarCarrito;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnComrar;

    @FXML
    private Button btnElimarDelCarrito;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private TableColumn<Producto, Integer> colCantidadC;

    @FXML
    private TableColumn<Producto, Integer> colCantidadProducto;

    @FXML
    private TableColumn<Producto, Integer> colCantidadProductoV;

    @FXML
    private TableColumn<Producto, String> colCodigoProducto;

    @FXML
    private TableColumn<Producto, String> colCodigoProductoV;

    @FXML
    private TableColumn<Cliente, String> colDireccionCliente;

    @FXML
    private TableColumn<Cliente, String> colNombreCliente;

    @FXML
    private TableColumn<Producto, String> colNombreProducto;

    @FXML
    private TableColumn<Producto, String> colNombreProductoC;

    @FXML
    private TableColumn<Producto, String> colNombreProductoV;

    @FXML
    private TableColumn<Cliente, String> colNumeroIdentificacionCliente;

    @FXML
    private TableColumn<Producto, Double> colPrecioProducto;

    @FXML
    private TableColumn<Producto, Double> colPrecioProductoC;

    @FXML
    private TableColumn<Producto, Double> colPrecioProductoV;

    @FXML
    private TableColumn<Producto, Double> colTotal;

    @FXML
    private TextField fBuscarCodigo;

    @FXML
    private TextField fCantidadRegistroProducto;

    @FXML
    private TextField fCodigoRegistroProducto;

    @FXML
    private TextField fDireccionCliente;

    @FXML
    private TextField fNombreCliente;

    @FXML
    private TextField fNombreProducto;

    @FXML
    private TextField fNumeroIdentificacionCliente;

    @FXML
    private TextField fPrecioProducto;

    @FXML
    private TextField codeClienteCarrito;

    @FXML
    private TableView<CarritoCompras> tableCarritoCompras;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TableView<Producto> tableVenta;

    VentaController ventaController;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductosBuscados = FXCollections.observableArrayList();

    private Stage stage;

    @FXML
    void actualizarClienteEvent(ActionEvent event) {

    }

    @FXML
    void actualizarProductoEvent(ActionEvent event) {

    }

    @FXML
    void agregarAlCarritoEvent(ActionEvent event) {

    }

    @FXML
    void agregarProductoEvent(ActionEvent event) throws Exception {
        agregarProductoAction();

    }

    public void agregarProductoAction() throws Exception {
        String nombre = fNombreProducto.getText();
        String codigo = fCodigoRegistroProducto.getText();
        String cantidad = fCantidadRegistroProducto.getText();
        String precio = fPrecioProducto.getText();
        if(datosValidados(nombre, codigo, cantidad, precio, "a", "a")){
            int cantidadAux = Integer.parseInt(fCantidadRegistroProducto.getText());
            double precioAux = Double.parseDouble(fPrecioProducto.getText());
            Producto producto= ventaController.crearProducto(codigo, nombre, cantidadAux, precioAux, null, null);
            listaProductos.add(producto);
            tableProducto.setItems(listaProductos);
            tableVenta.setItems(listaProductos);
            fCodigoRegistroProducto.setText("");
            fPrecioProducto.setText("");
            fCantidadRegistroProducto.setText("");
            fNombreProducto.setText("");

        }

    }

    @FXML
    void buscarEvent(ActionEvent event) {
        tableVenta.getItems().clear();
        String codigo = fBuscarCodigo.getText();
        Producto producto = ventaController.encontrarProducto (codigo);
        listaProductosBuscados.add(0, producto);
        if (fBuscarCodigo!=null){
            tableVenta.setItems(listaProductosBuscados);
            fBuscarCodigo.setText("");
        }
        else if (fBuscarCodigo.equals("r") || fBuscarCodigo.equals("R")){
            tableVenta.setItems(listaProductos);
            tableVenta.refresh();
            fBuscarCodigo.setText("");
        }


    }

    @FXML
    void comprarEvent(ActionEvent event) {
        if(tableCarritoCompras != null){
            int cantidadProductos= tableCarritoCompras.getItems().size();
            //TODO: Crear la lista de productos de la tabla carrito compras
            int subTotal = calcularTotalProductos();
            //TODO: revisar esto ya que no se cual seria la lista de la tabla
            HashMap<String, Producto> productos = crearListaProductosCarrito(tableCarritoCompras.getItems());
            ventaController.crearDetalleVenta(cantidadProductos, subTotal, productos);
            ventaController.crearVenta("codigo", "fecha", 0, null, null, clienteSeleccionado);
            mostrarMensajeAlerta("Compra" , "Compra realizada", "proceso completado con exito", Alert.AlertType.INFORMATION);
        }
    }

    public HashMap<String, Producto> crearListaProductosCarrito(ObservableList<Producto> listaProductosCarrito){
        HashMap<String, Producto> productos = new HashMap<>();
        for (Producto producto: listaProductosCarrito){
            productos.put(producto.getCodigo(), producto);
        }
        return productos;
    }

    public int calcularTotalProductos(ObservableList<Producto> listaProductosCarrito){
        int total = 0;
        for (Producto producto: listaProductosCarrito){
            total+= (int) producto.getPrecio();
        }
        return total;
    }

    public double calcularSubTotal(int cantidad, double precio){
        return cantidad * precio;
    }

    @FXML
    void eliminarClienteEvent(ActionEvent event) {
        if(clienteSeleccionado!= null){
            String id  = clienteSeleccionado.getNumeroIdentificacion();
            ventaController.eliminarCLiente(id);
            listaClientes.remove(clienteSeleccionado);
            tableCliente.refresh();
            fNombreCliente.setText("");
            fDireccionCliente.setText("");
            fNumeroIdentificacionCliente.setText("");
            mostrarMensajeAlerta("Eliminacion" , " el clietne ha sido eliminado", "proceso completado con exito", Alert.AlertType.INFORMATION);

        }
    }

    @FXML
    void eliminarDelCarritoEvent(ActionEvent event) {
        //TODO: mirar si ese productoSeleccionado es el de la tabla en el tab carrito, sino crear ese producto cuando lo seleccionamos en la tabla del tab y cambiarlo en la llamada ala funcion
        String id= codeClienteCarrito.getText();
        ventaController.eliminarProductoDeCarrito(productoSeleccionado.getCodigo(),id);
    }

    @FXML
    void registrarClienteEvent(ActionEvent event) throws Exception {
        registrarClienteAction();
    }

    public void registrarClienteAction() throws Exception {
        String nombre = fNombreCliente.getText();
        String direccion = fDireccionCliente.getText();
        String numeroId = fNumeroIdentificacionCliente.getText();
        if(datosValidados(nombre, numeroId, direccion, "precio", "a", "a")){
            Cliente cliente= ventaController.crearCliente(nombre, numeroId, direccion, null, null);
            listaClientes.add(cliente);
            tableCliente.setItems(listaClientes);

        }
        fNombreCliente.setText("");
        fDireccionCliente.setText("");
        fNumeroIdentificacionCliente.setText("");
    }

    @FXML
    void eliminarProducto(ActionEvent event) {
        //TODO: eliminar producto
        String codigo = fCodigoRegistroProducto.getText();
        ventaController.eliminarProducto(codigo);
        mostrarMensajeAlerta("Eliminacion" , " el producto ha sido eliminado", "proceso completado con exito", Alert.AlertType.WARNING);
    }

    public void  init(Stage primaryStage) {
        this.stage = primaryStage;
    }

    Producto productoSeleccionado;
    Cliente clienteSeleccionado;
    Venta ventaSeleccionada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ventaController = new VentaController();
        this.colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colDireccionCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.colNumeroIdentificacionCliente.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
        this.colNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colCodigoProducto.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        this.colCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.colPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.colCantidadProductoV.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.colCodigoProductoV.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.colNombreProductoV.setCellValueFactory(new PropertyValueFactory<>("nombre"));


        this.colPrecioProductoV.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.colNombreProductoC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colPrecioProductoC.setCellValueFactory(new PropertyValueFactory<>("precio"));
        mostrarSeleccionCliente();
        mostrarSeleccionProducto();

    }

    public void mostrarSeleccionProducto (){
        tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                productoSeleccionado = (Producto) newSelection;
                mostrarDatosField();
            }
        });
    }

    public void mostrarSeleccionCliente (){
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                clienteSeleccionado = (Cliente) newSelection;
                mostrarDatosField();
            }
        });
    }

    private void mostrarDatosField() {
        if (productoSeleccionado != null){
            fNombreProducto.setText(productoSeleccionado.getNombre());
            fCodigoRegistroProducto.setText(productoSeleccionado.getCodigo());
            String precioAux = String.valueOf(productoSeleccionado.getPrecio());
            fPrecioProducto.setText(precioAux);
        }
        else if (clienteSeleccionado != null) {
            fNombreCliente.setText(clienteSeleccionado.getNombre());
            fDireccionCliente.setText((clienteSeleccionado.getDireccion()));
            fNumeroIdentificacionCliente.setText(clienteSeleccionado.getNumeroIdentificacion());
        }

    }


    private boolean datosValidados(String nombreAux, String idAux, String telefonoAux, String correoAux, String usuarioAux, String contraAux) {
        String notificacion = "";
        if(nombreAux == null || nombreAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(idAux == null || idAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(telefonoAux == null || telefonoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(correoAux == null || correoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(usuarioAux == null || usuarioAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(contraAux == null || contraAux.equals("")){
            notificacion+= "El dato es invalido";
        }

        if(notificacion.equals("") || notificacion == null){
            return true;
        }
        return false;

    }
    public void mostrarMensajeAlerta (String titulo, String header, String contenido, Alert.AlertType alertType){
        ventaController.mostrarAlert(titulo, header, contenido, alertType);
    }
}
