package CountdownLock.Config;

import CountdownLock.Generic.MyCheckBox;

public class HelpConfigLine extends ConfigLine {

    private MyCheckBox helpBox;

    public HelpConfigLine() {
        ConfigLabel HelpLabel = new ConfigLabel("Activer l'aide (indique lorsqu'un mot est trouvé): ");

        this.helpBox = new MyCheckBox();

        this.getChildren().addAll(HelpLabel, helpBox);
    }

    public boolean isHelpSelected() {
        return this.helpBox.isSelected();
    }
}
