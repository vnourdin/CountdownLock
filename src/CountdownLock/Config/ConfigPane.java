package CountdownLock.Config;

import CountdownLock.Generic.MyTextField;
import CountdownLock.Generic.MyVBox;

public class ConfigPane extends MyVBox {

    public ConfigPane() {
        super();

        TitleLine titleLine = new TitleLine("Configuration");

        ConfigLine firstLine = new ConfigLine();
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");
        MyTextField wordsInput = new MyTextField();

        firstLine.getChildren().addAll(wordsLabel, wordsInput);

        this.getChildren().addAll(titleLine, firstLine);
    }
}
