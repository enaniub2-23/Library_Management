package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Invoice;
import utility.AlertGenerator;
import utility.AppendableObjectOutputStream;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class submitSupplyInvoiceAndDeliveryReceiptController
{
    @FXML
    private TextField poIdTF;
    @FXML
    private TextField billedAmountTF;
    @FXML
    private TextField invoiceNoTF;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
    }
    private ArrayList<Invoice> invoiceList= new ArrayList<>();


    @FXML
    public void submitInvoiceOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        String invNo=invoiceNoTF.getText().trim();
        double amount;
        try{
            amount=Double.parseDouble(billedAmountTF.getText());
        } catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Amount Must be Numeric");
            return;
        }
        if(poId.isEmpty()|| invNo.isEmpty() || amount<=0){
            AlertGenerator.showAlert("Error","IDs Cant Be empty and Amount must be >0 ");
            return;
        }
        ArrayList<Invoice> invList= BinaryFileHandler.readAll("Invoices.bin");
        for(Invoice in:invList){
            if(in.getInvoiceId().equalsIgnoreCase(invNo)){
                AlertGenerator.showAlert("Error","Invoice Already Exists");
                return;
            }
        }
        int supplierId = 0;
        Invoice newInv= new Invoice(invNo,poId,supplierId,amount,false);
        BinaryFileHandler.appendObject("Invoices.bin",newInv);

        statusLabel.setText("Invoice " + invNo + " submitted.");
        AlertGenerator.showAlert("Success", "Invoice Submitted Successfully.");
    }

    @FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }
}