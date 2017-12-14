package CountdownLock;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MyLabel extends Label {

    public MyLabel(String text) {
        super(text);
        this.config();
    }

    public MyLabel(MyIntegerProperties property) {
        super();
        this.config();
        this.textProperty().bind(property.getStringProperty());
    }

    private void config() {
        this.setTextFill(Color.DARKRED);
        this.setStyle("-fx-font-size: 10em");
        this.setTextAlignment(TextAlignment.CENTER);
    }
}
