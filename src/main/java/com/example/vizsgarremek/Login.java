package com.example.vizsgarremek;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login extends Controller{

  @FXML
  private Button loginbutton;
  @FXML
  private Button backbuton;
  @FXML
  private PasswordField jelszofield;
  @FXML
  private TextField emailfield;
  private  void loginbutonClick(){
    String email=emailfield.getText();
    String password= jelszofield.getText();
    if (email.equals("admin") && password.equals("asminn123")){
      Alert alert=new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("sikeres bejelentkezes");
      alert.setHeaderText(null);
      alert.setContentText("sikeres bejelentkezes");
      alert.showAndWait();
    }else {
      Alert alert=new Alert(Alert.AlertType.ERROR);
      alert.setTitle("hibas adatok");
      alert.setHeaderText(null);
      alert.setContentText("hibas email vagy jelszo");
      alert.showAndWait();
    }
  }
}
