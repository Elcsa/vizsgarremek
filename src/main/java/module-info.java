module com.example.vizsgarremek {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;


    opens com.example.vizsgarremek to javafx.fxml, com.google.gson;
    exports com.example.vizsgarremek;
}