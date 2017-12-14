package CountdownLock.Layouts;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public abstract class MyHBox extends HBox {

    protected MyHBox() {
        super(20);
        this.setAlignment(Pos.CENTER);
    }
}
