package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyStartCountdownButton extends Button {
    public MyStartCountdownButton(GlobalBox globalBox) {
        super();
        this.setText("Démarrer");
        this.setTextFill(Color.DARKRED);
        this.setFont(new Font(25));
        this.setOnAction(event -> {
            globalBox.startCountdown();
            globalBox.showFields();
            this.setVisible(false);
        });
    }
}
