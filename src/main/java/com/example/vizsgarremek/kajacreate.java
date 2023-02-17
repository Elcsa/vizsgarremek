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
        String ar=arField.getText().trim();
        String id=idField.getId();
        if(nev.isEmpty()){
            warning("nev megadasa kotelezo");
            return;
        }
        if(id.isEmpty()){
            warning("id megadasa kotelezo");
            return;
        }
        etel newetel=new etel(0,nev,leiras,kategoria,ar,id,);
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



