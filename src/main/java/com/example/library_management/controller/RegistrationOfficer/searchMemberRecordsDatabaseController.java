package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import user.LibraryMember;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class searchMemberRecordsDatabaseController {
    @javafx.fxml.FXML
    private TableColumn<LibraryMember, Long> nidTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<LibraryMember, String> phoneTableViewColumn;
    @javafx.fxml.FXML
    private TextField nIDTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<LibraryMember> tableView;
    @javafx.fxml.FXML
    private TableColumn<LibraryMember, String> nameTableViewColumn;
    @javafx.fxml.FXML
    private TableColumn<LibraryMember, Integer> memberIdTableViewColumn;

    @javafx.fxml.FXML
    public void initialize() {
        nidTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        phoneTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        nameTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        memberIdTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
    }

    @javafx.fxml.FXML
    public void backToDashBoardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/RegistrationOfficer/dashboardView.fxml", null);
    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText().trim();
        String nidText = nIDTextField.getText().trim();


        if (name.isEmpty() || nidText.isEmpty()) {
            AlertGenerator.showAlert("Error", "Name and NID cannot be empty.");
            return;
        }

        long nid;
        try {
            nid = Long.parseLong(nidText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "NID must be a valid number.");
            return;
        }

        if (nid <= 0) {
            AlertGenerator.showAlert("Error", "NID must be greater than 0.");
            return;
        }

        AlertGenerator.showAlert("Success", "Inputs validated! Searching member records...");
    }
}