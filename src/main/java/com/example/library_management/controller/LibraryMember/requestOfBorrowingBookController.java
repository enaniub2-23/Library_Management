package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class requestOfBorrowingBookController
{
    @javafx.fxml.FXML
    private DatePicker pickUpDateDatePicker;
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private DatePicker returnDateDatePicker;
    @javafx.fxml.FXML
    private TextField isbnBoTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void verifyAndSubmitButtononAction(ActionEvent actionEvent) {

        String memberIdText = memberIdTextField.getText().trim();
        String isbnText = isbnBoTextField.getText().trim();
        LocalDate pickUpDate = pickUpDateDatePicker.getValue();
        LocalDate returnDate = returnDateDatePicker.getValue();


        if (memberIdText.isEmpty() || isbnText.isEmpty() || pickUpDate == null || returnDate == null) {
            AlertGenerator.showAlert("Error", "Please fill in all fields and select both dates.");
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

        LocalDate today = LocalDate.now();
        if (pickUpDate.isBefore(today) || pickUpDate.isAfter(today.plusDays(3))) {
            AlertGenerator.showAlert("Error", "Pick-up date must be between today and the next 3 days.");
            return;
        }

        if (!returnDate.isAfter(pickUpDate)) {
            AlertGenerator.showAlert("Error", "Return date must be after the pick-up date.");
            return;
        }

        AlertGenerator.showAlert("Success", "Borrow request verified and submitted!");

        memberIdTextField.clear();
        isbnBoTextField.clear();
        pickUpDateDatePicker.setValue(null);
        returnDateDatePicker.setValue(null);
    }
}