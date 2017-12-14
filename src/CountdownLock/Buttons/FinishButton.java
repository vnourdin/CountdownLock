package CountdownLock.Buttons;

import CountdownLock.Boxes.GameBox;

public class FinishButton extends MyButton {
    public FinishButton() {
        super("Valider");
        this.setOnAction(event -> {
            ((GameBox) this.getParent()).checkWords();
        });
        this.setVisible(false);
    }
}
