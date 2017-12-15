package CountdownLock.Config;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;

public class HelpConfigLine extends ConfigLine {

    private CheckBox helpBox;

    public HelpConfigLine() {
        ConfigLabel helpLabel = new ConfigLabel("Activer l'aide: ");
        helpLabel.setTooltip(new Tooltip("Indique lorsqu'un mot est trouvé"));
        this.helpBox = new CheckBox();

        this.getChildren().addAll(helpLabel, helpBox);
    }

    public boolean isHelpSelected() {
        return this.helpBox.isSelected();
    }
}
