package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Countdown extends VBox {
    private IntegerProperty timeSeconds;
    private int STARTTIME = 20;
    private Timeline timeline;

    public Countdown() {
        Label timerLabel = new Label();
        this.timeSeconds = new SimpleIntegerProperty(STARTTIME);

        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 5em;");

//        Button button = new Button();
//        button.setText("Start Timer");
//        button.setOnAction(event -> {
//            if (timeline != null) {
//                timeline.stop();
//            }
//            timeSeconds.set(STARTTIME);
//            timeline = new Timeline();
//            timeline.getKeyFrames().add(
//                    new KeyFrame(Duration.seconds(STARTTIME + 1),
//                            new KeyValue(timeSeconds, 0)));
//            timeline.playFromStart();
//        });
        this.timeline = new Timeline();
        this.timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME + 1),
                        new KeyValue(this.timeSeconds, 0)));
        this.timeline.playFromStart();

        this.getChildren().addAll(timerLabel);
        this.setAlignment(Pos.CENTER);
    }
}
