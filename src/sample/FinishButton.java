package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FinishButton extends Button {
    public FinishButton() {
        super();
        this.setText("Valider");
        this.setTextFill(Color.DARKRED);
        this.setFont(new Font(25));
        this.setOnAction(event -> {
            ((GlobalBox) this.getParent()).checkWords();
        });
        this.setVisible(false);
    }
}
