package CountdownLock.Config;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class ConfigLabel extends Label {

    public ConfigLabel(String text) {
        super(text);
        this.setStyle("-fx-font-size: 2em");
        this.setTextFill(Color.MIDNIGHTBLUE);
        this.setTextAlignment(TextAlignment.RIGHT);
    }
}
