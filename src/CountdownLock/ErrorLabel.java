package CountdownLock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ErrorLabel extends Label {

    private Timeline timeline;
    private int timer;

    public ErrorLabel() {
        super("Erreur, réesayez!");
        this.setTextFill(Color.RED);
        this.setStyle("-fx-font-size: 2em");
        this.setVisible(false);

        this.timer = 6;
        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
                onFinished -> {
                    if (timer == 0) {
                        timer = 6;
                        this.setVisible(false);
                    } else {
                        timer--;
                        this.setVisible(!this.isVisible());
                        timeline.playFromStart();
                    }
                });

        this.timeline = new Timeline();
        this.timeline.getKeyFrames().add(activationKeyFrame);
    }

    public void activate() {
        this.timeline.play();
    }
}
