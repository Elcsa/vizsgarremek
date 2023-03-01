package com.example.vizsgarremek;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class hozzaadakaja extends Controller{


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
        nevField.setText(this.etel.getNev());
        leirasField.setText(this.etel.getLeiras());
        kategoriaField.setText(this.etel.getKategoria());
        arField.setText(this.etel.getAr() +"");

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
