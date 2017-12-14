package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GlobalBox extends VBox {

    private Countdown countdown;
    private GridPane fieldsGrid;
    private MyFinishButton finishButton;
    private MyErrorLabel errorLabel;

    public GlobalBox(String[] words) {
        super(20);
        this.setAlignment(Pos.CENTER);

        this.countdown = new Countdown(20);

        MyStartCountdownButton startButton = new MyStartCountdownButton();

        this.fieldsGrid = new MyFieldsGrid();
        fullfillFields(words);

        this.finishButton = new MyFinishButton();

        this.errorLabel = new MyErrorLabel();

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

    public void startCountdown() {
        this.countdown.start();
    }

    public void showFields() {
        this.fieldsGrid.setVisible(true);
        this.finishButton.setVisible(true);
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

    private void victory() {
        this.getChildren().clear();
        this.getChildren().add(new MyVictoryLabel());
    }

    public void defeat() {
        this.getChildren().clear();
        this.getChildren().add(new MyDefeatLabel());
    }
}
