package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class processPriorityBookReservationRequestsController
{
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private TableColumn requestIdCOL;
    @javafx.fxml.FXML
    private TableColumn memberIdCOL;
    @javafx.fxml.FXML
    private TableColumn resevationIdCOL;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableView reservationTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approveAndHoldForPickupOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
    }
}