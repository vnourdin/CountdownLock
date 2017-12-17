package CountdownLock.ConfigWindow;

import CountdownLock.Game.GameBox;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;


public class ConfigWindow {
    @FXML
    private Parent root;
    @FXML
    private TextField words;
    @FXML
    private Spinner<Integer> timer;
    @FXML
    private CheckBox help;
    @FXML
    private Button submitButton;
    @FXML
    private Label submitLabel;

    @FXML
    protected void handleSubmitButtonAction() {
        root.getScene().setRoot(new GameBox(getWords(), getMinutes(), getHelp()));
    }

    private String[] getWords() {
        return words.getText().split(" ");
    }

    private int getMinutes() {
        return timer.getValue();
    }

    private boolean getHelp() {
        return help.isSelected();
    }

    @FXML
    protected void updateButtonState() {
        if (!words.getText().isEmpty()) {
            submitButton.setDisable(false);
            submitLabel.setVisible(false);
        } else {
            submitButton.setDisable(true);
            submitLabel.setVisible(true);
        }
    }
}
