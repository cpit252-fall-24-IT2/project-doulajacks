package org.example.vncpit252;

import java.util.ArrayList;

public class ResourcesHandler {
    ArrayList<String> readings = new ArrayList<>();
    ArrayList<String> codes = new ArrayList<>();
    ArrayList<String> videoUrls = new ArrayList<>();

    public ResourcesHandler() {
        SingletonResources();
    }

    public void SingletonResources() {
        readings.add("https://refactoring.guru/design-patterns/singleton");
        readings.add("https://www.patterns.dev/vanilla/singleton-pattern/");
        readings.add("https://www.geeksforgeeks.org/singleton-design-pattern/");
        codes.add("https://gitlab.com/cpit252/design-patterns/-/tree/main/01-singleton");
        codes.add("https://cpit252.gitlab.io/labs/lab-2/");
        videoUrls.add("https://youtu.be/M88sDrY66r8");
        videoUrls.add("https://www.youtube.com/watch?v=sJ-c3BA-Ypo");
    }

    public ArrayList<String> getReadings() {
        return readings;
    }

    public ArrayList<String> getCodes() {
        return codes;
    }

    public ArrayList<String> getVideoUrls() {
        return videoUrls;
    }
}
