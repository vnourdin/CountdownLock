package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class MyFieldsGrid extends GridPane {

    public MyFieldsGrid() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setVgap(20);
        this.setHgap(20);
        this.setPadding(new Insets(0, 0, 50, 0));
        this.setVisible(false);
        this.setAlignment(Pos.CENTER);
    }
}
