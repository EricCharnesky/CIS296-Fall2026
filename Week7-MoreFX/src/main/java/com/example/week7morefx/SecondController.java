package com.example.week7morefx;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SecondController {
    @javafx.fxml.FXML
    private Button clickMeButton;
    @javafx.fxml.FXML
    private ComboBox<String> comboBox;
    @javafx.fxml.FXML
    private Label label;

    public void initialize(){
        comboBox.getItems().add("first");
        comboBox.getItems().add("second");
        comboBox.getItems().add("third");
    }

    @javafx.fxml.FXML
    public void buttonClicked(ActionEvent actionEvent) {
        clickMeButton.setText("clicked!");
    }

    @javafx.fxml.FXML
    public void comboBoxSelected(ActionEvent actionEvent) {
        label.setText(comboBox.getSelectionModel().getSelectedItem());

        // murach 13
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pick Title");
        alert.setHeaderText("Pick Header");
        alert.setContentText(comboBox.getSelectionModel().getSelectedItem());
        alert.showAndWait();

    }
}
