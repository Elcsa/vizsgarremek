package com.example.vizsgarremek;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Login extends Controller{

  @FXML
  private Button loginbutton;
  @FXML
  private Button backbuton;
  @FXML
  private PasswordField jelszofield;
  @FXML
  private TextField emailfield;

  @FXML
  public void loginbutonClick(ActionEvent actionEvent) {
    String email=emailfield.getText();
    String password= jelszofield.getText();
    Gson gson = new Gson();
    String data = "{\"email\" : %s, \"password\" : %s }";
    data = String.format(data, email, password);
    Response response;
    try {
      response = RequestHandler.post("http://localhost:3000/auth/login", data );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    if (response.getResponseCode() == 201){
      Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("sikeres bejelentkezes");
      alert.setHeaderText(null);
      alert.setContentText("" + response.getContent());
      alert.showAndWait();
    }else {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setTitle("hibas adatok");
      alert.setHeaderText(null);
      alert.setContentText("hibas email vagy jelszo");
      alert.showAndWait();
    }
  }

  public void loginbutonClick(javafx.event.ActionEvent actionEvent) {
    String email=emailfield.getText();
    String password= jelszofield.getText();
    Gson gson = new Gson();
    String data = "{\"email\" : \"%s\", \"password\" : \"%s\" }";
    data = String.format(data, email, password);
    Response response;
    try {
      response = RequestHandler.post("http://localhost:3000/auth/login", data );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(data);
    if (response.getResponseCode() == 201){
      Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("sikeres bejelentkezes");
      alert.setHeaderText(null);
      TokenResponse tokenResponse = gson.fromJson(response.getContent(), TokenResponse.class);
      String variableName = "TOKEN";
      String variableValue = tokenResponse.token +"";
      System.out.println(variableValue);
      System.setProperty(variableName, variableValue);
      App.TOKEN = tokenResponse.token;

      alert.showAndWait();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fooldal.fxml"));
      Scene scene = null;
      Stage stage = new Stage();
      try {
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Fooldal!");
        stage.setScene(scene);
        stage.show();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }else {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setTitle("hibas adatok");
      alert.setHeaderText(null);
      alert.setContentText("hibas email vagy jelszo");
      alert.showAndWait();
    }
  }
}
class TokenResponse {
  String token;

  public TokenResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}