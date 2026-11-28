package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class myAccountAndFineController {
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private Label showTotalDueFineLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/LibraryMember/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void calculateAllDueFineButtonOnAction(ActionEvent actionEvent) {

        String memberIdText = memberIdTextField.getText().trim();

        if (memberIdText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter your Member ID.");
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

        double totalDueFine = 0.0;
        showTotalDueFineLabel.setText(String.format("%.2f BDT", totalDueFine));
    }

}