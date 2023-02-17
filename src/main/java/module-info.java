module com.example.vizsgarremek {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.vizsgarremek to javafx.fxml;
    exports com.example.vizsgarremek;
}