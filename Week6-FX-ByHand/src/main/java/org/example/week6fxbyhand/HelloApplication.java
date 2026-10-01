package org.example.week6fxbyhand;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // set stage title
        stage.setTitle("Future Value Calculator");

        // create grid and scene and add grid to scene
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 100);

        // set scene and display stage
        stage.setScene(scene);
        stage.show();

    }


}
