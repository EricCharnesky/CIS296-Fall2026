package org.example.week6fxbyhand;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

public class HelloApplication extends Application {

    private TextField investmentField;
    private TextField interestRateField;
    private TextField yearsField;
    private TextField futureValueField;



    public static void main(String[] args) {
        launch();
    }

    // murach chapter 12
    @Override
    public void start(Stage stage) throws IOException {
        // set stage title
        stage.setTitle("Future Value Calculator");

        // create grid and scene and add grid to scene
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 600, 300);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);


        investmentField = new TextField();
        grid.add(investmentField, 1, 0);         // col 2, row 1

        interestRateField = new TextField();
        grid.add(interestRateField, 1, 1);       // col 2, row 2

        yearsField = new TextField();
        grid.add(yearsField, 1, 2);              // col 2, row 3
        futureValueField = new TextField();
        futureValueField.setEditable(false);
        grid.add(futureValueField, 1, 3);        // col 2, row 4


        // col 1, row 1
        grid.add(new Label("Monthly Investment:"), 0, 0);
        // col 1, row 2
        grid.add(new Label("Yearly Interest Rate:"), 0, 1);
        // col 1, row 3
        grid.add(new Label("Years:"), 0, 2);
        // col 1, row 4
        grid.add(new Label("Future Value:"), 0, 3);


        // create two buttons
        Button calculateButton = new Button("Calculate");
        Button exitButton = new Button("Exit");

// create a horizontal box and add the buttons to it
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

// add the box to row 5, spanning 2 columns and 1 row
        grid.add(buttonBox, 0, 4, 2, 1);


        calculateButton.setOnAction(event -> {
            calculateButtonClicked();
        });

        // set scene and display stage
        stage.setScene(scene);
        stage.show();

    }

    private void calculateButtonClicked() {
        // get data from text fields
        double investment = Double.parseDouble(
                investmentField.getText());
        double rate = Double.parseDouble(
                interestRateField.getText());
        int years = Integer.parseInt(
                yearsField.getText());
        // calculate future value

        double futureValue = 0;

        for ( int month = 0; month < years * 12; month++ ){
            futureValue += investment;
            futureValue *= ( 1 + rate / 12 );
        }

        // set data in read-only text field
        NumberFormat currency =
                NumberFormat.getCurrencyInstance();
        futureValueField.setText(
                currency.format(futureValue));
    }



}
