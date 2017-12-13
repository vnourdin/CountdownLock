package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyButton extends Button {
    public MyButton(Countdown countdown) {
        super();
        this.setText("Démarrer");
        this.setTextFill(Color.DARKRED);
        this.setFont(new Font(25));
        this.setOnAction(event -> {
            countdown.start();
            this.setVisible(false);
        });
    }
}
