package me.easycalculator.graphitecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //made by Roberto <3
    @Override
    public void start(Stage stage) throws IOException {
        //just load the fxml
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CalcGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("GraphiteCalculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}