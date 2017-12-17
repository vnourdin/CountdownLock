package CountdownLock.Game;

import CountdownLock.Generic.BackgroundFactory;
import CountdownLock.Generic.MyIntegerProperties;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Countdown extends HBox {
    private Timeline secondsTimeline;
    private Border normalBorder, stressBorder;
    private Insets normalInsets, stressInsets;
    private boolean isStressed;

    public Countdown(int duration) {
        super();
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        this.isStressed = false;

        this.normalBorder = Border.EMPTY;
        this.stressBorder = new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(4, 4, 4, 4)));

        this.normalInsets = new Insets(75, 75, 75, 75);
        this.stressInsets = new Insets(71, 71, 71, 71);

        // Properties
        MyIntegerProperties minutes = new MyIntegerProperties(duration - 1);
        MyIntegerProperties seconds = new MyIntegerProperties(59);

        // Labels
        Label minutesLabel = new Label();
        minutesLabel.textProperty().bind(minutes.getStringProperty());

        Label doublePoints = new Label(":");

        Label secondsLabel = new Label();
        secondsLabel.textProperty().bind(seconds.getStringProperty());

        // Background
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(this.normalInsets);
    }

    public void start() {
        this.setCursor(Cursor.WAIT);
        this.secondsTimeline.playFromStart();
    }

    private void stress() {
        if (this.isStressed)
            return;

        Timeline timeline = new Timeline();

        KeyFrame activationKeyFrame = new KeyFrame(Duration.seconds(0.2),
                onFinished -> {
                    this.invertBorder();
                    timeline.playFromStart();
                }
        );
        timeline.getKeyFrames().add(activationKeyFrame);
        timeline.play();
        this.isStressed = true;
    }

    private void invertBorder() {
        if (this.getBorder() == this.normalBorder) {
            this.setPadding(this.stressInsets);
            this.setBorder(this.stressBorder);
        } else {
            this.setPadding(this.normalInsets);
            this.setBorder(this.normalBorder);
        }
    }
}
