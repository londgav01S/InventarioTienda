package co.edu.uniquindio.inventariotienda;

import co.edu.uniquindio.inventariotienda.viewController.VentaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader= new FXMLLoader(TiendaApplication.class.getResource("PrincipalView.fxml"));
        Scene scene= new Scene(loader.load(),600 ,435,false);
        VentaViewController ventaViewController = loader.getController();
        ventaViewController.init(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}