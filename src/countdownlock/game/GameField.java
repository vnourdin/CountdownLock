package countdownlock.game;

import countdownlock.generic.BackgroundFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class GameField extends TextField {
    private final String passphrase;
    private final Background correctBack = BackgroundFactory.get(Color.LIGHTBLUE);
    private final Background incorrectBack = BackgroundFactory.get(Color.INDIANRED);

    public GameField(String passphrase, boolean help) {
        super();
        this.getStyleClass().add("config-field");
        this.passphrase = passphrase;
        if (help) {
            this.setBackground(this.incorrectBack);
            this.setOnKeyReleased(e -> this.actualizeBack());
        }
    }

    private void actualizeBack() {
        if (this.isWellFilled())
            this.setBackground(this.correctBack);
        else
            this.setBackground(this.incorrectBack);
    }

    public boolean isWellFilled() {
        return (this.getText().trim().equals(this.passphrase));
    }
}
