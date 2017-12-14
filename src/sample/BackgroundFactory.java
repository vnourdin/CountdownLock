package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BackgroundFactory {
    public static Background getCountdown() {
        return new Background(new BackgroundFill(Color.GRAY, new CornerRadii(7), Insets.EMPTY));
    }

    public static Background getBasic(Color color) {
        return new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));
    }
}
