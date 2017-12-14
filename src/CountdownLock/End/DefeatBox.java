package CountdownLock.End;

import CountdownLock.Generic.MyVBox;

public class DefeatBox extends MyVBox {

    public DefeatBox() {
        super();
        this.getChildren().add(new DefeatLabel());
    }
}
