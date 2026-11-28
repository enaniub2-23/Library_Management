package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class requestOnlineBookLoanRenewalController {
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TextField transactionIdTextField;
    @javafx.fxml.FXML
    private TextField isbnNoTextField;
    @javafx.fxml.FXML
    private Label showActiveLoanLabel;
    private boolean isLoanVerified = false;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void requestRenewalButtOnAction(ActionEvent actionEvent) {
        if (!validateInputs()) {
            return;
        }
        if (!isLoanVerified) {
            AlertGenerator.showAlert("Error", "Please verify and check the loan first.");
            return;
        }

        AlertGenerator.showAlert("Success", "Book loan renewal request submitted for 7 days!");

        memberIdTextField.clear();
        transactionIdTextField.clear();
        isbnNoTextField.clear();
        showActiveLoanLabel.setText("");
        isLoanVerified = false;
    }

    private boolean validateInputs() {
        String memberIdText = memberIdTextField.getText().trim();
        String txId = transactionIdTextField.getText().trim();
        String isbnText = isbnNoTextField.getText().trim();

        if (memberIdText.isEmpty() || txId.isEmpty() || isbnText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please fill in Member ID, Transaction ID, and ISBN.");
            return false;
        }

        int memberId;
        try {
            memberId = Integer.parseInt(memberIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Member ID must be a valid integer number.");
            return false;
        }

        if (memberId <= 0) {
            AlertGenerator.showAlert("Error", "Member ID must be greater than 0.");
            return false;
        }

        int isbn;
        try {
            isbn = Integer.parseInt(isbnText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "ISBN must be a valid integer number.");
            return false;
        }

        if (isbn <= 0) {
            AlertGenerator.showAlert("Error", "ISBN must be greater than 0.");
            return false;
        }

        return true;
    }



    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/LibraryMember/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void verifyAndCheckLoanButtonOnAction(ActionEvent actionEvent) {
        if (!validateInputs()) {
            isLoanVerified = false;
            return;
        }

        isLoanVerified = true;
        showActiveLoanLabel.setText("Active Loan Found (Eligible for Renewal)");
        AlertGenerator.showAlert("Verified", "Loan details verified successfully!");
    }
}