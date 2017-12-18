package countdownlock.end;

import javafx.scene.layout.VBox;

public class DefeatBox extends VBox {

    public DefeatBox() {
        super();
        this.getStyleClass().add("vbox");
        this.getChildren().add(new DefeatLabel());
    }
}
