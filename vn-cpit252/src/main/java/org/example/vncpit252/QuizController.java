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
    String[] questions = SharedData.getQuestionStrings();
    String[] answers = SharedData.getAnswerStrings();
    private int currentIndex = 0;
    private int quizScore = 0; // Tracks the current question index
    
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

    @FXML
    private Button backButton;
    
    

    public void initialize() {
        // Ensure ToggleGroup is set up
        if (answerToggleGroup == null) {
            answerToggleGroup = new ToggleGroup();
            trueOption.setToggleGroup(answerToggleGroup);
            falseOption.setToggleGroup(answerToggleGroup);
        }

        if (questions.length > 0) {
            showQuestion(); // Display the first question
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
    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        Controller controller = new Controller();
        Stage stage = (Stage) backButton.getScene().getWindow();
        controller.switchScene(event, "load_home_page.fxml");
    }
}
