package CountdownLock.Game;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ErrorLabel extends Label {

    private Timeline timeline;
    private int timer;

    public ErrorLabel() {
        super("Erreur, réesayez!");
        this.setTextFill(Color.RED);
        this.setStyle("-fx-font-size: 2em");
        this.setVisible(false);


    }

    public void activate() {
        this.timeline.play();
    }
}
