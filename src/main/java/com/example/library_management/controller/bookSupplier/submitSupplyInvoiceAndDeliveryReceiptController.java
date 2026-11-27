package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Invoice;
import utility.AlertGenerator;
import utility.AppendableObjectOutputStream;
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
    public ArrayList<Invoice> readInvoices() throws IOException {
        invoiceList.clear();
        File f = new File("Invoices.bin");
        if(!f.exists()){
            return invoiceList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                Invoice i =(Invoice) ois.readObject();
                invoiceList.add(i);
            }
        }catch (Exception e){
        }
        ois.close();
        return invoiceList;

    }

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
        ArrayList<Invoice> invList= readInvoices();
        for(Invoice in:invList){
            if(in.getInvoiceId().equalsIgnoreCase(invNo)){
                AlertGenerator.showAlert("Error","Invoice Already Exists");
                return;
            }
        }
        int supplierId = 0;
        Invoice newInv= new Invoice(invNo,poId,supplierId,amount,false);
        File f = new File("Invoices.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        if(f.exists()){
            fos= new FileOutputStream(f,true);
            oos= new AppendableObjectOutputStream(fos);
        }else{
            fos = new FileOutputStream(f);
            oos= new ObjectOutputStream(fos);
        }
        oos.writeObject(newInv);
        oos.close();
        statusLabel.setText("Invoice " + invNo + " submitted.");
        AlertGenerator.showAlert("Success", "Invoice Submitted Successfully.");
    }

    @FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }
}