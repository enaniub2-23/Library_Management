package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class trackInvoicePaymentStatusController
{
    @javafx.fxml.FXML
    private TableColumn poIdCOL;
    @javafx.fxml.FXML
    private TableColumn amountCOL;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private Label billingAmountLabel;
    @javafx.fxml.FXML
    private TableColumn invoiceNoCOL;
    @javafx.fxml.FXML
    private TableView paymentTableView;
    @javafx.fxml.FXML
    private ComboBox paymentStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkStatusOA(ActionEvent actionEvent) {
    }
}