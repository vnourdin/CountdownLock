package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyFinishButton extends Button {
    public MyFinishButton(GlobalBox globalBox) {
        super();
        this.setText("Valider");
        this.setTextFill(Color.DARKRED);
        this.setFont(new Font(25));
        this.setOnAction(event -> {
            globalBox.checkWords();
        });
        this.setVisible(false);
    }
}
