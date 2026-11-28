package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class renewAnnualMemberSubscriptionController
{
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> renewalDurationComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        renewalDurationComboBox.getItems().addAll("Three Month "," Six Month","one year");
    }

    @javafx.fxml.FXML
    public void confirmRenewalButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        String duration = renewalDurationComboBox.getValue();


        if (memberIdText.isEmpty() || duration.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter Member ID and select a renewal duration.");
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

        AlertGenerator.showAlert("Success", "Annual membership subscription renewed successfully!");

        memberIdTextField.clear();
        renewalDurationComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/RegistrationOfficer/dashboardView.fxml", null);
    }
}