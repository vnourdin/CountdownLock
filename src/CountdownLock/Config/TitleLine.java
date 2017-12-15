package CountdownLock.Config;

import CountdownLock.Generic.BackgroundFactory;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class TitleLine extends HBox {

    public TitleLine(String titleString) {
        super();
        this.getStyleClass().add("hbox");
        this.setBackground(BackgroundFactory.get(Color.GRAY));
        this.setPadding(new Insets(20, 20, 20, 20));

        Label title = new Label(titleString);
        title.getStyleClass().add("title");
        this.getChildren().add(title);
    }
}
