package CountdownLock.Config;

import CountdownLock.Generic.MyTextField;

public class WordsConfigLine extends ConfigLine {

    private MyTextField wordsInput;

    public WordsConfigLine() {
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");

        this.wordsInput = new MyTextField();
        this.wordsInput.setStyle("-fx-font-size: 2em");
        this.wordsInput.setMinWidth(500);

        this.getChildren().addAll(wordsLabel, this.wordsInput);
    }

    public String[] getWords() {
        return this.wordsInput.getText().split(" ");
    }
}
