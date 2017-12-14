package CountdownLock.End;

import CountdownLock.Generic.MyLabel;
import javafx.scene.paint.Color;

public class VictoryLabel extends MyLabel {
    public VictoryLabel() {
        super("Bravo\nvous avez\ngagné!");
        this.setTextFill(Color.FORESTGREEN);
    }
}
