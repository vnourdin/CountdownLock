package CountdownLock.Boxes;

import CountdownLock.Labels.DefeatLabel;

public class DefeatBox extends MyVBox {

    public DefeatBox() {
        super();
        this.getChildren().add(new DefeatLabel());
    }
}
