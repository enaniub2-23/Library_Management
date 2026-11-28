package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;
import utility.AlertGenerator;
import utility.BinaryFileHandler;
import utility.SceneSwitchingHelper;

import java.io.*;
import java.util.ArrayList;

public class updateExistingBookInformationController
{
    @javafx.fxml.FXML
    private TextField authorTF;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private TextField isbnNoTF;

    private ArrayList<Book> bookList = new ArrayList<>();
    private Book targetBook = null;

    @javafx.fxml.FXML
    public void initialize() {
        categoryCB.getItems().addAll("Fiction","Non-Fiction","History","Academic");
    }




    @javafx.fxml.FXML
    public void searchBookOA(ActionEvent actionEvent) {
        String isbn= isbnNoTF.getText().trim();
        bookList= BinaryFileHandler.readAll("Books.bin");
        targetBook=null;
        for(Book b:bookList){
            if(b.getIsbn().equals(isbn)){
                targetBook=b;
                break;
            }
        }
        if(targetBook==null){
            statusLabel.setText("Books Not Found");
        }else{
            titleTF.setText(targetBook.getTitle());
            authorTF.setText(targetBook.getAuthor());
            categoryCB.setValue(targetBook.getCategory());
            statusLabel.setText("Books Found");
        }


    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/LibrarianDashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void updateBookOA(ActionEvent actionEvent) throws IOException {
        if(targetBook == null){
            return;
        }
        targetBook.setTitle(titleTF.getText().trim());
        targetBook.setAuthor(authorTF.getText().trim());
        targetBook.setCategory(categoryCB.getValue());
        BinaryFileHandler.rewriteAll("Books.bin",bookList);
        statusLabel.setText("Book updated");
        AlertGenerator.showAlert("Success","Book Record Updated Successfully");

    }

}