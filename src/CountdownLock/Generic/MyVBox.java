package CountdownLock.Generic;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public abstract class MyVBox extends VBox {

    protected MyVBox(int spacing) {
        super(spacing);
        this.setAlignment(Pos.CENTER);
    }

    protected MyVBox() {
        this(20);
    }
}
