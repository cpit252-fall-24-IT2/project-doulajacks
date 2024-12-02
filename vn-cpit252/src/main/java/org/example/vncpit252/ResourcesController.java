package org.example.vncpit252;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ResourcesController {

    @FXML
    private AnchorPane paneID;

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
    private VBox zoomVboxID;


    private static ResourcesHandler resources;

    public static void setResources(String id) {
        int idnum = Character.getNumericValue(id.charAt(id.length()-1));
        System.out.println(idnum);
        resources = new ResourcesHandler(idnum);
    }

    @FXML
    public void initialize() {
        webHolderID.setContextMenuEnabled(true); // this line fixes a bug

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

        webHolderID.getEngine().load("https://www.youtube.com/embed/M88sDrY66r8");
        webHolderID.setMaxSize(800, 480);
        webHolderID.setMinSize(480, 320);

        webHolderID.setPrefSize(480, 320);
    }

    @FXML
    void zoomUp(MouseEvent event) {
        double height = webHolderID.getHeight();
        double width = webHolderID.getWidth();
        double aspectRatio = width-height;
        double currentLayoutX = webHolderID.getLayoutX();
        webHolderID.setPrefSize(width+aspectRatio, height+aspectRatio);

        if(webHolderID.getWidth() != 800) { // This magically works
            webHolderID.setLayoutX(currentLayoutX - aspectRatio / 2);
            zoomVboxID.setLayoutX(zoomVboxID.getLayoutX() + aspectRatio / 2);
            videosVboxID.setLayoutX(videosVboxID.getLayoutX() - aspectRatio / 2);
        }
        System.out.println(webHolderID.getWidth());
    }

    @FXML
    void zoomDown(MouseEvent event) {
        double height = webHolderID.getHeight();
        double width = webHolderID.getWidth();
        double aspectRatio = width-height;
        double currentLayoutX = webHolderID.getLayoutX();
        webHolderID.setPrefSize(width-aspectRatio, height-aspectRatio);

        if(webHolderID.getWidth() != 480) { // This magically works
            webHolderID.setLayoutX(currentLayoutX + aspectRatio / 2);
            zoomVboxID.setLayoutX(zoomVboxID.getLayoutX() - aspectRatio / 2);
            videosVboxID.setLayoutX(videosVboxID.getLayoutX() + aspectRatio / 2);
        }
        System.out.println(webHolderID.getWidth());
    }

    @FXML
    void returnBack(ActionEvent event) throws IOException {
        Controller controller = new Controller();
        controller.switchScene(event, "load_home_page.fxml");
    }

}
