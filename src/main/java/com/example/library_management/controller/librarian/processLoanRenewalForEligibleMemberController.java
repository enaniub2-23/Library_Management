package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Loantransaction;
import utility.AlertGenerator;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class processLoanRenewalForEligibleMemberController
{
    @javafx.fxml.FXML
    private TableColumn<Loantransaction,LocalDate> dueDateCOL;
    @javafx.fxml.FXML
    private TableColumn<Loantransaction,String> statusCOL;
    @javafx.fxml.FXML
    private TableColumn<Loantransaction,String> isbnCOL;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<Loantransaction,String> transactionCOL;
    @javafx.fxml.FXML
    private TableView<Loantransaction> loanTable;

    @javafx.fxml.FXML
    public void initialize() {
        transactionCOL.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        isbnCOL.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        dueDateCOL.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    private ArrayList<Loantransaction> transactionList = new ArrayList<>();
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
    public void renewLoanOA(ActionEvent actionEvent) throws IOException {
        Loantransaction selected = loanTable.getSelectionModel().getSelectedItem();
        if(selected == null){
            AlertGenerator.showAlert("Error","Select a Loan row");
            return;
        }
        ArrayList<Loantransaction> transactionList =readTransactions();
        for(Loantransaction tx: transactionList){
            if(tx.getTransactionId().equals(selected.getTransactionId())){
                tx.setDueDate(tx.getDueDate().plusDays(7));
                FileOutputStream tFos=new FileOutputStream("Transaction.bin");
                ObjectOutputStream tOos= new ObjectOutputStream(tFos);
                for (Loantransaction t:transactionList){
                    tOos.writeObject(t);
                }
                tOos.close();
                statusLabel.setText("New Due Date"+ tx.getDueDate());
                AlertGenerator.showAlert("Success","Loan renewed for more 7 days.");
                loadLoansOA(actionEvent);
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void loadLoansOA(ActionEvent actionEvent) throws IOException {
        int memberId;
        try{
            memberId= Integer.parseInt(memberIdTF.getText().trim());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Enter numeric Number ID");
            return;
        }
        loanTable.getItems().clear();
        ArrayList<Loantransaction> transactionList= readTransactions();
        for (Loantransaction tx: transactionList){
            if(tx.getMemberId() == memberId&& "ISSUED".equalsIgnoreCase(tx.getStatus())){
                loanTable.getItems().add(tx);
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
    }

}