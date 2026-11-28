module com.example.library_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;
    requires java.logging;
    //requires com.example.library_management;
    //requires com.example.library_management;

    opens com.example.library_management to javafx.fxml;
    opens com.example.library_management.controller to javafx.fxml;
    opens com.example.library_management.controller.librarian to javafx.fxml;
    opens com.example.library_management.controller.bookSupplier to javafx.fxml;
    opens com.example.library_management.controller.LibraryMember to javafx.fxml;
    opens com.example.library_management.controller.RegistrationOfficer to javafx.fxml;
    opens user to javafx.base, javafx.fxml;
    opens nonuser to javafx.base, javafx.fxml;

    exports com.example.library_management;
    exports com.example.library_management.controller;
    exports com.example.library_management.controller.librarian;
    exports com.example.library_management.controller.bookSupplier;


    exports user;
    exports nonuser;
}