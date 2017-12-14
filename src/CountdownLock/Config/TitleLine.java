package CountdownLock.Config;

import CountdownLock.Generic.BackgroundFactory;
import CountdownLock.Generic.MyHBox;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class TitleLine extends MyHBox {

    public TitleLine() {
        super();
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(new Insets(20, 20, 20, 20));
    }
}
