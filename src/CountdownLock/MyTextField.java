package CountdownLock;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyTextField extends TextField {
    private String passphrase;
    private Background correctBack = BackgroundFactory.get(Color.LIGHTBLUE);
    private Background incorrectBack = BackgroundFactory.get(Color.INDIANRED);

    public MyTextField(String passphrase, boolean help) {
        super();
        this.passphrase = passphrase;
        this.setFont(new Font(40));
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
