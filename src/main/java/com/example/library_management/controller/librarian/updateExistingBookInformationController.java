package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;
import utility.AlertGenerator;
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
        for (Book b:bookList){
            oos.writeObject(b);
        }
        oos.close();

    }


    @javafx.fxml.FXML
    public void searchBookOA(ActionEvent actionEvent) throws IOException {
        String isbn= isbnNoTF.getText().trim();
        bookList=readBooks();
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
        rewriteBooks(bookList);
        statusLabel.setText("Book updated");
        AlertGenerator.showAlert("Success","Book Record Updated Successfully");

    }

}