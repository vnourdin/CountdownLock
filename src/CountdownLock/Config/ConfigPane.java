package CountdownLock.Config;

import CountdownLock.Game.GameBox;
import CountdownLock.Generic.MyVBox;

public class ConfigPane extends MyVBox {

    public ConfigPane() {
        super(60);

        TitleLine titleLine = new TitleLine("Configuration");
        WordsConfigLine configWords = new WordsConfigLine();
        HelpConfigLine helpConfigLine = new HelpConfigLine();
        SubmitButton submitButton = new SubmitButton();
        submitButton.setOnAction(clic -> {
            this.getScene().setRoot(new GameBox(configWords.getWords(), 5, helpConfigLine.isHelpSelected()));
        });

        this.getChildren().addAll(titleLine, configWords, helpConfigLine, submitButton);
    }
}
