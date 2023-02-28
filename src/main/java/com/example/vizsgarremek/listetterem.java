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
import java.util.Optional;
public class listetterem extends Controller{
    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView <Etel>etelTabla;
    @FXML
    private TableColumn <Etel,Integer>idCol;
    @FXML
    private TableColumn <Etel,String> nameCol;
    @FXML
    private TableColumn <Etel,String> leirasCol;
    @FXML
    private TableColumn<Etel,String> kategoriaCol;
    @FXML
    private TableColumn <Etel,Integer> arCol;
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
        Response response=RequestHandler.get(App.BASE_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        Etel[] kaja=converter.fromJson(content, Etel[].class);
        etelTabla.getItems().clear();
        for (Etel etel:kaja){
            etelTabla.getItems().add(etel);

        }
    }



    @FXML
    public void insertClick(ActionEvent actionEvent) {
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("createetel.fxml"));
           Scene scene = new Scene(fxmlLoader.load(), 640, 480);
           Stage stage = new Stage();
           stage.setTitle("Create kaja");
           stage.setScene(scene);
           stage.setOnCloseRequest(event -> {
               try {
                   loadKajaFromServer();
               } catch (IOException e) {
                   error("nem sikerult kapcslodnia szerverhez");
               }
           });
           stage.show();
       }catch (IOException e){
           error("hiba tortent az urlap betoltese  soran",e.getMessage());
       }
    }


    @FXML
    public void updateClick(ActionEvent actionEvent) {
        Etel selected=etelTabla.getSelectionModel().getSelectedItem();
        if(selected==null){
            warning("modositashoz elobb valszon ki egy elemet");
            return;

        }try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("hozzaadakaja.fxml"));
            Scene scene=new Scene(fxmlLoader.load(),640,480);
            hozzaadakaja controller=fxmlLoader.getController();
            controller.setEtel(selected);
            Stage stage=new Stage();
            stage.setTitle("updata "+selected.getNev());
            stage.setScene(scene);
            stage.setOnHidden(even->{
                try {
                    loadKajaFromServer();
                }catch (IOException e){
                    error("nem sikerult kapcsolodni a szerverhez");

                }
            });
            stage.show();
        }catch (IOException e){
            error("hiba aaz urlap betoltese soran", e.getMessage());
        }
    }

    @FXML
    public void deleteClicck(ActionEvent actionEvent) {
    Etel selected=etelTabla.getSelectionModel().getSelectedItem();
    if (selected==null){
        warning("torles elobb valszon ki egy elemet");
        return;
    }
    Optional<ButtonType>optionalButtonType=alert(Alert.AlertType.CONFIRMATION,"biztos?","biztos, hogz torlod az alabi rekordot:"+selected.getNev(),"");

    if(optionalButtonType.isPresent()&&optionalButtonType.get().equals(ButtonType.OK)){
    String url=BASE_URL+"/"+selected.getId();
    try{
        RequestHandler.delete(url);
        loadKajaFromServer();
    }catch (IOException e){
        error("nem sikeerult kapcsolodni a szerverhez");
    }
    }}
}
