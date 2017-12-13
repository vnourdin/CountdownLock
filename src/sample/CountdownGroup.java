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
        StartCountdownButton button = new StartCountdownButton(this);
        this.fieldsGrid = new GridPane();
        this.fieldsGrid.setAlignment(Pos.CENTER);

        for (int i = 0, j = 0, k = 0; i < this.words.length; i++, k++) {
            if (i % 2 == 0) {
                j++;
                k = 0;
            }
            this.fieldsGrid.add(new MyTextField(this.words[i]), k, j);
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
