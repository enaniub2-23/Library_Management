package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class searchBookController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private ComboBox genreCombobox;
    @javafx.fxml.FXML
    private TableColumn titleTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn authorTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn genreTableViewColumn;
    @javafx.fxml.FXML
    private TextField authorTextField;
    @javafx.fxml.FXML
    private TableView tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchBookButtonOnAction(ActionEvent actionEvent) {
    }
}