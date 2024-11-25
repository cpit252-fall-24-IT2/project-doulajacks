package org.example.vncpit252;

import java.io.IOException;

public class Test {

    public void runTests() {
        try {
            testLoadQuestions();
            testLoadAnswers();
            testMatchQuestionsAndAnswers();
            testPrintSampleQuestionAndAnswer();
        } catch (IOException e) {
            System.err.println("Error during testing: " + e.getMessage());
        }
    }

    private void testLoadQuestions() throws IOException {
        System.out.println("Running testLoadQuestions...");
        SharedData.setQuestionStrings("/question.txt");
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

    private void testMatchQuestionsAndAnswers() throws IOException {
        System.out.println("Running testMatchQuestionsAndAnswers...");
        SharedData.setQuestionStrings("/question.txt");
        SharedData.setAnswerStrings("/answer.txt");

        String[] questions = SharedData.getQuestionStrings();
        String[] answers = SharedData.getAnswerStrings();

        if (questions.length != answers.length) {
            throw new AssertionError("Mismatch: Number of questions and answers do not match!");
        }
        System.out.println("Questions and answers match in count: " + questions.length);
    }

    private void testPrintSampleQuestionAndAnswer() throws IOException {
        System.out.println("Running testPrintSampleQuestionAndAnswer...");
        SharedData.setQuestionStrings("/question.txt");
        SharedData.setAnswerStrings("/answer.txt");

        String[] questions = SharedData.getQuestionStrings();
        String[] answers = SharedData.getAnswerStrings();

        if (questions.length > 0 && answers.length > 0) {
            System.out.println("Sample Question: " + questions[0]);
            System.out.println("Sample Answer: " + answers[0]);
        } else {
            System.out.println("No questions or answers available to print.");
        }
    }
}
