package countdownlock.game;

import countdownlock.end.VictoryWindowController;
import countdownlock.generic.URLLoader;
import countdownlock.generic.WindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;

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

    private String code;

    public void initialize(String[] words, String code, int duration, boolean help, boolean doStress) {
        this.code = code;
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
    private void handleConfirmButton() throws IOException {
        if (fieldsGridController.everyFieldIsWellFilled())
            victory();
        else
            errorLabelController.play();
    }

    private void victory() throws IOException {
        URL location = URLLoader.getURL("end/VictoryWindow.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        Parent newRoot = loader.load();
        loader.<VictoryWindowController>getController()
                .initialize(this.code);

        root.getScene().setRoot(newRoot);
    }
}
