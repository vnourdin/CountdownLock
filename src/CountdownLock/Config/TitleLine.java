package CountdownLock.Config;

import CountdownLock.Generic.BackgroundFactory;
import CountdownLock.Generic.MyHBox;
import CountdownLock.Generic.Title;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class TitleLine extends MyHBox {

    public TitleLine(String titleString) {
        super();
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(new Insets(20, 20, 20, 20));

        Title title = new Title(titleString);
        this.getChildren().add(title);
    }
}
