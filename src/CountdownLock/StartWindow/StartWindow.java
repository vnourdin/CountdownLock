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
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StartWindow extends WindowController {
    @FXML
    protected Button startButton, confirmButton;
    @FXML
    protected Label minutesLabel, secondsLabel, errorLabel;
    @FXML
    protected GridPane fieldsGrid;
    @FXML
    protected HBox countdown;
    private Timeline secondsTimeline, errorTimeline;
    private int timer;
    private MyIntegerProperties minutes, seconds;
    private Border normalBorder, stressBorder;
    private Insets normalInsets, stressInsets;
    private boolean doStress, isStressed;

    public void init(String[] words, int duration, boolean help, boolean doStress) {
        this.doStress = doStress;
        initCountdown(duration);
        fullfillFields(words, help);
        initErrorLabel();
    }

    private void initCountdown(int duration) {
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
                            stress();
                        minutes.decrease();
                        seconds.setValue(59);
                        secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(seconds, 0));

        secondsTimeline = new Timeline();
        secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        normalInsets = new Insets(75, 75, 75, 75);
        countdown.setPadding(normalInsets);
        initStress();
    }

    private void defeat() {
        root.getScene().setRoot(new DefeatBox());
    }

    private void stress() {
        if (!doStress || isStressed)
            return;

        Timeline stressTimeline = new Timeline();

        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
                onFinished -> {
                    invertBorder();
                    stressTimeline.playFromStart();
                }
        );
        stressTimeline.getKeyFrames().add(activationKeyFrame);
        stressTimeline.play();
        isStressed = true;
    }

    private void invertBorder() {
        if (countdown.getBorder() == normalBorder) {
            countdown.setPadding(stressInsets);
            countdown.setBorder(stressBorder);
        } else {
            countdown.setPadding(normalInsets);
            countdown.setBorder(normalBorder);
        }
    }

    private void initStress() {
        if (doStress) {
            isStressed = false;

            normalBorder = Border.EMPTY;
            stressBorder = new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(4, 4, 4, 4)));

            stressInsets = new Insets(71, 71, 71, 71);

            countdown.setBorder(normalBorder);
        }
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
    }

    @FXML
    protected void handleStartButton() {
        minutes.decrease();
        seconds.setValue(59);

        root.getChildren().remove(startButton);
        fieldsGrid.setVisible(true);
        confirmButton.setVisible(true);

        secondsTimeline.playFromStart();
    }

    @FXML
    protected void handleConfirmButton() {
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
        root.getScene().setRoot(new VictoryBox());
    }
}
