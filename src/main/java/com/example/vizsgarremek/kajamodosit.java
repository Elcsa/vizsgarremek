package com.example.vizsgarremek;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class kajamodosit extends Controller{


    @FXML
    private TextField nevField;
    @FXML
    private TextField leirasField;
    @FXML
    private TextField kategoriaField;
    @FXML
    private TextField arField;
    @FXML
    private Button updateButton;
    private Etel etel;
    public void  setEtel(Etel etel){
        this.etel=etel;
        nevField.setText(this.etel.getFood_name());
        leirasField.setText(this.etel.getFood_description());
        kategoriaField.setText(this.etel.getFood_category());
        arField.setText(this.etel.getFood_price() +"");

    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    String nev=nevField.getText().trim();
    String leiras=leirasField.getText().trim();
    String kategoria=kategoriaField.getText().trim();
    String ar=arField.getText().trim();
    if(nev.isEmpty()){

    }

    }
}
