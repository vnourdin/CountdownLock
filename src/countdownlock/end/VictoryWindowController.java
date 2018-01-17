package countdownlock.end;

import countdownlock.generic.WindowController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VictoryWindowController extends WindowController {
    @FXML
    private Label victoryLabel;

    public void initialize(String code) {
        this.victoryLabel.setText("Bien joué!\n\nVous et vos coéquipiers\npouvez vous retourner.\n\nCode: " + code);
    }

}
