package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.PurchaseOrder;
import utility.AlertGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class receiveIncomingPurchaseOrdersController
{
    @javafx.fxml.FXML
    private TableColumn<PurchaseOrder,String> poIdCOL;
    @javafx.fxml.FXML
    private TableColumn<PurchaseOrder,String> titleCOL;
    @javafx.fxml.FXML
    private TableView<PurchaseOrder> ordersTableView;
    @javafx.fxml.FXML
    private TableColumn<PurchaseOrder,String> statusCOL;
    @javafx.fxml.FXML
    private TableColumn<PurchaseOrder,Integer> quantityCOL;
    @javafx.fxml.FXML
    private ComboBox<String> selectOrderStatusCB;

    @javafx.fxml.FXML
    public void initialize() {
        selectOrderStatusCB.getItems().addAll("ALL","ORDERED","STOCK_ALLOCATED","Dispatched");
        poIdCOL.setCellValueFactory(new PropertyValueFactory<>("poId"));
        titleCOL.setCellValueFactory(new PropertyValueFactory<>("title"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        quantityCOL.setCellValueFactory(new PropertyValueFactory<>("quantity"));
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

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOrdersOA(ActionEvent actionEvent) throws IOException {
        String filter =selectOrderStatusCB.getValue();
        if(filter==null){
            AlertGenerator.showAlert("Error","Select a Status First");
        }
        ordersTableView.getItems().clear();
        ArrayList<PurchaseOrder> poList= readOrders();
        for(PurchaseOrder p:poList){
            if(p.getStatus().equalsIgnoreCase(filter)){
                ordersTableView.getItems().add(p);
            }
        }

    }
}