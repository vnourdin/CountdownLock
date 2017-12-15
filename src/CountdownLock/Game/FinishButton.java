package CountdownLock.Game;

import javafx.scene.control.Button;

public class FinishButton extends Button {
    public FinishButton() {
        super("Valider");
        this.setOnAction(event -> ((GameBox) this.getParent()).checkWords());
        this.setVisible(false);
    }
}
