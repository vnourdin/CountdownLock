package sample;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class CountdownGroup extends Group {

    private int[] words;

    public CountdownGroup(int[] words) {
        this.words = words;
        this.init();
    }

    private void init() {
        // Layout
        GridPane layout = new GridPane();
        this.getChildren().add(layout);
        layout.setGridLinesVisible(true);


        // CountDown
        Countdown countdown = new Countdown(3);
        layout.add(countdown, 1, 1);

        // Button
        layout.add(new MyButton(countdown), 1, 2);

        // TextField part
        //  for (word : this.words) // create a textField for this word // add it to children
    }
}
