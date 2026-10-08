package com.example.week7morefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to JavaFX Application!");

        // https://www.bing.com/search?pglt=297&q=javafx+change+scene
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("second-screen.fxml"));
            Scene newScene = new Scene(newRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            welcomeText.setText("Unable to load scene");
        }

    }
}
