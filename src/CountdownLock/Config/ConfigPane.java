package CountdownLock.Config;

import CountdownLock.Generic.MyTextField;
import CountdownLock.Generic.MyVBox;
import CountdownLock.Generic.Title;

public class ConfigPane extends MyVBox {

    public ConfigPane() {
        super();

        TitleLine titleLine = new TitleLine();
        Title title = new Title("Configuration");
        titleLine.getChildren().add(title);

        ConfigLine firstLine = new ConfigLine();
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");
        MyTextField wordsInput = new MyTextField();

        firstLine.getChildren().addAll(wordsLabel, wordsInput);

        this.getChildren().addAll(titleLine, firstLine);
    }
}
