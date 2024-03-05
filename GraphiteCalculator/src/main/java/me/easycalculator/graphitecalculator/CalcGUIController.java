package me.easycalculator.graphitecalculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CalcGUIController implements Initializable {
    //made by Roberto <3

    //Declaring variables
    private double firstOperand = 0, secondOperand, result;
    String operator = "";
    private boolean startNewInput;

    @FXML
    private Label ans;


    @FXML
    private TextField display;

    //
    //initialize just to set the textfield not editable
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        display.setEditable(false);
    }

    //
    //method called by digits and dot
    //
    @FXML
    public void handleDigits(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (startNewInput) {
            display.clear();
            startNewInput = false;
        }

        display.appendText(clickedButton.getText());
    }

    //
    //method called by operators
    //
    @FXML
    public void handleOperator(ActionEvent event) {
        String currentOperator = ((Button) event.getSource()).getText();

        if (!operator.isEmpty() && !startNewInput) {
            performOperation(); //invocation to method that performs the real operation
        } else {
            firstOperand = Double.parseDouble(display.getText());
        }

        operator = currentOperator;
        startNewInput = true;
    }
    //
    //
    //
    @FXML
    private void performOperation() {
        secondOperand = Double.parseDouble(display.getText());

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "X":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    display.setText("Error");
                }
                break;
        }

        display.setText(String.valueOf(result));
        ans.setText(String.valueOf(result));
        operator = "";
        firstOperand = result;
        secondOperand = 0;

    }

    @FXML
    public void handleResult(ActionEvent event) {
        if (operator != null && !operator.isEmpty()) {
            performOperation();

        } else {
            result = Double.parseDouble(display.getText());
            ans.setText(String.valueOf(result));
            clearCalculator();

        }
    }

    @FXML
    public void handleFunctions(ActionEvent event) {
        String selectedFun = ((Button) event.getSource()).getText();
        double factor = 10000000;
        switch (selectedFun) {
            case "Sin(x)":
                if (firstOperand == 0 && secondOperand == 0) {
                    result = Math.round(sin(Math.toRadians(Double.parseDouble(display.getText()))) * factor) / factor;
                    ans.setText(String.valueOf(result));
                    display.setText(String.valueOf(result));

                } else if (firstOperand != 0 && secondOperand == 0) {
                    secondOperand = Math.round(sin(Math.toRadians(Double.parseDouble(display.getText())))*factor)/factor;
                    ans.setText(String.valueOf(secondOperand));
                    display.setText(String.valueOf(secondOperand));

                } else {
                    firstOperand = Math.round(sin(Math.toRadians(Double.parseDouble(display.getText())))*factor)/factor;
                    display.setText(String.valueOf(firstOperand));
                    ans.setText(String.valueOf(firstOperand));
                }
                startNewInput = true;
                break;
            case "Cos(x)":
                if (firstOperand == 0 && secondOperand == 0) {
                    result = Math.round(cos(Math.toRadians(Double.parseDouble(display.getText())))*factor)/factor;
                    display.setText(String.valueOf(result));
                    ans.setText(String.valueOf(result));
                } else if (firstOperand != 0 && secondOperand == 0) {
                    secondOperand = Math.round(cos(Math.toRadians(Double.parseDouble(display.getText())))*factor)/factor;
                    display.setText(String.valueOf(secondOperand));
                    ans.setText(String.valueOf(secondOperand));
                } else {
                    firstOperand = Math.round(cos(Math.toRadians(Double.parseDouble(display.getText())))*factor)/factor;
                    display.setText(String.valueOf(firstOperand));
                    ans.setText(String.valueOf(firstOperand));
                }
                startNewInput = true;
                break;
            case "ˆ2":
                if (firstOperand == 0 && secondOperand == 0) {
                    result = (Double.parseDouble(display.getText())) * (Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    ans.setText(String.valueOf(result));
                } else if (firstOperand != 0 && secondOperand == 0) {
                    secondOperand = (Double.parseDouble(display.getText())) * (Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(secondOperand));
                    ans.setText(String.valueOf(secondOperand));

                } else {
                    firstOperand = (Double.parseDouble(display.getText())) * (Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(firstOperand));
                    ans.setText(String.valueOf(firstOperand));
                }
                startNewInput = true;
                break;
            case "Ans":
                result = Double.parseDouble(ans.getText());
                display.setText(String.valueOf(result));
                startNewInput = true;
                break;

        }
    }

    @FXML
    public void clearCalculator() {
        if (display.getText().equals("0")) {
            ans.setText("");
            result = 0;
        }

        display.setText("0");
        ans.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        startNewInput = true;
    }


    // Add methods for cosine, sine, and square operations as needed
}
