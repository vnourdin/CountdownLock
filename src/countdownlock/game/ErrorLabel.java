package countdownlock.game;

import countdownlock.generic.WindowController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ErrorLabel extends WindowController {
    @FXML
    private Label errorLabel;

    private Timeline errorTimeline;
    private int timer;

    @FXML
    private void initialize() {
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

    public void play() {
        this.errorTimeline.playFromStart();
    }

}
