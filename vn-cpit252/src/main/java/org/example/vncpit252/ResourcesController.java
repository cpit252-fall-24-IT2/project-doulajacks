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

    private static ResourcesHandler resources;

    public static void setResources(String id) {
        resources = new ResourcesHandler();
    }

    @FXML
    public void initialize() throws FileNotFoundException {

        for (String link: resources.getReadings()) {
            Hyperlink hl = new Hyperlink(link);
            readingsVboxID.getChildren().add(hl);
        }

        for (String link: resources.getCodes()) {
            Hyperlink hl = new Hyperlink(link);
            codeVboxID.getChildren().add(hl);
        }

        for (String link: resources.getVideoUrls()) {
            Hyperlink hl = new Hyperlink(link);
            videosVboxID.getChildren().add(hl);
        }

        webHolderID.getEngine().load("https://www.youtube.com/embed?v=DPvN6kizkVI"); // embed not working
        webHolderID.setPrefSize(320, 195);
    }

}
