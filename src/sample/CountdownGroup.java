package sample;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CountdownGroup extends VBox {

    private String[] words;

    public CountdownGroup(String[] words) {
        super(20);
        this.words = words;
        this.setAlignment(Pos.CENTER);

        Countdown countdown = new Countdown(3);
        StartCountdownButton button = new StartCountdownButton(countdown);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for (int i = 0, j = 0, k = 0; i < this.words.length; i++, k++) {
            if (i % 2 == 0) {
                j++;
                k = 0;
            }
            grid.add(new TextField(this.words[i]), k, j);
        }

        this.getChildren().addAll(countdown, button, grid);
    }
}
