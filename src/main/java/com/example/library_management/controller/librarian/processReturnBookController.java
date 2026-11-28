package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import nonuser.Book;
import nonuser.Loantransaction;
import utility.AlertGenerator;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class processReturnBookController
{
    @javafx.fxml.FXML
    private TextField enterMemberIdTF;
    @javafx.fxml.FXML
    private TextField isbnNoTF;
    private ArrayList<Book>bookList = new ArrayList<>();
    private ArrayList<Loantransaction> transactionList = new ArrayList<>();




    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/LibrarianDashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void returnBookOA(ActionEvent actionEvent) throws IOException {
        String isbn = isbnNoTF.getText().trim();
        int memberId;
        try{
            memberId=Integer.parseInt(enterMemberIdTF.getText().trim());
        }catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Member Id must be numeric");
            return;
        }
        boolean found =false;
        for(Loantransaction tx:transactionList){
            if(tx.getMemberId() == memberId && tx.getIsbn().equals(isbn) && "ISSUED".equalsIgnoreCase(tx.getStatus())){
                tx.setStatus("RETURNED");
                found =true;
                return;
            }
        }
        if(!found){
            AlertGenerator.showAlert("Not Found","No Active ISSUED loan found");
            return;
        }
        BinaryFileHandler.rewriteAll("Transaction.bin",transactionList);


        ArrayList<Book> bookList= BinaryFileHandler.readAll("Books.bin");
        for(Book b:bookList){
            if(b.getIsbn().equals(isbn)){
                b.updateStock(1);
                break;
            }
        }
        BinaryFileHandler.rewriteAll("Books.bin",bookList);

        AlertGenerator.showAlert("Success","Book returned Successfully");

    }

}