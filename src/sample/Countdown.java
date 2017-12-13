package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Countdown extends VBox {
    private IntegerProperty minutes, seconds;
    private Timeline minutesTimeline;

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

//        Button button = new Button();
//        button.setText("Start Timer");
//        button.setOnAction(event -> {
//        });

        KeyFrame secondsKeyFrame = new KeyFrame(Duration.seconds(60),
                "Secondes",
                onFinished -> {
                    if (this.minutes.isEqualTo(0).get()) {
                        System.out.println("Too late..");
                        System.exit(0);
                    } else {
                        this.minutes.setValue(this.minutes.get() - 1);
                        this.seconds.setValue(60);
                        this.minutesTimeline.playFromStart();
                    }
                },
                new KeyValue(this.seconds, 0));

        this.minutesTimeline = new Timeline();
        this.minutesTimeline.getKeyFrames().add(secondsKeyFrame);
        this.minutesTimeline.playFromStart();

        this.getChildren().addAll(minutesLabel, doublePoints, secondsLabel);
        this.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));
        this.setAlignment(Pos.CENTER);
    }

    private void configLabel(Label toConfig) {
        toConfig.setTextFill(Color.DARKCYAN);
        toConfig.setStyle("-fx-font-size: 5em");
    }
}
