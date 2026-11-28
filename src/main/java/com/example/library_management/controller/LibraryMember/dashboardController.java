package com.example.library_management.controller.LibraryMember;

import javafx.event.ActionEvent;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class dashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void realTimeBookAvailabilityButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/realTimeBookAvailabilityView.fxml",null);
    }


    @javafx.fxml.FXML
    public void applyForLibraryMemberShipButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/applyForLibraryMembershipView.fxml",null);
    }


    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/com/example/library_management/HomePageView.fxml",null);
    }

    @javafx.fxml.FXML
    public void requestOnlineBookLoanRenewalButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/requestOnlineBookLoanRenewalView.fxml",null);
    }


    @javafx.fxml.FXML
    public void requestOfBorrowingBookButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/requestOfBorrowingBookView.fxml",null);
    }


    @javafx.fxml.FXML
    public void reserveBookButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/reserveBookView.fxml",null);
    }

    @javafx.fxml.FXML
    public void searchBookButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/searchBookView.fxml",null);
    }

    @javafx.fxml.FXML
    public void myAccountAndFineButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/myAccountAndFineView.fxml",null);
    }

    @javafx.fxml.FXML
    public void viewBorrowingHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/LibraryMember/viewBorrowingBookHistoryView.fxml",null);
    }
}