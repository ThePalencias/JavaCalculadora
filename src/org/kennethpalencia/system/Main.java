package org.kennethpalencia.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {

        

        
    }

        @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //nodos 
        VBox root = new VBox(); 
        //escena 
        Scene escena = new Scene(root);
      //mostrar escenario principal
      escenarioPrincipal.setTitle("asdfasdf");
      escenarioPrincipal.setScene(escena);
      escenarioPrincipal.show();
    }
}
