package org.kennethpalencia.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kennethpalencia.view.CalculadoraView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args); 
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        // Vista de la calculadora 
        CalculadoraView calculadora = new CalculadoraView(); 
        
        // Creamos la escena pasándole directamente la vista
        Scene escena = new Scene(calculadora.getView(), 266, 390);
        
        // Mostrar escenario principal
        escenarioPrincipal.setTitle("Calculadora de Kenneth");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
