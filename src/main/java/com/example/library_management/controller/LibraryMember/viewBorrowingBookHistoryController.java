package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.BorrowBookHistoryHelper;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class viewBorrowingBookHistoryController {
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<BorrowBookHistoryHelper, String> iSBNNoTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowBookHistoryHelper, String> titleTableViewColumn;
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BorrowBookHistoryHelper, LocalDate> issueDateTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowBookHistoryHelper, LocalDate> returnDateTableViewColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<BorrowBookHistoryHelper, String> statusTableViewColumn;
    @javafx.fxml.FXML
    private TableView<BorrowBookHistoryHelper> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        iSBNNoTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        issueDateTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        returnDateTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/LibraryMember/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void bookBorrowingHistoryButtonOnAction(ActionEvent actionEvent) {
        String memberIdText = memberIdTextField.getText().trim();
        LocalDate startDate = startDateDatePicker.getValue();
        LocalDate endDate = endDateDatePicker.getValue();

        if (memberIdText.isEmpty() || startDate == null || endDate == null) {
            AlertGenerator.showAlert("Error", "Please enter Member ID and select both Start Date and End Date.");
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

        if (endDate.isBefore(startDate)) {
            AlertGenerator.showAlert("Error", "End date cannot be before start date.");
            return;
        }

        AlertGenerator.showAlert("Success", "Inputs validated! Loading borrowing history...");
    }
}