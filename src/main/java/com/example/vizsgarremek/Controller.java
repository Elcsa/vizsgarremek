package com.example.vizsgarremek;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public  abstract class Controller {
    protected void warning(String headerText){
        alert(Alert.AlertType.WARNING,"Figzelmeztetes",headerText, "");
    }
    protected void error(String headerText){
        error(headerText,"");
    }

    protected void error(String headerText,String contentText){
        alert(Alert.AlertType.ERROR,"hiba",headerText,contentText);
    }
    protected Optional<ButtonType>alert(Alert.AlertType alertType,String title,String headerText,String contentText){
        Alert alert=new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        return alert.showAndWait();
    }

}