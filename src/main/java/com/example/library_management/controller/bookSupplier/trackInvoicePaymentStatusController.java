package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Invoice;
import nonuser.PurchaseOrder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class trackInvoicePaymentStatusController
{
    @javafx.fxml.FXML
    private TableColumn<Invoice,String> poIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Invoice,Double> amountCOL;
    @javafx.fxml.FXML
    private TableColumn<Invoice, String> statusCOL;
    @javafx.fxml.FXML
    private Label billingAmountLabel;
    @javafx.fxml.FXML
    private TableColumn<Invoice,String> invoiceNoCOL;
    @javafx.fxml.FXML
    private TableView<Invoice> paymentTableView;
    @javafx.fxml.FXML
    private ComboBox <String> paymentStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
        paymentStatusCB.getItems().addAll("ALL","UNPAID","PAID");
        paymentStatusCB.setValue("ALL");
        invoiceNoCOL.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        poIdCOL.setCellValueFactory(new PropertyValueFactory<>("poId"));
        amountCOL.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    private ArrayList<Invoice> invList = new ArrayList<>();
    public ArrayList<Invoice> readInvoices() throws IOException {
        File f = new File("Invoices.bin");
        if(!f.exists()){
            return invList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                Invoice i =(Invoice) ois.readObject();
                invList.add(i);
            }
        }catch (Exception e){
        }
        ois.close();
        return invList;

    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void checkStatusOA(ActionEvent actionEvent) throws IOException {
        String filter = paymentStatusCB.getValue();
        paymentTableView.getItems().clear();
        double unPaidSum=0.0;
        ArrayList<Invoice> invList= readInvoices();
        for(Invoice inv: invList){
            if(!inv.isSettled()){
                unPaidSum=unPaidSum +inv.getTotalAmount();
            }
            if("ALL".equals(filter) || inv.getStatus().equalsIgnoreCase(filter)){
                paymentTableView.getItems().add(inv);
            }

        }
        billingAmountLabel.setText("Total Unpaid Balance: "+ unPaidSum + "BDT");
    }
}