package com.example.library_management.controller.librarian;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;
import utility.AlertGenerator;

import java.io.*;
import java.util.ArrayList;

public class removeDamageOrLostBookCopyController
{
    @javafx.fxml.FXML
    private TextField selectISBNNoTF;
    @javafx.fxml.FXML
    private ComboBox<String> removalReasonCB;
    private ArrayList<Book> bookList = new ArrayList<>();
    private Book targetBook=null;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        removalReasonCB.getItems().addAll("Damaged","Lost");
    }
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
    public void rewriteBooks(ArrayList<Book> bookList) throws IOException {
        FileOutputStream fos = new FileOutputStream("Books.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Book b: bookList){
            oos.writeObject(b);
        }
        oos.close();

    }




    @javafx.fxml.FXML
    public void findBookOA(ActionEvent actionEvent) throws IOException {
        String isbn = selectISBNNoTF.getText().trim();
        if(isbn.isEmpty()){
            AlertGenerator.showAlert("Error","Enter ISBN");
            return;
        }
        bookList=readBooks();

        targetBook = null;
        for(Book b:bookList){
            if(b.getIsbn().equals(isbn)){
                targetBook=b;
                break;
            }
        }
        if(targetBook == null){
            AlertGenerator.showAlert("Error","Book not Found");
            statusLabel.setText("ISBN NOT MATCHED");
        }else{
            statusLabel.setText("Book Found" + targetBook.getTitle() + " | Available Copies: " + targetBook.getAvailableCopies());
        }
    }

    @javafx.fxml.FXML
    public void dashBoardOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeCopyOA(ActionEvent actionEvent) throws IOException {
        if(targetBook == null){
            AlertGenerator.showAlert("Error","Find a book First");
            return;
        }
        String reason=removalReasonCB.getValue();
        if(reason==null){
            AlertGenerator.showAlert("Error","Please Select a reason");
            return;
        }
        if(targetBook.getAvailableCopies()<=0){
            AlertGenerator.showAlert("Error","You dont have any copies to remove");
            return;
        }
        rewriteBooks(bookList);
        targetBook.updateStock(-1);
        statusLabel.setText(targetBook.getTitle() + " | Available Copies: " + targetBook.getAvailableCopies());
        AlertGenerator.showAlert("Success","Book copy removed successfully");
    }

}