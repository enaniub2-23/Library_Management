package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class verifyMemberDocumentsController {
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TextField nIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void verifyAndCheckSystemRecordButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        String nidText = nIDTextField.getText().trim();


        if (memberIdText.isEmpty() || nidText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Member ID and NID cannot be empty.");
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

        long nid;
        try {
            nid = Long.parseLong(nidText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "NID must be a valid number.");
            return;
        }

        if (nid <= 0) {
            AlertGenerator.showAlert("Error", "NID must be greater than 0.");
            return;
        }

        AlertGenerator.showAlert("Success", "Member documents validated and verified!");

        memberIdTextField.clear();
        nIDTextField.clear();
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/RegistrationOfficer/dashboardView.fxml", null);
    }
}