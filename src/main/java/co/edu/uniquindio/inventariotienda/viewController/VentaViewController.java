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
import java.util.ResourceBundle;

public class VentaViewController implements Initializable {

    @FXML
    private Button btnActualizarCliente;

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
            Producto producto= ventaController.crearProducto(codigo, nombre, cantidadAux, precioAux);
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
            Cliente cliente= ventaController.crearCliente( nombre, numeroId, direccion);
            listaClientes.add(cliente);
            tableCliente.setItems(listaClientes);

        }
        fNombreCliente.setText("");
        fDireccionCliente.setText("");
        fNumeroIdentificacionCliente.setText("");
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

 //TODO: ESTO NO VA AQUI
    public void mostrarMensajeAlerta (String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }




}
