package org.example.vncpit252;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ResourcesController {

    @FXML
    private WebView webHolderID;

    @FXML
    private Label label1ID;

    @FXML
    private VBox videosVboxID;

    @FXML
    private VBox readingsVboxID;

    @FXML
    private VBox codeVboxID;

    @FXML
    public void initialize() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/main/resources/org/example/vncpit252/learning_resources.txt"));
        for(int i = 1; i <= 3; i++) {
            String[] str = sc.nextLine().split(" ");
            for(String s: str) {
                Hyperlink hl = new Hyperlink(s);
                switch(i) {
                    case 1:  videosVboxID.getChildren().add(hl); break;
                    case 2:  readingsVboxID.getChildren().add(hl); break;
                    case 3:  codeVboxID.getChildren().add(hl); break;
                }

            }
        }

        webHolderID.getEngine().load("https://www.youtube.com/embed?v=DPvN6kizkVI"); // embed not working
        webHolderID.setPrefSize(320, 195);
    }

}
