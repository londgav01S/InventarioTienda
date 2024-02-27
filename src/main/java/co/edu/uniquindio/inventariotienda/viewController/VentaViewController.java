package co.edu.uniquindio.inventariotienda.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VentaViewController {

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
    private TableColumn<?, ?> colCantidadC;

    @FXML
    private TableColumn<?, ?> colCantidadProducto;

    @FXML
    private TableColumn<?, ?> colCantidadProductoV;

    @FXML
    private TableColumn<?, ?> colCodigoProducto;

    @FXML
    private TableColumn<?, ?> colCodigoProductoV;

    @FXML
    private TableColumn<?, ?> colDireccionCliente;

    @FXML
    private TableColumn<?, ?> colNombreCliente;

    @FXML
    private TableColumn<?, ?> colNombreProducto;

    @FXML
    private TableColumn<?, ?> colNombreProductoC;

    @FXML
    private TableColumn<?, ?> colNombreProductoV;

    @FXML
    private TableColumn<?, ?> colNumeroIdentificacionCliente;

    @FXML
    private TableColumn<?, ?> colPrecioProducto;

    @FXML
    private TableColumn<?, ?> colPrecioProductoC;

    @FXML
    private TableColumn<?, ?> colPrecioProductoV;

    @FXML
    private TableColumn<?, ?> colTotal;

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
    private TableView<?> tableCarritoCompras;

    @FXML
    private TableView<?> tableCliente;

    @FXML
    private TableView<?> tableProducto;

    @FXML
    private TableView<?> tableVenta;
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
    void agregarProductoEvent(ActionEvent event) {

    }

    @FXML
    void buscarEvent(ActionEvent event) {

    }

    @FXML
    void comprarEvent(ActionEvent event) {

    }

    @FXML
    void eliminarClienteEvent(ActionEvent event) {

    }

    @FXML
    void eliminarDelCarritoEvent(ActionEvent event) {

    }

    @FXML
    void registrarClienteEvent(ActionEvent event) {

    }

    public void  init(Stage primaryStage) {
        this.stage = primaryStage;
    }
}
