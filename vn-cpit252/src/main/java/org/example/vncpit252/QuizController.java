package org.example.vncpit252;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;

public class QuizController {

    private int currentIndex = 0;
    private int score = 0;
    private String[] questions;
    private String[] answers;

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton trueOption;

    @FXML
    private RadioButton falseOption;

    @FXML
    private ToggleGroup answerToggleGroup;

    @FXML
    private Button nextButton;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label scoreLabel;



    public void initialize() {
        questions = SharedData.getSublist(SharedData.getQuestionStrings());
        answers = SharedData.getSublist(SharedData.getAnswerStrings());

        if (questions.length > 0) {
            showQuestion();
        }
    }

    private void showQuestion() {
        questionLabel.setText(questions[currentIndex]);
        answerToggleGroup.selectToggle(null);  // Clear previous selection
    }

    @FXML
    private void onNextButtonClick() {
        if (answerToggleGroup.getSelectedToggle() == null) {
            feedbackLabel.setText("Please select 'True' or 'False'.");
            return;
        }

        String selectedAnswer = ((RadioButton) answerToggleGroup.getSelectedToggle()).getText().trim();


        if (selectedAnswer.equalsIgnoreCase(answers[currentIndex].trim())) {
            feedbackLabel.setText("Correct!");
            score++;
        } else {
            feedbackLabel.setText("Incorrect! The correct answer is: " + answers[currentIndex].trim());
        }

        currentIndex++;

        if (currentIndex < questions.length) {
            showQuestion();
        } else {

            if (selectedAnswer.equalsIgnoreCase(answers[currentIndex - 1].trim())) {
                feedbackLabel.setText("Correct! Quiz Completed!");
            } else {
                feedbackLabel.setText("Incorrect! The correct answer is: " + answers[currentIndex - 1].trim() + ". Quiz Completed!");
            }

            nextButton.setDisable(true);
            showScore();
        }
    }

    private void showScore() {
        scoreLabel.setText("Your score: " + score + " / " + questions.length);  // Show final score
    }


    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        // Go back to home page
        Controller controller = new Controller();
        Stage stage = (Stage) backButton.getScene().getWindow();
        controller.switchScene(event, "load_home_page.fxml");
    }
}
