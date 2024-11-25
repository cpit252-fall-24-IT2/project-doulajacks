package org.example.vncpit252;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String css = this.getClass().getResource("styleSheet.css").toExternalForm();
        Parent root =  FXMLLoader.load(getClass().getResource("home page.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        
        stage.setTitle("CPIT252 VN");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        



    }

    public static void main(String[] args) throws IOException {
        SharedData.setQuestionStrings();
        String  [] x = SharedData.getQuestionStrings();
        for(int i = 0 ; i < x.length;i++)
            System.out.println(x[i]);




        SaveInfo user1 =  new SaveInfo.SaveInfoBuilder("saeed","saeedappapp@gmail.com","Male")
                .withIntrest("videoGames")
                .withCountry("Saudi arabia")
                .withAge(21)
                .build();
        SaveInfo user2 = new SaveInfo.SaveInfoBuilder("Faris","faris.gmail.com","Male")
                .withIntrest("Football")
                .withCountry("Saudi Arabia")
                .withAge(22)
                .build();
        System.out.println(user1.toString());
        System.out.println(user2.toString()); 
        // FileReader fe = new FileReader()

        launch();
        System.out.println("after lunsh");
        System.out.println("after lunsh");
        System.out.println("after lunsh");
        System.out.println("after lunsh");
        System.out.println("after lunsh");
    }
    
    
}