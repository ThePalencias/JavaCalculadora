package org.kennethpalencia.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;

    public CalculadoraController() {       
    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        // Botón limpiar todo
        if (entrada.equals("C")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pantalla.setText("0"); 
            calculoTerminado = true;
            return; 
        }

        // Si ya se completó un cálculo, reiniciar variables al presionar un nuevo número o punto
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
        }
        calculoTerminado = false;

        // Entrada de números y punto decimal
        if (entrada.matches("[0-9]") || entrada.equals(".")) {
            if (operador.isEmpty()) {
                // Evitar múltiples puntos en el primer número
                if (entrada.equals(".") && opcion1.contains(".")) {
                    return; 
                }
                opcion1 += entrada; 
            } else {
                // Evitar múltiples puntos en el segundo número
                if (entrada.equals(".") && opcion2.contains(".")) {
                    return; 
                }
                opcion2 += entrada; 
            }
            actualizarPantalla(pantalla);        
        } 
        // Entrada de operadores binarios
        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("x") || entrada.equals("÷") || entrada.equals("^") || entrada.equals("%")) {
            if (!opcion1.isEmpty()) { 
                operador = entrada; 
                actualizarPantalla(pantalla);  
            }
        } 
        // La raiz cuadrada de ejecuta de inmediato en el codigo
        else if (entrada.equals("√")) {
            if (!opcion1.isEmpty() && operador.isEmpty()) {
                try {
                    double numero = Double.parseDouble(opcion1);
                    if (numero >= 0) {
                        opcion1 = formatearResultado(Math.sqrt(numero));
                    } else {
                        opcion1 = "Error"; // Evita raíces de números negativos
                    }
                    calculoTerminado = true; 
                    actualizarPantalla(pantalla);
                } catch (NumberFormatException e) {
                    opcion1 = "Error";
                    actualizarPantalla(pantalla);
                }
            }
        }
        // Botón Igual 
        else if (entrada.equals("=")) {
            if (!opcion1.isEmpty() && !operador.isEmpty() && !opcion2.isEmpty()) {
                opcion1 = calcularResultado(opcion1, operador, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true; 
            }
            actualizarPantalla(pantalla);
        }
    }

    private void actualizarPantalla(Label pantalla) {
        if (opcion1.isEmpty() && operador.isEmpty() && opcion2.isEmpty()) {
            pantalla.setText("0"); 
        } else if (operador.isEmpty()) {
            pantalla.setText(opcion1); 
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2); 
        }
    }

    // Método que procesa las operaciones matemáticas
    private String calcularResultado(String num1, String op, String num2) {
        try {
            double datoUno = Double.parseDouble(num1);
            double datoDos = Double.parseDouble(num2);
            double resultado = 0;

            switch (op) {
                case "+":
                    resultado = datoUno + datoDos;
                    break;
                case "-":
                    resultado = datoUno - datoDos;
                    break;
                case "x":
                    resultado = datoUno * datoDos;
                    break;
                case "÷":
                    if (datoDos == 0) {
                        return "Error"; 
                    }
                    resultado = datoUno / datoDos;
                    break;
                case "^":
                    resultado = Math.pow(datoUno, datoDos);
                    break;
                case "%":
                    resultado = (datoUno * datoDos) / 100.0; 
                    break;
                default:
                    return "0";
            }
            return formatearResultado(resultado);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    // Quita el decimal ".0" si el resultado es un número entero
    private String formatearResultado(double valor) {
        if (valor == (long) valor) {
            return String.format("%d", (long) valor);
        } else {
            return String.valueOf(valor);
        }
    }
}