package countdownlock.game;

import countdownlock.generic.URLLoader;
import countdownlock.generic.WindowController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;

public class GameWindow extends WindowController {
    @FXML
    private Button startButton, confirmButton;
    @FXML
    private Label errorLabel;
    @FXML
    private GridPane fieldsGrid;
    @FXML
    private HBox countdown;
    @FXML
    private Countdown countdownController;
    private Timeline errorTimeline;
    private int timer;

    @FXML
    public void initialize() {
    }

    public void init(String[] words, int duration, boolean help, boolean doStress) {
        countdownController.init(duration, doStress);
        fullfillFields(words, help);
        initErrorLabel();
    }

    private void fullfillFields(String[] words, boolean help) {
        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            fieldsGrid.add(new GameField(words[wordsIndice], help), column, row);
        }
    }

    private void initErrorLabel() {
        timer = 6;
        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.3),
                onFinished -> {
                    if (timer == 0) {
                        timer = 6;
                        errorLabel.setVisible(false);
                    } else {
                        timer--;
                        errorLabel.setVisible(!errorLabel.isVisible());
                        errorTimeline.playFromStart();
                    }
                });

        errorTimeline = new Timeline();
        errorTimeline.getKeyFrames().add(activationKeyFrame);
    }

    @FXML
    private void handleStartButton() {
        countdownController.start();

        root.getChildren().remove(startButton);
        fieldsGrid.setVisible(true);
        confirmButton.setVisible(true);

    }

    @FXML
    private void handleConfirmButton() {
        boolean everyFieldsWellFilled = true;
        for (int i = 0; i < fieldsGrid.getChildren().size(); i++) {
            if (!((GameField) (fieldsGrid.getChildren().get(i))).isWellFilled())
                everyFieldsWellFilled = false;
        }
        if (everyFieldsWellFilled)
            victory();
        else
            errorTimeline.playFromStart();
    }

    private void victory() {
        try {
            root.getScene().setRoot(new FXMLLoader(URLLoader.getURL("end/VictoryWindow.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
