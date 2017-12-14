package CountdownLock;

import javafx.scene.layout.GridPane;

public class GameBox extends MyVBox {

    private Countdown countdown;
    private GridPane fieldsGrid;
    private FinishButton finishButton;
    private ErrorLabel errorLabel;

    public GameBox(String[] words) {
        super();

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
        this.getScene().setRoot(new VictoryBox());
    }

    public void defeat() {
        this.getScene().setRoot(new DefeatBox());
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
