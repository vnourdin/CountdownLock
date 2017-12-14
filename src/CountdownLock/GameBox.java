package CountdownLock;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameBox extends VBox {

    private Countdown countdown;
    private GridPane fieldsGrid;
    private FinishButton finishButton;
    private ErrorLabel errorLabel;

    public GameBox(String[] words) {
        super(20);
        this.setAlignment(Pos.CENTER);

        this.countdown = new Countdown(20);

        StartCountdownButton startButton = new StartCountdownButton();

        this.fieldsGrid = new FieldsGrid();
        fullfillFields(words);

        this.finishButton = new FinishButton();

        this.errorLabel = new ErrorLabel();

        this.getChildren().addAll(this.countdown, startButton, this.fieldsGrid, this.finishButton, this.errorLabel);
    }

    private void fullfillFields(String[] words) {
        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            this.fieldsGrid.add(new MyTextField(words[wordsIndice]), column, row);
        }
    }

    private void victory() {
        this.getChildren().clear();
        this.getChildren().add(new VictoryLabel());
    }

    public void defeat() {
        this.getChildren().clear();
        this.getChildren().add(new DefeatLabel());
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
            if (!((MyTextField) (this.fieldsGrid.getChildren().get(i))).isWellFilled())
                everyFieldsWellFilled = false;
        }
        if (everyFieldsWellFilled)
            victory();
        else
            this.errorLabel.activate();
    }
}
