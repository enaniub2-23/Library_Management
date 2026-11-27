package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;
import nonuser.Loantransaction;
import utility.AlertGenerator;
import utility.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class processPhysicalBookReservationRequestsController
{
    @javafx.fxml.FXML
    private TextField enterMemberIdTF;
    @javafx.fxml.FXML
    private TextField isbnNoTF;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }
    private ArrayList<Book> bookList=new ArrayList<>();
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
    private ArrayList<Loantransaction> transactionList=new ArrayList<>();
    public ArrayList<Loantransaction> readTransactions() throws IOException {
        transactionList.clear();
        File f = new File("Transaction.bin");
        if(!f.exists()){
            return transactionList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                Loantransaction l =(Loantransaction) ois.readObject();
                transactionList.add(l);
            }
        }catch (Exception e){
        }
        ois.close();
        return transactionList;

    }


    @javafx.fxml.FXML
    public void issueBookOA(ActionEvent actionEvent) throws IOException {
        String isbn =isbnNoTF.getText().trim();
        int memberId;
        try{
            memberId=Integer.parseInt(enterMemberIdTF.getText().trim());
        } catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Member Id must be Numeric");
            return;
        }

        ArrayList<Book> bookList= readBooks();
        Book target =null;
        for(Book b:bookList){
            if(b.getIsbn().equals(isbn)){
                target=b;
                break;
            }
        }
        if(target ==null || !target.isAvailable()){
            AlertGenerator.showAlert("Unavailable","Out of Stock");
            return;
        }

        ArrayList<Loantransaction> transactionList= readTransactions();
        String txId ="TX-"+(1001 +transactionList.size());
        LocalDate due =LocalDate.now().plusDays(14);

        Loantransaction tx = new Loantransaction(txId,memberId,isbn,LocalDate.now(),due,"ISSUED");
        File f = new File("Transaction.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        if(f.exists()){
            fos =new FileOutputStream(f,true);
            oos=new AppendableObjectOutputStream(fos);
        }else {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(tx);
        oos.close();
        target.updateStock(-1);
        ObjectOutputStream bookOos=new ObjectOutputStream(new FileOutputStream("Book.bin"));
        for(Book b:bookList){
            bookOos.writeObject(b);
        }
        bookOos.close();
        statusLabel.setText("Issued" + txId +" | Due"+due);
        AlertGenerator.showAlert("Success","Book Issued Successfully.Due Date: "+due);



    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
    }

}