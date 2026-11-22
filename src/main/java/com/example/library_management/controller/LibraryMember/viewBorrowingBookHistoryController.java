package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class viewBorrowingBookHistoryController
{
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn iSBNNoTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn titleTableViewColumn;
    @javafx.fxml.FXML
    private TextField memberIdTextField;
    @javafx.fxml.FXML
    private TableColumn issueDateTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn returnDateTableViewColumn;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn statusTableViewColumn;
    @javafx.fxml.FXML
    private TableView tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookBorrowingHistoryButtonOnAction(ActionEvent actionEvent) {
    }
}