package CountdownLock.Config;

import CountdownLock.Game.GameBox;
import CountdownLock.Generic.MyVBox;

public class ConfigPane extends MyVBox {

    private WordsConfigLine configWords;
    private TimerConfigLine timerConfig;
    private HelpConfigLine helpConfigLine;
    private SubmitButton submitButton;

    public ConfigPane() {
        super(60);

        TitleLine titleLine = new TitleLine("Configuration");
        this.configWords = new WordsConfigLine();
        this.timerConfig = new TimerConfigLine();
        this.helpConfigLine = new HelpConfigLine();
        this.submitButton = new SubmitButton();

        this.getChildren().addAll(titleLine, configWords, timerConfig, helpConfigLine, submitButton);
    }

    public void updateButton() {
        if (this.configWords.isFilled() && this.timerConfig.isFilled())
            this.submitButton.setDisable(false);
        else
            this.submitButton.setDisable(true);
    }

    public void startGame() {
        this.getScene().setRoot(new GameBox(this.configWords.getWords(), this.timerConfig.getTime(), this.helpConfigLine.isHelpSelected()));
    }
}
