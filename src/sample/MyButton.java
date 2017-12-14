package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyButton extends Button {

    public MyButton(String text) {
        super(text);
        this.setTextFill(Color.DARKRED);
        this.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(4, 4, 4, 4))));
        this.setFont(new Font(25));

        this.setNormalBackground();
        this.setOnMouseEntered(mouseEntered -> this.setHoverBackground());
        this.setOnMouseExited(mouseExited -> this.setNormalBackground());
    }

    private void setNormalBackground() {
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void setHoverBackground() {
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
