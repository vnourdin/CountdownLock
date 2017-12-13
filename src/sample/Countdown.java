package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Countdown extends Parent {
    private IntegerProperty minutes, seconds;
    private Timeline secondsTimeline;

    public Countdown(int duration) {
        Label minutesLabel = new Label();
        Label doublePoints = new Label(":");
        Label secondsLabel = new Label();

        this.minutes = new SimpleIntegerProperty(duration - 1);
        this.seconds = new SimpleIntegerProperty(60);

        minutesLabel.textProperty().bind(minutes.asString());
        secondsLabel.textProperty().bind(seconds.asString());

        configLabel(minutesLabel);
        configLabel(secondsLabel);
        configLabel(doublePoints);

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

        this.secondsTimeline = new Timeline();
        this.secondsTimeline.getKeyFrames().add(secondsKeyFrame);

        Button button = new Button();
        button.setText("Démarrer");
        button.setOnAction(event -> {
            this.secondsTimeline.playFromStart();
            button.setVisible(false);
        });

        this.getChildren().addAll(minutesLabel, doublePoints, secondsLabel, button);
    }

    private void configLabel(Label toConfig) {
        toConfig.setTextFill(Color.DARKCYAN);
        toConfig.setStyle("-fx-font-size: 5em");
    }
}
