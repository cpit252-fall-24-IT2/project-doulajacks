package org.example.vncpit252;

import java.io.IOException;

public class Test {

    public void runTests() {
        try {
            testLoadQuestions();
            testLoadAnswers();
        } catch (IOException e) {
            System.err.println("Error during testing: " + e.getMessage());
        }
    }

    private void testLoadQuestions() throws IOException {
        System.out.println("Running testLoadQuestions...");
        SharedData.setQuestionStrings();
        String[] questions = SharedData.getQuestionStrings();

        if (questions == null || questions.length == 0) {
            throw new AssertionError("Questions are not loaded correctly!");
        }
        System.out.println("Questions loaded successfully: " + questions.length);
    }

    private void testLoadAnswers() throws IOException {
        System.out.println("Running testLoadAnswers...");
        SharedData.setAnswerStrings("/answer.txt");
        String[] answers = SharedData.getAnswerStrings();

        if (answers == null || answers.length == 0) {
            throw new AssertionError("Answers are not loaded correctly!");
        }
        System.out.println("Answers loaded successfully: " + answers.length);
    }
}
