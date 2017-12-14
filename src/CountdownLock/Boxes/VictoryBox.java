package CountdownLock.Boxes;

import CountdownLock.Labels.VictoryLabel;

public class VictoryBox extends MyVBox {

    public VictoryBox() {
        super();
        this.getChildren().add(new VictoryLabel());
    }
}
