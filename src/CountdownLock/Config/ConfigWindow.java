package CountdownLock.Config;

import CountdownLock.Game.GameBox;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class ConfigWindow {
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField words;
    @FXML
    private Spinner<Integer> timer;
    @FXML
    private CheckBox help;

    @FXML
    protected void handleSubmitButtonAction() {
        gridPane.getScene().setRoot(new GameBox(words.getText().split(" "), timer.getValue(), help.isSelected()));
    }
}
