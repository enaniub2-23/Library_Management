module com.example.library_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.library_management to javafx.fxml;
    exports com.example.library_management;
}
/*module com.library.library_management {
    requires javafx.controls;
    requires javafx.fxml;

    // 1. Allows JavaFX to start your MainApplication class
    exports com.library.library_management;

    // 2. Allows FXML files to connect with @FXML variables & button methods in every controller package
    opens com.library.library_management to javafx.fxml;
    opens com.library.library_management.common to javafx.fxml;
    opens com.library.library_management.member1_patron to javafx.fxml;
    opens com.library.library_management.member2_desk to javafx.fxml;
    opens com.library.library_management.member3_operations to javafx.fxml;
    opens com.library.library_management.member4_finance to javafx.fxml;

    // 3. Allows TableView (PropertyValueFactory) to read getters from your Model classes
    opens com.library.library_management.model to javafx.base;

    // 4. Allows packages to share classes with each other
    exports com.library.library_management.model;
    exports com.library.library_management.util;
}
*/