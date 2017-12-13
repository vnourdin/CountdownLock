package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GlobalBox extends VBox {

    private String[] words;
    private Countdown countdown;
    private GridPane fieldsGrid;
    private MyFinishButton finishButton;
    private Label errorLabel;

    public GlobalBox(String[] words) {
        super(20);
        this.words = words;
        this.setAlignment(Pos.CENTER);

        this.countdown = new Countdown(20);
        MyStartCountdownButton startButton = new MyStartCountdownButton(this);
        this.fieldsGrid = new GridPane();
        this.fieldsGrid.setAlignment(Pos.CENTER);

        for (int wordsIndice = 0, row = 0, column = 0; wordsIndice < this.words.length; wordsIndice++, column++) {
            if (wordsIndice % 2 == 0) {
                row++;
                column = 0;
            }
            this.fieldsGrid.add(new MyTextField(this.words[wordsIndice]), column, row);
        }
        this.fieldsGrid.setVisible(false);
        this.fieldsGrid.setAlignment(Pos.CENTER);
        this.finishButton = new MyFinishButton(this);

        this.errorLabel = new Label("Erreur, réesayez!");
        this.errorLabel.setTextFill(Color.RED);
        this.errorLabel.setStyle("-fx-font-size: 2em");
        this.errorLabel.setVisible(false);

        this.getChildren().addAll(this.countdown, startButton, this.fieldsGrid, finishButton, this.errorLabel);
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
            this.errorLabel.setVisible(true);
    }

    private void victory() {
        this.getChildren().clear();
        this.getChildren().add(new MyVictoryLabel());
    }
}
