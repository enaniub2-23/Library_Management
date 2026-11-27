package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import utility.SceneSwitchingHelper;

public class BookSupplierDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void dispatchShipmentAndProvideTrackingOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/dispatchShipmentAndProvideTrackingView.fxml",null);

    }

    @javafx.fxml.FXML
    public void submitPriceQuotationAndDeliveryScheduleOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/submitPriceQuotationAndDeliveryScheduleView.fxml",null);
    }

    @javafx.fxml.FXML
    public void updateVendorProfileAndCatalog(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/updateVendorProfileAndCatalogListView.fxml",null);
    }

    @javafx.fxml.FXML
    public void submitInvoiceAndDeliveryReceipt(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/submitSupplyInvoiceAndDeliveryReceiptView.fxml",null);

    }

    @javafx.fxml.FXML
    public void processReplacementForDamagedItems(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/processReplacementForDamagedItemsView.fxml",null);
    }

    @javafx.fxml.FXML
    public void trackInvoicePaymentStatus(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/trackInvoicePaymentStatusView.fxml",null);
    }

    @javafx.fxml.FXML
    public void receiveIncomingOrderOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/receiveIncomingPurchaseOrdersView.fxml",null);
    }

    @javafx.fxml.FXML
    public void confirmBookStockAllocationOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent,"/BookSupplier/confirmBookStockAllocationView.fxml",null);
    }

    @javafx.fxml.FXML
    public void backToHomePageOA(ActionEvent actionEvent) {
        SceneSwitchingHelper.switchSceneWithData(actionEvent, "/com/example/library_management/HomePageView.fxml", null);
    }
}