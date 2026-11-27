package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;
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
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/BookSupplierDashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void confirmAllocationOA(ActionEvent actionEvent) throws IOException {
        String poId=poIdTF.getText().trim();
        ArrayList<PurchaseOrder> poList=readOrders();
        for(PurchaseOrder p:poList){
            if(p.getPoId().equalsIgnoreCase(poId) && "ORDERED".equalsIgnoreCase(p.getStatus())){
                p.setStatus("STOCK_ALLOCATED");
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PurchaseOrder.bin"));
                for(PurchaseOrder pr: poList){
                    oos.writeObject(pr);
                }
                oos.close();
                statusLabel.setText("Stock Allocated for"+poId);
                AlertGenerator.showAlert("Success","Stock Allocation Confirmed");
            }
        }

    }
}