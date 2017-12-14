package sample;

public class FinishButton extends MyButton {
    public FinishButton() {
        super("Valider");
        this.setOnAction(event -> {
            ((GlobalBox) this.getParent()).checkWords();
        });
        this.setVisible(false);
    }
}
