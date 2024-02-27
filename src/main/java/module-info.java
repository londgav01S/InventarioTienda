module co.edu.uniquindio.inventariotienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.inventariotienda to javafx.fxml;
    exports co.edu.uniquindio.inventariotienda;
}