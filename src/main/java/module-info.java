module com.example.vizsgarremek {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vizsgarremek to javafx.fxml;
    exports com.example.vizsgarremek;
}