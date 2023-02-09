package com.example.vizsgarremek;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
public class kajahozzaadas extends Controller{
    @FXML
    private TextField hamburger;
    @FXML
    private TextField sajburger;
    @FXML
    private TextField duplaburger;
    @FXML
    private Button submitButton;
    @FXML
    public void submitClick(ActionEvent actionEvent){
        String hamburger=hamburgerField.getText().trim();
        String sajburger=sajtburgerfield.getText().trim();
        String duplaburger=duplaburgerfield.getText().trim();

    }


}
