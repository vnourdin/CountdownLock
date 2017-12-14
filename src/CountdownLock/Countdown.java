package CountdownLock;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Countdown extends Parent {
    private Timeline secondsTimeline;

    public Countdown(int duration) {
        super();

        // Properties
        MyIntegerProperties minutes = new MyIntegerProperties(duration - 1);
        MyIntegerProperties seconds = new MyIntegerProperties(59);

        // Labels
        Label minutesLabel = new MyLabel(minutes);
        Label doublePoints = new MyLabel(":");
        Label secondsLabel = new MyLabel(seconds);

        // KeyFrame
        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(59),
                "Secondes",
                onFinished -> {
                    if (minutes.isZero()) {
                        ((GameBox) this.getParent()).defeat();
                    } else {
                        minutes.decrease();
                        seconds.setValue(59);
                        this.secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(seconds, 0));

        // TimeLine
        this.secondsTimeline = new Timeline();
        this.secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        // Layout
        HBox layout = new HBox(20, minutesLabel, doublePoints, secondsLabel);
        this.getChildren().add(layout);

        // Background
        layout.setBackground(BackgroundFactory.getCountdown());
        layout.setPadding(new Insets(75, 75, 75, 75));
    }

    public void start() {
        this.setCursor(Cursor.WAIT);
        this.secondsTimeline.playFromStart();
    }
}
