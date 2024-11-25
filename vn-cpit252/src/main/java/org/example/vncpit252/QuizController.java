package org.example.vncpit252;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class QuizController {

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton trueOption; // Radio button for "True"

    @FXML
    private RadioButton falseOption; // Radio button for "False"

    @FXML
    private ToggleGroup answerToggleGroup; // ToggleGroup for True/False options

    @FXML
    private Button nextButton;

    @FXML
    private Label feedbackLabel;

    private String[] questions; // Array to hold quiz questions
    private String[] answers;   // Array to hold correct answers
    private int currentIndex = 0; // Tracks the current question index

    public void initialize() {
        // Ensure ToggleGroup is set up
        if (answerToggleGroup == null) {
            answerToggleGroup = new ToggleGroup();
            trueOption.setToggleGroup(answerToggleGroup);
            falseOption.setToggleGroup(answerToggleGroup);
        }

        try {
            // Load questions and answers
            SharedData.setQuestionStrings("/question.txt");
            SharedData.setAnswerStrings("/answer.txt");
            questions = SharedData.getQuestionStrings();
            answers = SharedData.getAnswerStrings();

            if (questions.length > 0) {
                showQuestion(); // Display the first question
            }
        } catch (IOException e) {
            feedbackLabel.setText("Error loading questions or answers.");
        }
    }

    private void showQuestion() {
        questionLabel.setText(questions[currentIndex]); // Display the question
        answerToggleGroup.selectToggle(null); // Clear any previous selection
    }

    @FXML
    private void onNextButtonClick() {
        if (answerToggleGroup.getSelectedToggle() == null) {
            feedbackLabel.setText("Please select 'True' or 'False'.");
            return;
        }

        String selectedAnswer = ((RadioButton) answerToggleGroup.getSelectedToggle()).getText();
        if (selectedAnswer.equalsIgnoreCase(answers[currentIndex])) {
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect! The correct answer is: " + answers[currentIndex]);
        }

        currentIndex++;
        if (currentIndex < questions.length) {
            showQuestion();
        } else {
            feedbackLabel.setText("Quiz Completed!");
            nextButton.setDisable(true); // Disable the "Next" button after the last question
        }
    }
}
