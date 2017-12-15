package CountdownLock.Config;

import javafx.scene.control.CheckBox;

public class HelpConfigLine extends ConfigLine {

    private CheckBox helpBox;

    public HelpConfigLine() {
        ConfigLabel HelpLabel = new ConfigLabel("Activer l'aide (indique lorsqu'un mot est trouvé): ");

        this.helpBox = new CheckBox();

        this.getChildren().addAll(HelpLabel, helpBox);
    }

    public boolean isHelpSelected() {
        return this.helpBox.isSelected();
    }
}
