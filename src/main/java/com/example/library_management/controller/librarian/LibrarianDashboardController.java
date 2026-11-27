package com.example.library_management.controller.librarian;

import javafx.event.ActionEvent;
import utility.SceneSwitchingHelper;

public class LibrarianDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generatesDailyCirculationSummaryReportOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/generateDailyCirculationSummaryReportView.fxml",null);
    }

    @javafx.fxml.FXML
    public void updateExistingBookInformationOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/updateExistingBookInformationCopyView.fxml",null);
    }

    @javafx.fxml.FXML
    public void addNewBookOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/addNewBookToCatalogDataBaseView.fxml",null);
    }

    @javafx.fxml.FXML
    public void processPriorityBookReservationRequestsOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/processPriorityBookReservationRequestsView.fxml",null);
    }

    @javafx.fxml.FXML
    public void processLoanRenewalForEligibleMemberOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/processLoanRenewalForEligibleMemberView.fxml",null);
    }

    @javafx.fxml.FXML
    public void removedDamagedOrLostBookCopyOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/removedDamagedOrLostBookCopyView.fxml",null);
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) {
        //SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/submitPriceQuotationAndDeliveryScheduleView.fxml",null);
    }

    @javafx.fxml.FXML
    public void processReturnedBookOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/processReturnBookView.fxml",null);
    }

    @javafx.fxml.FXML
    public void processPhysicalBookIssueOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/Librarian/processPhysicalBookIssueView.fxml",null);
    }

    @javafx.fxml.FXML
    public void backToHomePageOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/library_management/HomePageView.fxml", null);
    }
}