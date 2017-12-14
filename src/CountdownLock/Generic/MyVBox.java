package CountdownLock.Generic;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public abstract class MyVBox extends VBox {

    protected MyVBox() {
        super(20);
        this.setAlignment(Pos.CENTER);
    }
}
