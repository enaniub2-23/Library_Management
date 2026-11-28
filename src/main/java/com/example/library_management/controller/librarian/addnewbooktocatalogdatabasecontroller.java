package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;
import utility.AlertGenerator;
import utility.AppendableObjectOutputStream;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class addnewbooktocatalogdatabasecontroller
{
    @javafx.fxml.FXML
    private TextField isbnTF;
    @javafx.fxml.FXML
    private TextField authorTF;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;
    @javafx.fxml.FXML
    private TextField copiesTF;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private Label statusLabel;


    @javafx.fxml.FXML
    public void initialize() {
        categoryCB.getItems().addAll("Fiction","Non-Fiction","History","Academic");
    }
    public ArrayList<Book> readBooks() throws IOException {
        File f = new File("Books.bin");
        ArrayList<Book> bookList = new ArrayList<>();
        if(!f.exists()) {
            return bookList;
        }
        FileInputStream fis =new FileInputStream(f);
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

    @javafx.fxml.FXML
    public void validateAndSaveBookOA(ActionEvent actionEvent) throws IOException {
        String isbn = isbnTF.getText().trim();
        String author = authorTF.getText().trim();
        String category= categoryCB.getValue();
        String title = titleTF.getText().trim();
        int copies;
        try{
            copies=Integer.parseInt(copiesTF.getText().trim());
            if(isbn.length() !=13 || title.isEmpty()||category ==null || copies<0 ){
                AlertGenerator.showAlert("Validation Error" ,"Enter 13-digit isbn,Title,Author,Category,and add copies");
                return;
            }
        } catch (NumberFormatException e){
            AlertGenerator.showAlert("Validation Error "," Copies must be a numeric value.");
            return;

        }
        ArrayList<Book> bookList2= readBooks();
        for (Book b : bookList2){
            if(b.getIsbn().equals(isbn)){
                AlertGenerator.showAlert("Duplicate ISBN" ,"Book With This Isbn Already Exists");
                return;
            }
        }
        Book newBook = new Book(isbn, title, author, category, copies, 0.0);
        BinaryFileHandler.appendObject("Book.bin",newBook);

        statusLabel.setText("Saved: " + title);
        AlertGenerator.showAlert("Success" ,"Book Added Success Fully");
    }
    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/LibrarianDashboardView.fxml",null);
    }



}



