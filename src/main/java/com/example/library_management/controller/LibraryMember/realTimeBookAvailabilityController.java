package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class realTimeBookAvailabilityController
{
    @javafx.fxml.FXML
    private Label showAvailableQuantityLabel;
    @javafx.fxml.FXML
    private TextField isbnNoTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String isbn = isbnNoTextField.getText().trim();


        if (isbn.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter an ISBN number.");
            return;
        }

        if (isbn.contains(" ")) {
            AlertGenerator.showAlert("Error", "ISBN cannot contain spaces.");
            return;
        }

        int availableQuantity = 0;
        showAvailableQuantityLabel.setText(String.valueOf(availableQuantity));
    }
}


