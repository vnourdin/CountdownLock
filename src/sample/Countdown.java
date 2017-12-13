package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Countdown extends Parent {
    private IntegerProperty minutes, seconds;
    private Timeline secondsTimeline;

    public Countdown(int duration) {
        // Properties
        this.minutes = new SimpleIntegerProperty(duration - 1);
        this.seconds = new SimpleIntegerProperty(60);

        // Labels
        Label minutesLabel = new MyLabel();
        minutesLabel.textProperty().bind(minutes.asString());

        Label doublePoints = new MyLabel(":");

        Label secondsLabel = new MyLabel();
        secondsLabel.textProperty().bind(seconds.asString());

        // KeyFrame
        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(60),
                "Secondes",
                onFinished -> {
                    if (this.minutes.isEqualTo(0).get()) {
                        System.out.println("Too late..");
                        System.exit(0);
                    } else {
                        this.minutes.setValue(this.minutes.get() - 1);
                        this.seconds.setValue(60);
                        this.secondsTimeline.playFromStart();
                    }
                },
                new KeyValue(this.seconds, 0));

        // TimeLine
        this.secondsTimeline = new Timeline();
        this.secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        // Button
        Button button = new Button();
        button.setText("Démarrer");
        button.setOnAction(event -> {
            this.secondsTimeline.playFromStart();
            button.setVisible(false);
        });

        // Add children
        this.getChildren().addAll(minutesLabel, doublePoints, secondsLabel, button);
    }
}
