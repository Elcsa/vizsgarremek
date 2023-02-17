package com.example.vizsgarremek;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
public class listetterem extends Controller{
    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView <etel>etelTabla;
    @FXML
    private TableColumn <etel,Integer>idCol;
    @FXML
    private TableColumn <etel,String> nameCol;
    @FXML
    private TableColumn <etel,String> leirasCol;
    @FXML
    private TableColumn<etel,String> kategoriaCol;
    @FXML
    private TableColumn <etel,Integer> arCol;
    private void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        leirasCol.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        kategoriaCol.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        arCol.setCellValueFactory(new PropertyValueFactory<>("ar"));
        Platform.runLater(()->{
            try {
                loadKajaFromServer();
            }catch (IOException e){
                error("hiba tortent az adtok lekerese soran",e.getMessage());
                Platform.exit();
            }
        });
    }
    private void loadKajaFromServer()throws IOException{
        Response response=RequestHandeler.get(App.BASE_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        etel[] kaja=converter.fromJson(content,etel[].class);
        etelTabla.getItems().clear();
        for (etel kaja:kaja)
    }



    @FXML
    public void insertClick(ActionEvent actionEvent) {
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteClicck(ActionEvent actionEvent) {
    }
}
