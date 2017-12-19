package countdownlock.game;

import countdownlock.generic.URLLoader;
import countdownlock.generic.WindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class GameWindowController extends WindowController {
    @FXML
    private Button startButton, confirmButton;
    @FXML
    private Label errorLabel;
    @FXML
    private ErrorLabelController errorLabelController;
    @FXML
    private GridPane fieldsGrid;
    @FXML
    private FieldsGridController fieldsGridController;
    @FXML
    private HBox countdown;
    @FXML
    private CountdownController countdownController;

    public void initialize(String[] words, int duration, boolean help, boolean doStress) {
        countdownController.initialize(duration, doStress);
        fieldsGridController.initialize(words, help);
    }

    @FXML
    private void handleStartButton() {
        countdownController.start();

        root.getChildren().remove(startButton);
        fieldsGrid.setVisible(true);
        confirmButton.setVisible(true);

    }

    @FXML
    private void handleConfirmButton() {
        if (fieldsGridController.everyFieldIsWellFilled())
            victory();
        else
            errorLabelController.play();
    }

    private void victory() {
        try {
            root.getScene().setRoot(new FXMLLoader(URLLoader.getURL("end/VictoryWindow.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
