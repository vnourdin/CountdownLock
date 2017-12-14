package CountdownLock.Generic;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MyLabel extends Label {

    public MyLabel(String text) {
        super(text);
        this.setTextFill(Color.DARKRED);
        this.setStyle("-fx-font-size: 10em");
        this.setTextAlignment(TextAlignment.CENTER);
    }

    public MyLabel(MyIntegerProperties property) {
        this("");
        this.textProperty().bind(property.getStringProperty());
    }
}
