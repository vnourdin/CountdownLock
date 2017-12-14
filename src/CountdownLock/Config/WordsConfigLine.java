package CountdownLock.Config;

import CountdownLock.Generic.MyTextField;

public class WordsConfigLine extends ConfigLine {

    public WordsConfigLine() {
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");

        MyTextField wordsInput = new MyTextField();
        wordsInput.setStyle("-fx-font-size: 2em");
        wordsInput.setMinWidth(500);

        this.getChildren().addAll(wordsLabel, wordsInput);
    }
}
