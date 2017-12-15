package CountdownLock.Generic;

import javafx.scene.control.Label;

public class MyLabel extends Label {

    public MyLabel(String text) {
        super(text);
        this.getStyleClass().add("my-label");
    }

    public MyLabel(MyIntegerProperties property) {
        this("");
        this.textProperty().bind(property.getStringProperty());
    }
}
