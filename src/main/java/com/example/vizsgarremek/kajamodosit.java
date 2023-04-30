package com.example.vizsgarremek;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


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
    @FXML
    private TextField kepField1;

    public void  setEtel(Etel etel){
        this.etel=etel;
        nevField.setText(this.etel.getFood_name());
        leirasField.setText(this.etel.getFood_description());
        kategoriaField.setText(this.etel.getFood_category());
        arField.setText(this.etel.getFood_price() + " ");
        kepField1.setText(this.etel.getFood_image());

    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    String nev=nevField.getText().trim();
    String leiras=leirasField.getText().trim();
    String kategoria=kategoriaField.getText().trim();
        int ar = Integer.parseInt(arField.getText().trim()) ;
        String kep = kepField1.getText().trim();
        Etel newetel=new Etel(0,nev,leiras,kategoria,ar, kep);
        Gson converter=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json=converter.toJson(newetel);
        try{
            Response response=RequestHandler.update(App.BASE_URl + "/"+ etel.getFood_id(),json);
            if(response.getResponseCode()==200){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("A modosítás sikeres volt");
                alert.setHeaderText(null);
                alert.setContentText("sikeres modositas");
                alert.showAndWait();
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            }else{
                error("hiba az adatok felvetele soran",response.getContent());
            }
        }catch (IOException e){
            error("nem sikerult kapcsolodni  a szerverhez");
        }
    }
}


