package countdownlock.end;

import javafx.scene.control.Label;

public class VictoryLabel extends Label {

    public VictoryLabel() {
        super("Bravo\nvous avez\ngagné!");
        this.getStyleClass().add("victory-label");
    }
}
