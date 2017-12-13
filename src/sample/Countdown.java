package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Countdown extends Parent {
    private MyIntegerProperties minutes, seconds;
    private Timeline secondsTimeline;

    public Countdown(int duration) {
        // Properties
        this.minutes = new MyIntegerProperties(duration - 1);
        this.seconds = new MyIntegerProperties(59);

        // Labels
        Label minutesLabel = new MyLabel();
        minutesLabel.textProperty().bind(minutes.getStringProperty());

        Label doublePoints = new MyLabel(":");

        Label secondsLabel = new MyLabel();
        secondsLabel.textProperty().bind(seconds.getStringProperty());

        // KeyFrame
        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(59),
                "Secondes",
                onFinished -> {
                    if (this.minutes.isZero()) {
                        System.out.println("Too late..");
                        System.exit(0);
                    } else {
                        this.minutes.decrease();
                        this.seconds.setValue(59);
                        this.secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(this.seconds, 0));

        // TimeLine
        this.secondsTimeline = new Timeline();
        this.secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        // Layout
        HBox layout = new HBox(20, minutesLabel, doublePoints, secondsLabel);
        this.getChildren().add(layout);

        // Background
        layout.setBackground(CountdownBackground.get());
        layout.setPadding(new Insets(75, 75, 75, 75));
    }

    public void start() {
        this.secondsTimeline.playFromStart();
    }
}
