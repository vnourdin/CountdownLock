package CountdownLock.StartWindow;

import CountdownLock.Generic.MyIntegerProperties;
import CountdownLock.Generic.WindowController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class StartWindow extends WindowController {
    @FXML
    protected Label minutesLabel, secondsLabel;
    private Timeline secondsTimeline;
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
                        // TODO
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
    }

    @FXML
    protected void handleStartButtonAction() {
        minutes.decrease();
        seconds.setValue(59);
        secondsTimeline.playFromStart();
    }
}
