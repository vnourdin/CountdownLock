package CountdownLock.ConfigWindow;

import CountdownLock.Generic.URLLoader;
import CountdownLock.Generic.WindowController;
import CountdownLock.StartWindow.StartWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;


public class ConfigWindow extends WindowController {
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
    protected void handleSubmitButtonAction() throws IOException {
        URL location = URLLoader.getURL("StartWindow/StartWindow.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        Parent newRoot = loader.load();
        loader.<StartWindow>getController().setValues(getWords(), getMinutes(), getHelp());

        root.getScene().setRoot(newRoot);
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
