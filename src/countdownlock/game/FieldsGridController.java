package countdownlock.game;

import countdownlock.generic.WindowController;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class FieldsGridController extends WindowController {
    @FXML
    private GridPane fieldsGrid;

    public void initialize(String[] words, boolean help) {
        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            fieldsGrid.add(new GameField(words[wordsIndice], help), column, row);
        }
    }

    public boolean everyFieldIsWellFilled() {
        for (int i = 0; i < fieldsGrid.getChildren().size(); i++) {
            if (!((GameField) (fieldsGrid.getChildren().get(i))).isWellFilled())
                return false;
        }
        return true;
    }
}
