package org.example.vncpit252;

import java.io.File;
import java.util.*;

public class ResourcesHandler {

    List<String> readings = new ArrayList<>();
    List<String> codes = new ArrayList<>();
    List<String> videoUrls = new ArrayList<>();

    public ResourcesHandler(int idnum) {
        LoadResources(idnum);
    }

    public void LoadResources(int idnum) {
        if(idnum == 1) {
            String str = "Singleton";
            PopulateArray(str);
        }
        else if(idnum == 2) {
            String str = "Prototype";
            PopulateArray(str);
        }
        else if(idnum == 3) {
            String str = "Adapter";
            PopulateArray(str);
        }
        else if(idnum == 4) {
            String str = "Builder";
            PopulateArray(str);
        }
        else if(idnum == 5) {
            String str = "Proxy";
            PopulateArray(str);
        }
        else if(idnum == 6) {
            String str = "Flyweight";
            PopulateArray(str);
        }
        else if(idnum == 7) {
            String str = "Decorator";
            PopulateArray(str);
        }
        else if(idnum == 8) {
            String str = "Observer";
            PopulateArray(str);
        }
    }

    public void PopulateArray(String str) {
            String[] dataArray = SharedData.getResourcesStrings();
            dataArray = dataArray[0].split(System.lineSeparator());
            for(int i = 0; i < dataArray.length; i++) {
                if (dataArray[i].equals(str)) {
                    this.readings = Arrays.asList(dataArray[++i].split(" "));
                    this.codes = Arrays.asList(dataArray[++i].split(" "));
                    this.videoUrls = Arrays.asList(dataArray[++i].split(" "));
                    break;
                }
            }
    }

    public List<String> getReadings() {
        return readings;
    }

    public List<String> getCodes() {
        return codes;
    }

    public List<String> getVideoUrls() {
        return videoUrls;
    }
}
