package org.example.vncpit252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SharedData {
    private static String[] dialogStrings = null;
    private static String[] questionStrings = null;
    private static String[] answerStrings = null;
    private static String[] videoStrings = null;
    private static String[] resourcesStrings = null;
    private static SaveInfo saveInfo = null;
    private static int pointer=0;
    private static int intalFlag=0;
    private static int lastFlag=0;

    //setters
    public static void setDialogStrings() throws IOException {
        dialogStrings = getArrStrings("/org/example/vncpit252/txt-fiels/dialog.txt");
    }

    public static void setQuestionStrings() throws IOException {
        questionStrings = getArrStrings("/org/example/vncpit252/txt-fiels/question.txt");
    }

    public static void setAnswerStrings() throws IOException {
        answerStrings = getArrStrings("/org/example/vncpit252/txt-fiels/answer.txt");
    }

    public static void setResourcesStrings() throws IOException {
        resourcesStrings = getArrStrings("/org/example/vncpit252/txt-fiels/learning_resources.txt");
    }

    public static void setVideoStrings() throws IOException {
        videoStrings = getArrStrings("/org/example/vncpit252/txt-fiels/video.txt");
    }

    public static void setPointer(int pointer) {
        SharedData.pointer = pointer;
    }

    public static void setIntalFlag(int intalFlag) {
        SharedData.intalFlag = intalFlag;
    }

    public static void setLastFlag(int lastFlag) {
        SharedData.lastFlag = lastFlag;
    } 


    public static void setSaveInfo(SaveInfo saveInfo) {
        SharedData.saveInfo = saveInfo;
    }

    // Getters 
    public static String[] getDialogStrings() {
        return dialogStrings;
    }

    public static String[] getQuestionStrings() {
        return questionStrings;
    }

    public static String[] getAnswerStrings() {
        return answerStrings;
    }

    public static String[] getResourcesStrings() { return  resourcesStrings; }

    public static String[] getVideoStrings() {
        return videoStrings;
    }

    public static int getPointer() {
        return pointer;
    }

    public static int getIntalFlag() {
        return intalFlag;
    }

    public static int getLastFlag() {
        
        return lastFlag;
    }

    // Method to get a sublist of questions and answers based on the current pointer and lastFlag
    public static String[] getSublist(String[] array) {
        return Arrays.copyOfRange(array, pointer, lastFlag);
    }


    // fetch data from txt methoud
    private static String[] getArrStrings(String pathh) throws IOException {
        if (pathh == null || pathh.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        String[] arr;

        try (InputStreamReader fr = new InputStreamReader(
                SharedData.class.getResourceAsStream(pathh), StandardCharsets.UTF_8)) {
            BufferedReader reader = new BufferedReader(fr);
            StringBuilder content = new StringBuilder();
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            arr = content.toString().split("\\|");  // Split content by '|'
        }

        return arr;
    }
    
    

    //read and write objec to presarve save
    public static void writedOBJ() throws Exception{
        try(var out = new ObjectOutputStream(new FileOutputStream("src/main/resources/org/example/vncpit252/Save.dat")) ){
            out.writeObject(saveInfo);
        }

    }
    public static void readOBJ() {
        try (var in = new ObjectInputStream(new FileInputStream("src/main/resources/org/example/vncpit252/Save.dat"))) {
            saveInfo = (SaveInfo) in.readObject();
            System.out.println("we have read the obj and the values are "+ saveInfo.toString());
        } catch (Exception e) {
            // Handle exception, like file not found or class not found
        }

    }

    public static SaveInfo getSaveInfo() {
        return saveInfo;
    }


}
