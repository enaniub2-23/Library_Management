package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Book;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class searchBookController {
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> genreCombobox;
    @javafx.fxml.FXML
    private TableColumn<Book, String> titleTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<Book, String> authorTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<Book, String> genreTableViewColumn;
    @javafx.fxml.FXML
    private TextField authorTextField;
    @javafx.fxml.FXML
    private TableView<Book> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        genreCombobox.getItems().addAll("Crime", "Horror", "Romance", "Action", "Science & Technology", "Science Fiction",
                "Dystopian", "Philosophy", "Travel", "Psychology", "Health & Wellness", "Drama", "Food", "Religion");

        titleTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/LibraryMember/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void searchBookButtonOnAction(ActionEvent actionEvent) {
        String title = titleTextField.getText().trim();
        String author = authorTextField.getText().trim();
        String genre = genreCombobox.getValue();

        if (title.isEmpty() || author.isEmpty() || genre == null || genre.isEmpty()) {
            AlertGenerator.showAlert("Error", "Title, Author, and Genre cannot be empty.");
            return;
        }
    }
}