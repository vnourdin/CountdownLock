package CountdownLock;

import CountdownLock.Labels.MyLabel;
import CountdownLock.Layouts.GameBox;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Countdown extends HBox {
    private Timeline secondsTimeline;

    public Countdown(int duration) {
        super();
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        // Properties
        MyIntegerProperties minutes = new MyIntegerProperties(duration - 1);
        MyIntegerProperties seconds = new MyIntegerProperties(59);

        // Labels
        Label minutesLabel = new MyLabel(minutes);
        Label doublePoints = new MyLabel(":");
        Label secondsLabel = new MyLabel(seconds);
        this.getChildren().addAll(minutesLabel, doublePoints, secondsLabel);

        // KeyFrame
        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(59),
                "Secondes",
                onFinished -> {
                    if (minutes.isZero()) {
                        ((GameBox) this.getParent()).defeat();
                    } else {
                        if (minutes.isCritical())
                            this.stress();
                        minutes.decrease();
                        seconds.setValue(59);
                        this.secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(seconds, 0));

        // TimeLine
        this.secondsTimeline = new Timeline();
        this.secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        // Background
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(new Insets(75, 75, 75, 75));
    }

    public void start() {
        this.setCursor(Cursor.WAIT);
        this.secondsTimeline.playFromStart();
    }

    private void stress() {
        Timeline timeline = new Timeline();

        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
                onFinished -> {
                    this.invertBorder();
                    timeline.playFromStart();
                }
        );

        timeline.getKeyFrames().add(activationKeyFrame);
    }

    private void invertBorder() {
        // TODO
    }
}
