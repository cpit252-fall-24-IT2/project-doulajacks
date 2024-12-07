package org.example.vncpit252;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import org.example.vncpit252.ResourcesFactory.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

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


    private static ResourceDesignPattern designPattern = ResourceDesignPattern.Singleton; // default

    public static void setDesignPattern(String id) {
        int idnum = Character.getNumericValue(id.charAt(id.length()-1));
        switch (idnum) {
            case 1: designPattern = ResourceDesignPattern.Singleton; break;
            case 2: designPattern = ResourceDesignPattern.Prototype; break;
            case 3: designPattern = ResourceDesignPattern.Adapter; break;
            case 4: designPattern = ResourceDesignPattern.Builder; break;
            case 5: designPattern = ResourceDesignPattern.Proxy; break;
            case 6: designPattern = ResourceDesignPattern.Flyweight; break;
            case 7: designPattern = ResourceDesignPattern.Decorator; break;
            case 8: designPattern = ResourceDesignPattern.Observer; break;
        }
    }

    @FXML
    public void initialize() {

        ResourceFactory factory = new ResourceFactory();

        ResourceType rs = factory.createResource("Reading", designPattern);
        defaultHyperLinks(rs.getListOfHyperLinks());
        setOnActionToOpenBrowser(rs.getListOfHyperLinks());
        readingsVboxID.getChildren().addAll(rs.getListOfHyperLinks());

        rs = factory.createResource("Code", designPattern);
        defaultHyperLinks(rs.getListOfHyperLinks());
        setOnActionToOpenBrowser(rs.getListOfHyperLinks());
        codeVboxID.getChildren().addAll(rs.getListOfHyperLinks());

        rs = factory.createResource("Video", designPattern);
        defaultHyperLinks(rs.getListOfHyperLinks());
        setOnActionToSwitchingVideo(rs.getListOfHyperLinks());
        videosVboxID.getChildren().addAll(rs.getListOfHyperLinks());


        String defaultVideo = rs.getListOfHyperLinks().getFirst().getText();
        defaultWebview(defaultVideo);

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

    private void defaultHyperLinks(List<Hyperlink> list) {
        for (Hyperlink hl : list) {
            hl.setFont(Font.font("System", 15));
        }
    }

    private void setOnActionToOpenBrowser(List<Hyperlink> list) {
        for (Hyperlink hl : list) {
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
        }
    }

    private void setOnActionToSwitchingVideo(List<Hyperlink> list) {
        // switching videos functionality
        for (Hyperlink hl : list) {
            hl.setOnAction(mouseEvent -> {
                webHolderID.getEngine().load(hl.getText());
            });
        }
    }

    private void defaultWebview(String defaultVideo) {
        webHolderID.getEngine().load(defaultVideo);
        webHolderID.setMaxSize(800, 480);
        webHolderID.setMinSize(480, 320);
        webHolderID.setPrefSize(480, 320);
    }

}
