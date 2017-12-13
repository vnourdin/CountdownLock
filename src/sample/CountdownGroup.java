package sample;

import javafx.scene.Group;

public class CountdownGroup extends Group {

    private int[] words;

    public CountdownGroup(int[] words) {
        this.words = words;
        this.init();
    }

    private void init() {
        // Background
        this.getChildren().add(new CountdownBackground());

        // CountDown
        Countdown countdown = new Countdown(3);
        this.getChildren().add(countdown);

        // Button
        this.getChildren().add(new MyButton(countdown));

        // TextField part
        //  for (word : this.words) // create a textField for this word // add it to children
    }
}
