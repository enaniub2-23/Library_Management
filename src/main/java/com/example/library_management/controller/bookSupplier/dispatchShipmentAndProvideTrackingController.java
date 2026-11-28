package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class dispatchShipmentAndProvideTrackingController
{
    @javafx.fxml.FXML
    private TextField poIdTF;
    @javafx.fxml.FXML
    private TextField courierNameTF;
    @javafx.fxml.FXML
    private TextField trackingNoTF;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }
    private ArrayList<PurchaseOrder> poList= new ArrayList<>();


    @javafx.fxml.FXML
    public void confirmDispatchOA(ActionEvent actionEvent){
        String poId=poIdTF.getText().trim();
        String courier= courierNameTF.getText().trim();
        String track= trackingNoTF.getText().trim();
        if(poId.isEmpty()||courier.isEmpty()||track.isEmpty()){
            AlertGenerator.showAlert("Validation Error","POID ,Courier,trackNo cant be empty");
            return;
        }
        ArrayList<PurchaseOrder> poList= BinaryFileHandler.readAll("PurchaseOrders.bin");
        for(PurchaseOrder p:poList){
            if(p.getPoId().equalsIgnoreCase(poId) && "STOCK_ALLOCATED".equalsIgnoreCase(p.getStatus())){
                p.markDispatched(courier+ "_" + track);
                BinaryFileHandler.rewriteAll("PurchaseOrders.bin",poList);

                statusLabel.setText("Dispatched"+ poId);
                AlertGenerator.showAlert("Success","Shipment Dispatched");
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }
}