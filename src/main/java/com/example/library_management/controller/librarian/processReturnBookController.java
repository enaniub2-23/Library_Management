package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import nonuser.Book;
import nonuser.Loantransaction;
import utility.AlertGenerator;

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
    public ArrayList<Book> readBooks() throws IOException {
        bookList.clear();
        File f = new File("Books.bin");
        if(!f.exists()){
            return bookList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                Book b =(Book) ois.readObject();
                bookList.add(b);
            }
        }catch (Exception e){
        }
        ois.close();
        return bookList;

    }
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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
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
        FileOutputStream txfos =new FileOutputStream("Transaction.bin");
        ObjectOutputStream txOos = new ObjectOutputStream(txfos);
        for(Loantransaction tx:transactionList){
            txOos.writeObject(tx);
        }
        txOos.close();

        ArrayList<Book> bookList=readBooks();
        for(Book b:bookList){
            if(b.getIsbn().equals(isbn)){
                b.updateStock(1);
                break;
            }
        }
        FileOutputStream bfos=new FileOutputStream("Books.bin");
        ObjectOutputStream bOos=new ObjectOutputStream(bfos);
        for(Book b:bookList){
            bOos.writeObject(b);
        }
        bOos.close();
        AlertGenerator.showAlert("Success","Book returned Successfully");

    }

}