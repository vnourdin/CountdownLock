package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MyLabel extends Label {

    public MyLabel(String text) {
        super(text);
        this.config();
    }

    public MyLabel() {
        super();
        this.config();
    }

    private void config() {
        this.setTextFill(Color.DARKCYAN);
        this.setStyle("-fx-font-size: 5em");
    }
}
