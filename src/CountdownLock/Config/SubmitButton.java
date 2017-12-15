package CountdownLock.Config;

import javafx.scene.control.Button;

public class SubmitButton extends Button {
    public SubmitButton() {
        super("Valider");
        this.setDisable(true);
        this.setOnAction(clic -> ((ConfigPane) this.getParent()).startGame());
    }
}
