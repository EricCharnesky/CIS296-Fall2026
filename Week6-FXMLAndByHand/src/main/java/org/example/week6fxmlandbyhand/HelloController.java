package org.example.week6fxmlandbyhand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HelloController {

    @FXML
    private HBox topHBox;
    @FXML
    private VBox leftVBox;
    @FXML
    private Button addToLeftButton;
    @FXML
    private VBox rightVBox;
    @FXML
    private Button addToBottomButton;
    @FXML
    private Button addToTopButton;
    @FXML
    private Button addToRightButton;
    @FXML
    private HBox bottomHBox;

    @FXML
    public void buttonClick(ActionEvent actionEvent) {
        if ( actionEvent.getSource() == addToRightButton ){
            rightVBox.getChildren().add(new Label("Clicked"));
        } else if ( actionEvent.getSource() == addToLeftButton ){
            leftVBox.getChildren().add(new Label("Clicked"));
        } else if ( actionEvent.getSource() == addToTopButton ){
            topHBox.getChildren().add(new Label("Clicked"));
        } else if ( actionEvent.getSource() == addToBottomButton ){
            bottomHBox.getChildren().add(new Label("Clicked"));
        }
    }
}
