package countdownlock.game;

import countdownlock.generic.MyIntegerProperties;
import countdownlock.generic.URLLoader;
import countdownlock.generic.WindowController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class Countdown extends WindowController {
    @FXML
    private Label minutesLabel, secondsLabel;
    private MyIntegerProperties minutes, seconds;
    private Timeline secondsTimeline;
    private Border normalBorder, stressBorder;
    private Insets normalInsets, stressInsets;
    private boolean doStress, isStressed;

    public void init(int duration, boolean doStress) {
        this.doStress = doStress;
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
        root.setPadding(normalInsets);
        initStress();
    }

    public void start() {
        minutes.decrease();
        seconds.setValue(59);
        secondsTimeline.playFromStart();
    }

    private void defeat() {
        try {
            root.getScene().setRoot(new FXMLLoader(URLLoader.getURL("end/DefeatWindow.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (root.getBorder() == normalBorder) {
            root.setPadding(stressInsets);
            root.setBorder(stressBorder);
        } else {
            root.setPadding(normalInsets);
            root.setBorder(normalBorder);
        }
    }

    private void initStress() {
        if (doStress) {
            isStressed = false;

            normalBorder = Border.EMPTY;
            stressBorder = new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(4, 4, 4, 4)));

            stressInsets = new Insets(71, 71, 71, 71);

            root.setBorder(normalBorder);
        }
    }
}
