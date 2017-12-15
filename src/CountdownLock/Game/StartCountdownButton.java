package CountdownLock.Game;

import javafx.scene.control.Button;

public class StartCountdownButton extends Button {
    public StartCountdownButton() {
        super("Démarrer");
        this.setOnAction(event -> {
            ((GameBox) this.getParent()).start();
            this.setVisible(false);
        });
    }
}
