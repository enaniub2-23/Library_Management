package com.example.library_management.controller.RegistrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import utility.AlertGenerator;
import utility.SceneSwitchingHelper;

import java.io.IOException;
import java.time.LocalDate;

public class generateRegistrationSummaryReportController
{
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent)throws IOException {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/RegistrationOfficer/dashboardView.fxml",null);
    }

    @javafx.fxml.FXML
    public void generateRegistrationReportButtonOnAction(ActionEvent actionEvent) {

        LocalDate startDate = startDateDatePicker.getValue();
        LocalDate endDate = endDateDatePicker.getValue();


        if (startDate == null || endDate == null) {
            AlertGenerator.showAlert("Error", "Please select both Start Date and End Date.");
            return;
        }

        if (endDate.isBefore(startDate)) {
            AlertGenerator.showAlert("Error", "End Date cannot be before Start Date.");
            return;
        }

        AlertGenerator.showAlert("Success", "Registration summary report generated!");
    }
}

