package com.example.vizsgarremek;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class kajacreate extends Controller{
    @FXML
    private TextField idField;
    @FXML
    private TextField nevField;
    @FXML
    private Spinner<Integer> dbField;
    @FXML
    private Button submitButton;
    @FXML
    private void initialize(){
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,200,30);
        dbField.setValueFactory(valueFactory);
    }
    @FXML
    public void submitClick(ActionEvent actionEvent){
        int id= Integer.parseInt(idField.getId());
        String nev=nevField.getText().trim();
        int db=dbField.getValue();
        if (nev.isEmpty()){
            warning("termek nevenek megadasa kotelezo");
            return;
        }if (db.isEmpty)

    }


}
