package CountdownLock.End;

import CountdownLock.Generic.MyVBox;

public class VictoryBox extends MyVBox {

    public VictoryBox() {
        super();
        this.getChildren().add(new VictoryLabel());
    }
}
