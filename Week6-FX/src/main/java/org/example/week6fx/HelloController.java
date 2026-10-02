package org.example.week6fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private RadioButton espressoRadioButton;
    @FXML
    private RadioButton coffeeRadioButton;
    @FXML
    private RadioButton teaRadioButton;
    @FXML
    private CheckBox wholeMilkCheckBox;
    @FXML
    private CheckBox oatMilkCheckBox;
    @FXML
    private CheckBox soyMilkCheckBox;
    @FXML
    private CheckBox skimMilkCheckBox;
    @FXML
    private ToggleGroup beverage;
    @FXML
    private TextArea receiptTextArea;
    @FXML
    private Button addToOrderButton;
    @FXML
    private Label grandTotalLabel;

    double grandTotal;

    // runs after FXML fields are created, unlike the constructor
    @FXML
    public void initialize() {
        grandTotal = 0;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {

    }

    @FXML
    public void addToOrder(ActionEvent actionEvent) {
        Beverage beverage;
        if ( coffeeRadioButton.isSelected() ){
            beverage = new Beverage(BeverageType.COFFEE);
            coffeeRadioButton.setSelected(false);
        } else if ( teaRadioButton.isSelected() ){
            beverage = new Beverage(BeverageType.TEA);
            teaRadioButton.setSelected(false);
        } else {
            beverage = new Beverage(BeverageType.ESPRESSO);
            espressoRadioButton.setSelected(false);
        }

        if ( wholeMilkCheckBox.isSelected() ){
            beverage.addAddon(Addon.WHOLE_MILK);
            wholeMilkCheckBox.setSelected(false);
        }
        if (skimMilkCheckBox.isSelected()) {
            beverage.addAddon(Addon.SKIM_MILK);
            skimMilkCheckBox.setSelected(false);
        }
        if (oatMilkCheckBox.isSelected()){
            beverage.addAddon(Addon.OAT_MILK);
            oatMilkCheckBox.setSelected(false);
        }
        if (soyMilkCheckBox.isSelected()){
            beverage.addAddon(Addon.SOY_MILK);
            soyMilkCheckBox.setSelected(false);
        }



        receiptTextArea.appendText(beverage.toString() + "\n\n");

        grandTotal += beverage.getPrice();
        grandTotalLabel.setText("Grand Total $" + grandTotal);
    }
}
