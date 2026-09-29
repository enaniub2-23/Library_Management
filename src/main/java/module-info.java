module com.example.library_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.library_management to javafx.fxml;
    exports com.example.library_management;
}