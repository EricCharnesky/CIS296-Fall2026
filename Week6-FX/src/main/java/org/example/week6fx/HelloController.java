package org.example.week6fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button clickMeButton;
    @FXML
    private TextField nameTextBox;

    @FXML
    protected void onHelloButtonClick() {
        String text = "Hello " + nameTextBox.getText();
        welcomeText.setText(text);
    }
}
