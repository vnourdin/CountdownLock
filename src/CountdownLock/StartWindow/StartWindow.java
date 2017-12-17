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
                            this.stress();
                        minutes.decrease();
                        seconds.setValue(59);
                        secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(seconds, 0));

        secondsTimeline = new Timeline();
        secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        this.normalInsets = new Insets(75, 75, 75, 75);
        countdown.setPadding(normalInsets);
        initStress();

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
        this.doStress = doStress;
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

    private void initStress() {
        if (doStress) {
            this.isStressed = false;

            this.normalBorder = Border.EMPTY;
            this.stressBorder = new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(4, 4, 4, 4)));

            this.stressInsets = new Insets(71, 71, 71, 71);

            countdown.setBorder(normalBorder);
        }
    }

    @FXML
    protected void handleStartButtonAction() {
        minutes.decrease();
        seconds.setValue(59);

        root.getChildren().remove(startButton);
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

    private void stress() {
        if (!doStress || this.isStressed)
            return;

        Timeline stressTimeline = new Timeline();

        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
                onFinished -> {
                    this.invertBorder();
                    stressTimeline.playFromStart();
                }
        );
        stressTimeline.getKeyFrames().add(activationKeyFrame);
        stressTimeline.play();
        this.isStressed = true;
    }

    private void invertBorder() {
        if (countdown.getBorder() == this.normalBorder) {
            countdown.setPadding(this.stressInsets);
            countdown.setBorder(this.stressBorder);
        } else {
            countdown.setPadding(this.normalInsets);
            countdown.setBorder(this.normalBorder);
        }
    }
}
