package sample;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class MyTextField extends TextField {
    private String passphrase;

    public MyTextField(String passphrase) {
        super();
        this.passphrase = passphrase;
        this.setFont(new Font(40));
    }
}
