package CountdownLock.Game;

import CountdownLock.End.DefeatBox;
import CountdownLock.End.VictoryBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameBox extends VBox {

    private Countdown countdown;
    private GridPane fieldsGrid;
    private FinishButton finishButton;
    private ErrorLabel errorLabel;

    public GameBox(String[] words, int minutes, boolean help) {
        super();
        this.getStyleClass().add("vbox");

        this.countdown = new Countdown(minutes);

        StartCountdownButton startButton = new StartCountdownButton();

        this.fieldsGrid = new FieldsGrid();
        fullfillFields(words, help);

        this.finishButton = new FinishButton();

        this.errorLabel = new ErrorLabel();

        this.getChildren().addAll(this.countdown, startButton, this.fieldsGrid, this.finishButton, this.errorLabel);
    }

    private void fullfillFields(String[] words, boolean help) {
        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            this.fieldsGrid.add(new GameField(words[wordsIndice], help), column, row);
        }
    }

    public void start() {
        this.showFields();
        this.startCountdown();
    }

    private void showFields() {
        this.fieldsGrid.setVisible(true);
        this.finishButton.setVisible(true);
    }

    private void startCountdown() {
        this.countdown.start();
    }

    public void checkWords() {
        boolean everyFieldsWellFilled = true;
        for (int i = 0; i < this.fieldsGrid.getChildren().size(); i++) {
            if (!((GameField) (this.fieldsGrid.getChildren().get(i))).isWellFilled())
                everyFieldsWellFilled = false;
        }
        if (everyFieldsWellFilled)
            victory();
        else
            this.errorLabel.activate();
    }

    private void victory() {
        this.getScene().setRoot(new VictoryBox());
        this.getChildren().clear();
    }

    public void defeat() {
        this.getScene().setRoot(new DefeatBox());
        this.getChildren().clear();
    }
}
