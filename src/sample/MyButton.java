package sample;

import javafx.scene.control.Button;

public class MyButton extends Button {
    public MyButton(Countdown countdown) {
        super();
        this.setText("Démarrer");
        this.setOnAction(event -> {
            countdown.start();
            this.setVisible(false);
        });
    }
}
