module me.easycalculator.graphitecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens me.easycalculator.graphitecalculator to javafx.fxml;
    exports me.easycalculator.graphitecalculator;
}