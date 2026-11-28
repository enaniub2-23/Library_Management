package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Reservation;
import utility.AlertGenerator;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.security.KeyStore;
import java.util.ArrayList;

public class processPriorityBookReservationRequestsController
{
    @javafx.fxml.FXML
    private TableColumn<Reservation,String> statusCOL;
    @javafx.fxml.FXML
    private TableColumn<Reservation,Integer> memberIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Reservation,String> resevationIdCOL;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableView<Reservation> reservationTableView;
    @javafx.fxml.FXML
    private TableColumn<Reservation,Integer> isbnIdCOL;

    @javafx.fxml.FXML
    public void initialize() {
        resevationIdCOL.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        memberIdCOL.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        isbnIdCOL.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        try{
            loadPendingTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<Reservation>rList=new ArrayList<>();
    private void loadPendingTable() throws IOException {
        reservationTableView.getItems().clear();
        ArrayList<Reservation> rList= BinaryFileHandler.readAll("Reservations.bin");
        for(Reservation r: rList){
            if("PENDING".equalsIgnoreCase(r.getStatus())){
                reservationTableView.getItems().add(r);
            }
        }
    }


    @javafx.fxml.FXML
    public void approveAndHoldForPickupOA(ActionEvent actionEvent) throws IOException {
        Reservation selected = reservationTableView.getSelectionModel().getSelectedItem();
        if(selected==null){
            AlertGenerator.showAlert("Error","Select a reservation row.");
            return;
        }
        ArrayList<Reservation> rList=BinaryFileHandler.readAll("Reservations.bin");
        for(Reservation r:rList){
            if(r.getReservationId().equals(selected.getReservationId())){
                r.activateHold();
                BinaryFileHandler.rewriteAll("Reservations.bin",rList);
                statusLabel.setText("Hold Activate For"+r.getReservationId());
                AlertGenerator.showAlert("Success","Book held for priority pickup");
                loadPendingTable();
                return;
            }
        }
    }



    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/LibrarianDashboardView.fxml",null);
    }

}