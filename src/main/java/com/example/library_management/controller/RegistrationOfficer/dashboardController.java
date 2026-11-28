package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import utility.SceneSwitchingHelper;

import java.io.IOException;

public class dashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void renewAnnualMembershipSubscriptionButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/renewAnnualMemberSubscriptionView.fxml",null);
    }


    @javafx.fxml.FXML
    public void registerNewLibraryMemberButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/registerNewLibraryMemberView.fxml",null);
    }

    @javafx.fxml.FXML
    public void generateRegistrationSummaryReportButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/generateRegistrationSummaryReportView.fxml",null);
    }

    @javafx.fxml.FXML
    public void verifyMemberDocumentButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/verifyMemberDocumentsView.fxml",null);
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/com/example/library_management/HomePageView.fxml",null);
    }

    @javafx.fxml.FXML
    public void updateMemberProfileInformationButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/updateMemberProfileInformationView.fxml",null);
    }

    @javafx.fxml.FXML
    public void deactivateMemberAccountButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/deactivateMemberAccountView.fxml",null);
    }

    @javafx.fxml.FXML
    public void issueDigitalMembershipCardButtonOnAction(ActionEvent actionEvent)throws IOException{
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/issueDigitalMembershipCardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void searchMemberRecordsDatabaseButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/searchMemberRecordsDatabaseView.fxml",null);
    }


}