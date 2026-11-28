package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class updateMemberProfileInformationController {
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TextArea newAddressTextArea;
    @javafx.fxml.FXML
    private TextArea pastAddressTextArea;
    @javafx.fxml.FXML
    private TextField newPhoneNumberTextField;
    @javafx.fxml.FXML
    private TextField pastPhoneNumberTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashBoardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/RegistrationOfficer/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void validateAndUpdateProfileButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        String pastPhone = pastPhoneNumberTextField.getText().trim();
        String newPhone = newPhoneNumberTextField.getText().trim();
        String pastAddress = pastAddressTextArea.getText().trim();
        String newAddress = newAddressTextArea.getText().trim();


        if (memberIdText.isEmpty() || pastPhone.isEmpty() || newPhone.isEmpty()
                || pastAddress.isEmpty() || newAddress.isEmpty()) {
            AlertGenerator.showAlert("Error", "All fields must be filled out.");
            return;
        }

        int memberId;
        try {
            memberId = Integer.parseInt(memberIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Member ID must be a valid integer number.");
            return;
        }

        if (memberId <= 0) {
            AlertGenerator.showAlert("Error", "Member ID must be greater than 0.");
            return;
        }
        AlertGenerator.showAlert("Success", "Member profile information validated and updated!");

        memberIdTextField.clear();
        pastPhoneNumberTextField.clear();
        newPhoneNumberTextField.clear();
        pastAddressTextArea.clear();
        newAddressTextArea.clear();
    }
}