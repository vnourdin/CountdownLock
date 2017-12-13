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

        // TextField part
        //  for (word : this.words) // create a textField for this word // add it to children

        Countdown countdown = new Countdown();

        this.getChildren().addAll(countdown);
    }
}
