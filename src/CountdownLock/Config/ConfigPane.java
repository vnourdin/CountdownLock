package CountdownLock.Config;

import CountdownLock.Generic.MyVBox;

public class ConfigPane extends MyVBox {

    public ConfigPane() {
        super();

        TitleLine titleLine = new TitleLine("Configuration");
        WordsConfigLine configWords = new WordsConfigLine();

        this.getChildren().addAll(titleLine, configWords);
    }
}
