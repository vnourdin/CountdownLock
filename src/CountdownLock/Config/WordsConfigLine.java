package CountdownLock.Config;

import javafx.scene.control.TextField;

public class WordsConfigLine extends ConfigLine {

    private TextField wordsInput;

    public WordsConfigLine() {
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");

        this.wordsInput = new TextField();
        this.wordsInput.setStyle("-fx-font-size: 2em; -fx-min-width: 500");
        this.wordsInput.setOnKeyReleased(type -> ((ConfigPane) this.getParent()).updateButton());

        this.getChildren().addAll(wordsLabel, this.wordsInput);
    }

    public boolean isFilled() {
        return !this.wordsInput.getText().isEmpty();
    }

    public String[] getWords() {
        return this.wordsInput.getText().split(" ");
    }
}
