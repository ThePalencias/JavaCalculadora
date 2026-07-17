package org.kennethpalencia.view;

import javafx.geometry.Insets;
import java.util.HashSet;
import java.util.Set;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.VBox; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight;  
import org.kennethpalencia.controller.CalculadoraController;

public class CalculadoraView {
    private VBox view; 
    private Label pantalla; 
    private GridPane cuadroBotones;     
    
    // Controlador adaptado del segundo código
    private CalculadoraController controlador; 
    
    // Constructor
    public CalculadoraView() {
        controlador = new CalculadoraController(); 

        view = new VBox(15); 
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #EFC99A");
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT); 
        pantalla.setPrefSize(235, 50); 
        
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(10);
        cuadroBotones.setVgap(10);
        cuadroBotones.setAlignment(Pos.CENTER);
        
        Button btnCiento = accionBoton("%");
        Button btnC = accionBoton("C");
        Button btnUNo = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnCero = nuevoBoton("0");
        Button btnPunto = accionBoton(".");
        Button btnIgual = accionBoton("=");
        btnIgual.setPrefSize(110, 50);
        Button btnMas = accionBoton("+");
        Button btnMenos = accionBoton("-");
        Button btnPor = accionBoton("x");
        Button btnDiv = accionBoton("÷");
        Button btnElevar = accionBoton("^");
        Button btnRaiz = accionBoton("√");
        Button btnBorrar = accionBoton("<-");
        
 
        
    cuadroBotones.add(btnC, 0, 1);
    cuadroBotones.add(btnBorrar, 3, 1);
    cuadroBotones.add(btnCiento, 0, 2);
    cuadroBotones.add(btnElevar, 1, 2);
    cuadroBotones.add(btnRaiz, 2, 2);
    cuadroBotones.add(btnDiv, 3, 2);
    cuadroBotones.add(btnSiete, 0, 3);
    cuadroBotones.add(btnOcho, 1, 3);
    cuadroBotones.add(btnNueve, 2, 3);
    cuadroBotones.add(btnPor, 3, 3);
    cuadroBotones.add(btnCuatro, 0, 4);
    cuadroBotones.add(btnCinco, 1, 4);
    cuadroBotones.add(btnSeis, 2, 4);
    cuadroBotones.add(btnMenos, 3, 4);
    cuadroBotones.add(btnUNo, 0, 5);
    cuadroBotones.add(btnDos, 1, 5);
    cuadroBotones.add(btnTres, 2, 5);
    cuadroBotones.add(btnMas, 3, 5);
    cuadroBotones.add(btnCero, 0, 6);
    cuadroBotones.add(btnPunto, 1, 6);
    cuadroBotones.add(btnIgual, 2, 6);
    GridPane.setColumnSpan(btnIgual, 2);

        
        
        view.getChildren().addAll(pantalla, cuadroBotones);     
    }
    
    public VBox getView(){
        return view;
    }
    
    private Button nuevoBoton (String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #66B9F4; -fx-text-fill:black; -ft-background-radius:5px;"
                + " -fx-cursor:hand;");
        
        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color:#93C9F6 ; -fx-text-fill: black;");
            btn.setTranslateY(2);
        });

        
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #66B9F4; -fx-text-fill: black;");
            btn.setTranslateY(0);
        });
        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        
        // Vinculación con el controlador añadida
        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));
        
        return btn;
        
    }
    
    private Button accionBoton (String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #F4712A; -fx-text-fill:black; -ft-background-radius:5px;"
                + " -fx-cursor:hand;");
        
        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color:#F79764 ; -fx-text-fill: black;");
            btn.setTranslateY(2);
        });

        
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #F4712A; -fx-text-fill: black;");
            btn.setTranslateY(0);
        });
        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        
        // Vinculación con el controlador añadida
        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));
        
        return btn;
        
    }
    
}