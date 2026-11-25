package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nonuser.Book;

import java.util.ArrayList;

public class addNewBookToCatalogDataBaseController
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

    @javafx.fxml.FXML
    public void validateAndSaveBookOA(ActionEvent actionEvent) {
        String isbn = isbnTF.getText().trim();
        String author = authorTF.getText().trim();
        String category= categoryCB.getValue();
        String title = titleTF.getText().trim();
        String copies =copiesTF.getText().trim();


    }

    @javafx.fxml.FXML
    public void backToDashBoardOA(ActionEvent actionEvent) {
    }
}