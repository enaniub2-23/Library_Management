package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class submitPriceQuotationAndDeliveryScheduleController
{
    @FXML
    private TextField poIdTF;
    @FXML
    private TextField discountTF;
    @FXML
    private TextField deliveryDaysTF;
    @FXML
    private TextField unitPriceTF;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
    }
    private ArrayList<PurchaseOrder> poList=new ArrayList<>();
    public ArrayList<PurchaseOrder> readOrders() throws IOException {
        poList.clear();
        File f = new File("PurchaseOrders.bin");
        if(!f.exists()){
            return poList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                PurchaseOrder p =(PurchaseOrder) ois.readObject();
                poList.add(p);
            }
        }catch (Exception e){
        }
        ois.close();
        return poList;

    }

    @FXML
    public void submitQuotationOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        double price;
        double discount;
        int days;
        try{
            price=Double.parseDouble(unitPriceTF.getText());
            discount=Double.parseDouble(discountTF.getText());
            days=Integer.parseInt(deliveryDaysTF.getText());
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Validation Error","Unit Price,Discount Deliver Date Must be Valid Number");
            return;
        }
        if(poId.isEmpty()||price<=0||days<=0){
            AlertGenerator.showAlert("Validation Error","PO ID Cant be Empty , Price & Delivery Days must be >0,Discount >=0");
            return;
        }
        ArrayList<PurchaseOrder> poList=readOrders();
        for (PurchaseOrder p: poList){
            if(p.getPoId().equalsIgnoreCase(poId)){
                double finalPrice= price*(1-discount/100.0);
                p.attachQuotation(finalPrice);
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PurchaseOrders.bin"));
            for(PurchaseOrder pr:poList){
                oos.writeObject(pr);
            }
            oos.close();
            statusLabel.setText("Quotation save for"+poId);
            AlertGenerator.showAlert("Success","Quotation Submitted");
            return;
        }

    }

    @FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }
}