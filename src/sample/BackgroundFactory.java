package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BackgroundFactory {
    public static Background get() {
        return new Background(new BackgroundFill(Color.GRAY, new CornerRadii(7), Insets.EMPTY));
    }
}
