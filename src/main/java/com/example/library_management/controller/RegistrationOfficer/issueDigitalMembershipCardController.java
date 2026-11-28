package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class issueDigitalMembershipCardController
{
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TextField memberShipCardNoTextField1;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateAndIssueCardButtonOnAction(ActionEvent actionEvent) {

        String memberIdText = memberIdTextField.getText().trim();
        String cardNoText = memberShipCardNoTextField1.getText().trim();


        if (memberIdText.isEmpty() || cardNoText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Member ID and Membership Card No cannot be empty.");
            return;
        }

        int memberId, cardNo;
        try {
            memberId = Integer.parseInt(memberIdText);
            cardNo = Integer.parseInt(cardNoText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Member ID and Membership Card No must be valid integer numbers.");
            return;
        }

        if (memberId <= 0 || cardNo <= 0) {
            AlertGenerator.showAlert("Error", "Member ID and Membership Card No must be greater than 0.");
            return;
        }

        AlertGenerator.showAlert("Success", "Digital membership card validated and issued!");

        memberIdTextField.clear();
        memberShipCardNoTextField1.clear();

    }


    public void backToDashBoardButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/dashboardView.fxml",null);
    }
}