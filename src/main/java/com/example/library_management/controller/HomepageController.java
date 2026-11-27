package com.example.library_management.controller;

import javafx.event.ActionEvent;
import user.Librarian;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class HomepageController
{
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void librarianButtonOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/librarian/LibrarianDashboardView.fxml",null );
    }

    @javafx.fxml.FXML
    public void bookSupplierButtonOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/bookSupplier/BookSupplierDashboardView.fxml",null );

    }

    @javafx.fxml.FXML
    public void registrationOfficerButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void libraryMemberButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/dashboardView.fxml",null);
    }
}