package CountdownLock.Config;

import CountdownLock.Generic.BackgroundFactory;
import CountdownLock.Generic.MyHBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class TitleLine extends MyHBox {

    public TitleLine(String titleString) {
        super();
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(new Insets(20, 20, 20, 20));

        Label title = new Label(titleString);
        title.getStyleClass().add("title");
        this.getChildren().add(title);
    }
}
