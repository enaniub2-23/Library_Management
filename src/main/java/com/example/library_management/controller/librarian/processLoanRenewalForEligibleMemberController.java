package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class processLoanRenewalForEligibleMemberController
{
    @javafx.fxml.FXML
    private TableView loanTableView;
    @javafx.fxml.FXML
    private TableColumn dueDateCOL;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private TableColumn isbnCOL;
    @javafx.fxml.FXML
    private TableColumn issueDateCOL;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void renewLoanOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadLoansOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
    }
}