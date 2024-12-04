package org.example.vncpit252;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizController {

    private int currentIndex = 0;
    private int score = 0;
    private String[] questions;
    private String[] answers;

    @FXML
    private Label questionLabel, feedbackLabel, scoreLabel;

    @FXML
    private RadioButton trueOption, falseOption;

    @FXML
    private ToggleGroup answerToggleGroup;

    @FXML
    private Button nextButton, backButton;

    public void initialize() {
        questions = SharedData.getSublist(SharedData.getQuestionStrings());
        answers = SharedData.getSublist(SharedData.getAnswerStrings());
        if (questions.length > 0) showQuestion();
    }

    @FXML
    private void onNextButtonClick() {
        if (isAnswerNotSelected()) {
            feedbackLabel.setText("Please select 'True' or 'False'.");
            return;
        }
        Answer();
        if (hasMoreQuestions())
            showQuestion();

        else endQuiz();
    }

    private boolean isAnswerNotSelected() {
        return answerToggleGroup.getSelectedToggle() == null;
    }

    private void Answer() {
        String selectedAnswer = getSelectedAnswer();
        if (selectedAnswer.equalsIgnoreCase(answers[currentIndex].trim())) {
            feedbackLabel.setText("Correct!");
            score++;
        } else {
            feedbackLabel.setText("Incorrect! The correct answer is: " + answers[currentIndex].trim());
        }
        currentIndex++;
    }

    private String getSelectedAnswer() {
        return ((RadioButton) answerToggleGroup.getSelectedToggle()).getText().trim();
    }

    private boolean hasMoreQuestions() {
        return currentIndex < questions.length;
    }

    private void showQuestion() {
        questionLabel.setText(questions[currentIndex]);
        answerToggleGroup.selectToggle(null); // Clear previous selection
    }

    private void endQuiz() {
        feedbackLabel.setText("Quiz Completed! Final score: " + score + " / " + questions.length);
        nextButton.setDisable(true);
        showScore();
    }

    private void showScore() {
        scoreLabel.setText("Your score: " + score + " / " + questions.length);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        Controller controller = new Controller();
        Stage stage = (Stage) backButton.getScene().getWindow();
        controller.switchScene(event, "load_home_page.fxml");
    }
}
