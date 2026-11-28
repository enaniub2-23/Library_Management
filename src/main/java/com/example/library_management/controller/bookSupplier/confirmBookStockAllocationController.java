package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class confirmBookStockAllocationController
{
    @javafx.fxml.FXML
    private TextField poIdTF;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private DatePicker estimatePickingDateDP;

    @javafx.fxml.FXML
    public void initialize() {
        estimatePickingDateDP.setValue(LocalDate.now().plusDays(2));
    }
    private ArrayList<PurchaseOrder> poList= new ArrayList<>();

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void confirmAllocationOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        ArrayList<PurchaseOrder> poList= BinaryFileHandler.readAll("PurchaseOrders.bin");
        for(PurchaseOrder p:poList){
            if(p.getPoId().equalsIgnoreCase(poId) && "ORDERED".equalsIgnoreCase(p.getStatus())){
                p.setStatus("STOCK_ALLOCATED");
                BinaryFileHandler.rewriteAll("PurchaseOrders.bin",poList);

                statusLabel.setText("Stock Allocated for"+poId);
                AlertGenerator.showAlert("Success","Stock Allocation Confirmed");
            }
        }

    }
}