package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import nonuser.Loantransaction;
import utility.AlertGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class generateDailyCirculationSummaryReportController
{
    @javafx.fxml.FXML
    private Label totalBookReturnedLabel;
    @javafx.fxml.FXML
    private Label activeOverdueBooksLabel;
    @javafx.fxml.FXML
    private Label totalBookIssueLabel;
    @javafx.fxml.FXML
    private DatePicker reportDateDP;

    @javafx.fxml.FXML
    public void initialize() {
        reportDateDP.setValue(LocalDate.now());
    }
    private ArrayList<Loantransaction> transactionList= new ArrayList<>();
    public ArrayList<Loantransaction> readTransactions() throws IOException {
        transactionList.clear();
        File f = new File("Transaction.bin");
        if (!f.exists()) {
            return transactionList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (true) {
                Loantransaction l = (Loantransaction) ois.readObject();
                transactionList.add(l);
            }
        } catch (Exception e) {
        }
        ois.close();
        return transactionList;
    }
    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void generatereportOA(ActionEvent actionEvent) throws IOException {
        LocalDate date = reportDateDP.getValue();
        if(date==null|| date.isAfter(LocalDate.now())){
            AlertGenerator.showAlert("Error","Select today or a past date");
            return;
        }
        ArrayList<Loantransaction> tList= readTransactions();
        int issued=0,returned=0,overdue=0;
        for(Loantransaction tx:tList){
            if(tx.getIssueDate().equals(date)){
                issued++;
            }
            if("RETURNED".equalsIgnoreCase(tx.getStatus())){
                returned++;
            }
            if("ISSUED".equalsIgnoreCase(tx.getStatus())&&tx.getDueDate().isBefore(date)){
                overdue++;
            }
            totalBookIssueLabel.setText("Book Issued On Date"+issued);
            totalBookReturnedLabel.setText("Total boooks returned"+returned);
            activeOverdueBooksLabel.setText("Active OverDue Books:"+ overdue);
        }

    }
}