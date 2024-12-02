package org.example.vncpit252;

import java.io.File;
import java.util.*;

public class ResourcesHandler {

    private File dataFile = new File("src/main/resources/org/example/vncpit252/txt-fiels/learning_resources.txt");

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
        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNext()) {
                if (sc.hasNext(str)) {
                    sc.nextLine(); // store to label later
                    this.readings = Arrays.asList(sc.nextLine().split(" ")); // convert array to Arraylist
                    this.codes = Arrays.asList(sc.nextLine().split(" "));
                    this.videoUrls = Arrays.asList(sc.nextLine().split(" "));
                    break;
                }
                sc.nextLine();
            }
        }
        catch (Exception e) {
            System.out.println(e);
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
