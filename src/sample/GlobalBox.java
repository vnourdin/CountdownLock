package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CountdownGroup extends VBox {

    private String[] words;
    private Countdown countdown;
    private GridPane fieldsGrid;

    public CountdownGroup(String[] words) {
        super(20);
        this.words = words;
        this.setAlignment(Pos.CENTER);

        this.countdown = new Countdown(20);
        MyStartCountdownButton button = new MyStartCountdownButton(this);
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
        this.getChildren().addAll(this.countdown, button, this.fieldsGrid);
    }

    public void startCountdown() {
        this.countdown.start();
    }

    public void showFields() {
        this.fieldsGrid.setVisible(true);
    }
}
