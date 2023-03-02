package com.example.vizsgarremek;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class kajacreate extends Controller{
    @FXML
    private TextField nevField;
    @FXML
    private Button submitButton;
    @FXML
    private TextField leirasField;
    @FXML
    private TextField kategoriaField;
    @FXML
    private TextField arField;
    @FXML
    private TextField idField;


    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String nev=nevField.getText().trim();
        String leiras=leirasField.getText().trim();
        String kategoria=kategoriaField.getText().trim();
        int ar=Integer.parseInt(arField.getText().trim());
        int id= Integer.parseInt(idField.getId());
        if(nev.isEmpty()){
            warning("nev megadasa kotelezo");
            return;
        }
        if(leiras.isEmpty()){
           warning("id megadasa kotelezo");
            return;
        }
        Etel newetel=new Etel(id,nev,leiras,kategoria,ar);
        Gson converter=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json=converter.toJson(newetel);
        try{
            Response response=RequestHandler.post(App.BASE_URl,json);
            if(response.getResponseCode()==201){
                nevField.setText("");
                leirasField.setText("");
                kategoriaField.setText("");

            }else{
                error("hiba az adatok felvetele soran",response.getContent());
            }
        }catch (IOException e){
            error("nem sikerult kapcsolodni  a szerverhez");
        }
    }
}



