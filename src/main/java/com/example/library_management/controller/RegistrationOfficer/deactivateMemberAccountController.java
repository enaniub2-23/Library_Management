package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class deactivateMemberAccountController
{
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TextArea deactivationReasonTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashBoardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void confirmDeactivationButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        String reason = deactivationReasonTextArea.getText().trim();


        if (memberIdText.isEmpty() || reason.isEmpty()) {
            AlertGenerator.showAlert("Error", "Member ID and Deactivation Reason cannot be empty.");
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

        AlertGenerator.showAlert("Success", "Member account deactivation validated and confirmed!");

        memberIdTextField.clear();
        deactivationReasonTextArea.clear();
    }
}

