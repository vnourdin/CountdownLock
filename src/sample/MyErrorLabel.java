package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MyErrorLabel extends Label {

    public MyErrorLabel() {
        super("Erreur, réesayez!");
        this.setTextFill(Color.RED);
        this.setStyle("-fx-font-size: 2em");
        this.setVisible(false);
    }

    public void blink() {

    }
}
