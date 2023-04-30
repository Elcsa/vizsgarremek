package com.example.vizsgarremek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static final String BASE_URl="http://localhost:3000/menu";
    public static  String TOKEN = "";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("kaja!");
        stage.setScene(scene);
        stage.setOnCloseRequest(windowEvent -> {
            if(App.TOKEN != "") {
                try {
                    Response response=RequestHandler.delete("http://localhost:3000/auth/logout");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}