package org.example.vncpit252;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ResourcesController {

    @FXML
    private WebView webHolderID;

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
            // open link in default browser
            hl.setOnAction(mouseEvent -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(hl.getText()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            hl.setFont(Font.font("System", 15));
            readingsVboxID.getChildren().add(hl);
        }

        for (String link: resources.getCodes()) {
            Hyperlink hl = new Hyperlink(link);
            // open link in default browser
            hl.setOnAction(mouseEvent -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(hl.getText()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            hl.setFont(Font.font("System", 15));
            codeVboxID.getChildren().add(hl);
        }

        for (String link: resources.getVideoUrls()) {
            Hyperlink hl = new Hyperlink(link);
            // switching videos functionality
            hl.setOnAction(mouseEvent -> {switchVideo(hl);});
            hl.setFont(Font.font("System", 15));
            videosVboxID.getChildren().add(hl);
        }

        webHolderID.getEngine().load(resources.getVideoUrls().getFirst());
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
    }

    @FXML
    void returnBack(ActionEvent event) throws IOException {
        webHolderID.getEngine().load(null); // load null so it stops
        Controller controller = new Controller();
        controller.switchScene(event, "load_home_page.fxml");
    }

    @FXML
    void switchVideo(Hyperlink hl) {
        webHolderID.getEngine().load(hl.getText());
    }

}
