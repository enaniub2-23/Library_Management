package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;

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

    @javafx.fxml.FXML
    public void confirmDispatchOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        String courier= courierNameTF.getText().trim();
        String track= trackingNoTF.getText();
        if(poId.isEmpty()||courier.isEmpty()||track.isEmpty()){
            AlertGenerator.showAlert("Validation Error","POID ,Courier,trackNo cant be empty");
            return;
        }
        ArrayList<PurchaseOrder> poList=readOrders();
        for(PurchaseOrder p:poList){
            if(p.getPoId().equalsIgnoreCase(poId) && "STOCK_ALLOCATED".equalsIgnoreCase(p.getStatus())){
                p.markDispatched(courier+ "_" + track);
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PurchaseOrders.bin"));
                for (PurchaseOrder pr: poList){
                    oos.writeObject(pr);
                }
                oos.close();
                statusLabel.setText("Dispatched"+ poId);
                AlertGenerator.showAlert("Success","Shipment Dispatched");
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
    }
}