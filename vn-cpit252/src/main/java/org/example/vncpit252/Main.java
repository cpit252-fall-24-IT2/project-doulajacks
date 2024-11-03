package org.example.vncpit252;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("CPIT252 VN");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {

        SaveInfo user1 =  new SaveInfo.SaveInfoBuilder("saeed","saeedappapp@gmail.com","Male").withIntrest("videoGames").withCountry("Saudi arabia").withAge(18).build();
        System.out.println(user1.toString());
        launch();
    }
}