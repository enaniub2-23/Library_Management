package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class receiveIncomingPurchaseOrdersController
{
    @javafx.fxml.FXML
    private TableColumn poIdCOL;
    @javafx.fxml.FXML
    private TableColumn titleCOL;
    @javafx.fxml.FXML
    private TableView ordersTableView;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private TableColumn quantityCOL;
    @javafx.fxml.FXML
    private ComboBox selectOrderStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOrdersOA(ActionEvent actionEvent) {
    }
}