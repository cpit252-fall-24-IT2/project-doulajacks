package org.example.vncpit252;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class SharedData {
    private static String[] dialogStrings = null;
    private static String[] questionStrings = null;
    private static String[] answerStrings = null;
    private static String[] videoStrings = null;

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

    // Getters for testing
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

    private static String[] getArrStrings(String pathh) throws IOException {
        if (pathh == null || pathh.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        String[] arr;

        try (InputStreamReader fr = new InputStreamReader(
                SharedData.class.getResourceAsStream(pathh), StandardCharsets.UTF_8)) {

            if (fr == null) {
                throw new FileNotFoundException("Resource not found: " + pathh);
            }

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
}
