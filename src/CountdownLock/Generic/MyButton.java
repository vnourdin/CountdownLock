package CountdownLock.Generic;

import javafx.scene.control.Button;

public class MyButton extends Button {

    public MyButton(String text) {
        super(text);
        this.getStyleClass().add("my-button");
    }
}
