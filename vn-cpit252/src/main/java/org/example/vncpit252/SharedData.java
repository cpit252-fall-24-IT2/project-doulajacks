package org.example.vncpit252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class SharedData {
    private static String[] dialogStrings = null;
    private static String[] questionStrings = null;
    private static String[] answerStrings = null;
    private static String[] videoStrings = null;
    private static SaveInfo saveInfo = null;
    private static int pointer=0;
    private static int intalFlag=0;
    private static int lastFlag=0;





   
   
   
   
    

    

    

    

    
    
    
   
    //setters
    public static void setDialogStrings() throws IOException {
        dialogStrings = getArrStrings("/org/example/vncpit252/dialog.txt");
    }
    public static void setQuestionStrings() throws IOException {
        questionStrings = getArrStrings("/org/example/vncpit252/question.txt");
    }
    public static void setAnswerStrings() throws IOException {
        answerStrings = getArrStrings("/org/example/vncpit252/answer.txt");
    }
    public static void setVideoStrings() throws IOException {
        videoStrings = getArrStrings("/org/example/vncpit252/video.txt");
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
    public static void readOBJ() throws Exception{
        try(var out = new ObjectOutputStream(new FileOutputStream("Save.dat")) ){
            out.writeObject(saveInfo);
        }

    }
    public static void writedOBJ(){
        try (var in = new ObjectInputStream( new FileInputStream("Save.dat"))) {
           saveInfo = (SaveInfo) in.readObject();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


}
