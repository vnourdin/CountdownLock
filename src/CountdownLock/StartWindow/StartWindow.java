package CountdownLock.StartWindow;

import CountdownLock.End.DefeatBox;
import CountdownLock.End.VictoryBox;
import CountdownLock.Game.GameField;
import CountdownLock.Generic.MyIntegerProperties;
import CountdownLock.Generic.WindowController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class StartWindow extends WindowController {
    @FXML
    protected Button startButton, confirmButton;
    @FXML
    protected Label minutesLabel, secondsLabel, errorLabel;
    @FXML
    protected GridPane fieldsGrid;
    private Timeline secondsTimeline, errorTimeline;
    private int timer;
    private MyIntegerProperties minutes, seconds;

    public void init(String[] words, int duration, boolean help) {
        minutes = new MyIntegerProperties(duration);
        minutesLabel.textProperty().bind(minutes.getStringProperty());

        seconds = new MyIntegerProperties(0);
        secondsLabel.textProperty().bind(seconds.getStringProperty());

        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(59),
                "Secondes",
                onFinished -> {
                    if (minutes.isZero()) {
                        defeat();
                    } else {
                        if (minutes.isCritical())
                            // TODO
                            minutes.decrease();
                        seconds.setValue(59);
                        secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(seconds, 0));

        secondsTimeline = new Timeline();
        secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        timer = 6;
        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
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

        fullfillFields(words, help);
    }

    private void fullfillFields(String[] words, boolean help) {
        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            this.fieldsGrid.add(new GameField(words[wordsIndice], help), column, row);
        }
    }

    @FXML
    protected void handleStartButtonAction() {
        minutes.decrease();
        seconds.setValue(59);

        startButton.setVisible(false);
        fieldsGrid.setVisible(true);
        confirmButton.setVisible(true);

        secondsTimeline.playFromStart();
    }

    @FXML
    protected void handleConfirmButtonAction() {
        boolean everyFieldsWellFilled = true;
        for (int i = 0; i < this.fieldsGrid.getChildren().size(); i++) {
            if (!((GameField) (this.fieldsGrid.getChildren().get(i))).isWellFilled())
                everyFieldsWellFilled = false;
        }
        if (everyFieldsWellFilled)
            victory();
        else
            errorTimeline.playFromStart();
    }

    private void victory() {
        root.getScene().setRoot(new VictoryBox());
    }

    private void defeat() {
        root.getScene().setRoot(new DefeatBox());
    }
}
