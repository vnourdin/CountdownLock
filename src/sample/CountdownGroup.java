package sample;

import javafx.scene.Group;

public class CountdownGroup extends Group {

    private int[] words;

    public CountdownGroup(int[] words) {
        this.words = words;
        this.init();
    }

    private void init() {
        // Background part
        this.getChildren().add(new CountdownBackground());

        // CountDown part
        this.getChildren().add(new Countdown(3));

        // TextField part
        //  for (word : this.words) // create a textField for this word // add it to children
    }
}
