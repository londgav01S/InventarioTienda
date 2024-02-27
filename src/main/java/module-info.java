module co.edu.uniquindio.inventariotienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.inventariotienda to javafx.fxml;
    exports co.edu.uniquindio.inventariotienda;
    exports co.edu.uniquindio.inventariotienda.controller;
    opens co.edu.uniquindio.inventariotienda.controller to javafx.fxml;
    exports co.edu.uniquindio.inventariotienda.viewController;
    opens co.edu.uniquindio.inventariotienda.viewController to javafx.fxml;
}