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
import java.util.List;
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
    @FXML
    private void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("food_id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("food_name"));
        leirasCol.setCellValueFactory(new PropertyValueFactory<>("food_description"));
        kategoriaCol.setCellValueFactory(new PropertyValueFactory<>("food_category"));
        arCol.setCellValueFactory(new PropertyValueFactory<>("food_price"));
        //`food_id`, `food_name`, `food_description`, `food_category`, `food_price`c
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
        Response response=RequestHandler.get(App.BASE_URl);
        String content=response.getContent();
//        content = "{\"food_id\":1,\"food_name\":\"asd\",\"food_description\":\"asd\",\"food_category\":\"sad3\",\"food_price\":3000}";
        Gson converter=new Gson();
        System.out.println(content);
        MenuHelper kajaList = converter.fromJson(content, MenuHelper.class);
        System.out.println(kajaList.getEtelList());
        List<Etel> kaja = kajaList.getEtelList();
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
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("hozzaadas.fxml"));
            Scene scene;
            scene = new Scene(fxmlLoader.load(),640,480);
            kajamodosit controller=fxmlLoader.getController();
            controller.setEtel(selected);
            Stage stage=new Stage();
            stage.setTitle("updata "+selected.getFood_name());
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
    Optional<ButtonType>optionalButtonType=alert(Alert.AlertType.CONFIRMATION,"biztos?","biztos, hogz torlod az alabi rekordot:"+selected.getFood_name(),"");

    if(optionalButtonType.isPresent()&&optionalButtonType.get().equals(ButtonType.OK)){
    String url=App.BASE_URl+"/"+selected.getFood_id();
        System.out.println(url);
    try{
        RequestHandler.delete(url);
        loadKajaFromServer();
    }catch (IOException e){
        error("nem sikeerult kapcsolodni a szerverhez");
    }
    }}
}
