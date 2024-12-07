package org.example.vncpit252.ResourcesFactory;

import javafx.scene.control.Hyperlink;
import org.example.vncpit252.SharedData;

import java.util.ArrayList;
import java.util.List;

public class Video implements ResourceType {

    List<Hyperlink> col = new ArrayList<>();

    public Video(String design) {
        setListOfHyperLinks(design);
    }

    @Override
    public void setListOfHyperLinks(String design) {
        String[] dataArray = SharedData.getResourcesStrings();
        dataArray = dataArray[0].split(System.lineSeparator());
        for(int i = 0; i < dataArray.length; i++) {
            if (dataArray[i].equals(design)) {
                String[] video = dataArray[i+3].split(" ");
                for (String link : video) {
                    Hyperlink hl = new Hyperlink(link);
                    col.add(hl);
                }
                break;
            }
        }
    }

    @Override
    public List<Hyperlink> getListOfHyperLinks() {
        return col;
    }

}
