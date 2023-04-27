package com.example.vizsgarremek;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class fooldal extends Controller{
    @FXML
    private Button menu;
    @FXML
    private Button rendeles;

    public void menuclick(javafx.event.ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("listkaja.fxml"));
        Scene scene = null;
        Stage stage = new Stage();
        try {
            scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("kaja!");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rendeles(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void menuclick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login"));
    }

    @FXML
    public void rendeles(ActionEvent actionEvent) {
    }
    // menu gomb  kezdolaprol atvisz alistahoz
    //rendeles meg abejelentkezeshez aztan kjaa valasztashoz

}

