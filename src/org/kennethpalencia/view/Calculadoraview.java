package org.kennethpalencia.view;

import java.awt.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Calculadoraview {
    
    private VBox view;
    private Label panralla;
    private GridPane cuadroBotones;
    //controller
    
    public Calculadoraview(){
        view = new VBox();
        Label pantalla = new Label("0");
        cuadroBotones = new GridPane();
    }
    
}
