package CountdownLock.Buttons;

import CountdownLock.Layouts.GameBox;

public class StartCountdownButton extends MyButton {
    public StartCountdownButton() {
        super("Démarrer");
        this.setOnAction(event -> {
            ((GameBox) this.getParent()).start();
            this.setVisible(false);
        });
    }
}
