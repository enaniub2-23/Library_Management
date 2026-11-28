package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class registerNewLibraryMemberController
{
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TextField nIDTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextArea addressTextArea;
    @javafx.fxml.FXML
    private TextField memberIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateAndConfirmRegistrationButtonOnAction(ActionEvent actionEvent) {String memberIdText = memberIdTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String phone = phoneTextField.getText().trim();
        String nid = nIDTextField.getText().trim();
        String address = addressTextArea.getText().trim();


        if (memberIdText.isEmpty() || name.isEmpty() || phone.isEmpty() || nid.isEmpty() || address.isEmpty()) {
            AlertGenerator.showAlert("Error", "All fields must be filled out.");
            return;
        }

        int memberId;
        try {
            memberId = Integer.parseInt(memberIdText);
        } catch (NumberFormatException e) {
            AlertGenerator.showAlert("Error", "Member ID must be a valid integer number.");
            return;
        }

        if (memberId <= 0) {
            AlertGenerator.showAlert("Error", "Member ID must be greater than 0.");
            return;
        }

        AlertGenerator.showAlert("Success", "New library member registration validated and confirmed!");

        memberIdTextField.clear();
        nameTextField.clear();
        phoneTextField.clear();
        nIDTextField.clear();
        addressTextArea.clear();
    }

    @javafx.fxml.FXML
    public void backToDashBoardButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/RegistrationOfficer/dashboardView.fxml", null);
    }
}