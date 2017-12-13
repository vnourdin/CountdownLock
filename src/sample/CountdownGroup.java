package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CountdownGroup extends VBox {

    private int[] words;

    public CountdownGroup(int[] words) {
        super(20);
        this.words = words;
        this.setAlignment(Pos.CENTER);

        Countdown countdown = new Countdown(3);
        MyButton button = new MyButton(countdown);

        this.getChildren().addAll(countdown, button);

        // TextField part
        //  for (word : this.words) // create a textField for this word // add it to children
    }
}
