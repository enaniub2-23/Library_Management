package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class reserveBookController
{
    @javafx.fxml.FXML
    private TextField newBookIsbnTextField;
    @javafx.fxml.FXML
    private TextField memberIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void validateAndReserveNewBookButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        String isbnText = newBookIsbnTextField.getText().trim();

        if (memberIdText.isEmpty() || isbnText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Please enter both Member ID and ISBN.");
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

        int isbn;
        try {
            isbn = Integer.parseInt(isbnText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "ISBN must be a valid integer number.");
            return;
        }

        if (isbn <= 0) {
            AlertGenerator.showAlert("Error", "ISBN must be greater than 0.");
            return;
        }

        AlertGenerator.showAlert("Success", "Book reservation validated and submitted!");

        memberIdTextField.clear();
        newBookIsbnTextField.clear();
    }
}

