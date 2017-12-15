package CountdownLock.Config;

import CountdownLock.Generic.MyButton;

public class SubmitButton extends MyButton {
    public SubmitButton() {
        super("Valider");
        this.setDisable(true);
        this.setOnAction(clic -> ((ConfigPane) this.getParent()).startGame());
    }
}
