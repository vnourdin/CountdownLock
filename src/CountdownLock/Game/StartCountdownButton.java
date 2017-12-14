package CountdownLock.Game;

import CountdownLock.Generic.MyButton;

public class StartCountdownButton extends MyButton {
    public StartCountdownButton() {
        super("Démarrer");
        this.setOnAction(event -> {
            ((GameBox) this.getParent()).start();
            this.setVisible(false);
        });
    }
}
