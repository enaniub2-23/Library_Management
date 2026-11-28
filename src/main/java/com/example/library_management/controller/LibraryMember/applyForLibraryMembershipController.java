package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

import static utility.AlertGenerator.showAlert;

public class applyForLibraryMembershipController
{
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TextField nidTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextArea addressTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void validateAndSubmitButtonOnAction(ActionEvent actionEvent) {

        String name = nameTextField.getText().trim();
        String phoneText = phoneTextField.getText().trim();
        String nidText = nidTextField.getText().trim();
        String address = addressTextArea.getText().trim();


        if (name.isEmpty() || phoneText.isEmpty() || nidText.isEmpty() || address.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please fill in all fields.");
            return;
        }


        long nid;
        try {
            nid = Long.parseLong(nidText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "NID must be a valid number.");
            return;
        }

        AlertGenerator.showAlert("Success", "Application validated and submitted!");

        nameTextField.clear();
        phoneTextField.clear();
        nidTextField.clear();
        addressTextArea.clear();
    }
}



