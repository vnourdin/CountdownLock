package countdownlock.config;

import countdownlock.game.GameWindowController;
import countdownlock.generic.URLLoader;
import countdownlock.generic.WindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;


public class ConfigWindowController extends WindowController {
    @FXML
    private TextField words;
    @FXML
    private Spinner<Integer> timer;
    @FXML
    private CheckBox help, stress;
    @FXML
    private Button submitButton;
    @FXML
    private Label submitLabel;

    @FXML
    private void handleSubmitButtonAction() throws IOException {
        URL location = URLLoader.getURL("game/GameWindow.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        Parent newRoot = loader.load();
        loader.<GameWindowController>getController()
                .initialize(words.getText().split(" "), timer.getValue(), help.isSelected(), stress.isSelected());

        root.getScene().setRoot(newRoot);
    }

    @FXML
    private void updateButtonState() {
        if (!words.getText().isEmpty()) {
            submitButton.setDisable(false);
            submitLabel.setVisible(false);
        } else {
            submitButton.setDisable(true);
            submitLabel.setVisible(true);
        }
    }
}
