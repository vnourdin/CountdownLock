package CountdownLock.End;

import javafx.scene.layout.VBox;

public class VictoryBox extends VBox {

    public VictoryBox() {
        super();
        this.getStyleClass().add("vbox");
        this.getChildren().add(new VictoryLabel());
    }
}
