package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class processReplacementForDamagedItemsController
{
    @javafx.fxml.FXML
    private TextField poIdTF;
    @javafx.fxml.FXML
    private TextField damagedCopyCountTF;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionCB;

    @javafx.fxml.FXML
    public void initialize() {
        resolutionCB.getItems().addAll("Replacement Copy","Credit Note");

    }
    private ArrayList<PurchaseOrder> poList = new ArrayList<>();
    public ArrayList<PurchaseOrder> readOrders() throws IOException {
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
    public void submitResolutionOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        String resolution= resolutionCB.getValue();
        int damagedQty;
        try{
            damagedQty=Integer.parseInt(damagedCopyCountTF.getText().trim());
        } catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Damaged Copy count must be valid number");
            return;
        }
        if(poId.isEmpty()|| damagedQty<=0 ||resolution==null){
            AlertGenerator.showAlert("Error","PO id , Damaged Copy count resolution selection is missing");
            return;
        }
        ArrayList<PurchaseOrder> poList= readOrders();
        for (PurchaseOrder po:poList){
            if(po.getPoId().equalsIgnoreCase(poId)){
                po.setStatus("REPLACEMENT_LOGGED");
                ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("PurchaseOrders.bin"));
                for(PurchaseOrder item :poList){
                    oos.writeObject(item);
                }
                oos.close();
                statusLabel.setText("Logged " + resolution + " (" + damagedQty + " copies) for " + poId);
                AlertGenerator.showAlert("Success", resolution + " recorded for " + damagedQty + " damaged copies.");
                return;
            }
            AlertGenerator.showAlert("Not Found","PO ID doesn't Exits");
        }


    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }
}