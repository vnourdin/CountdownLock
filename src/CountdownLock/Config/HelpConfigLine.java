package CountdownLock.Config;

public class HelpConfigLine extends ConfigLine {

    public HelpConfigLine() {
        ConfigLabel HelpLabel = new ConfigLabel("Activer l'aide (indique lorsqu'un mot est trouvé): ");

        // TODO checkbuttons

        this.getChildren().addAll(HelpLabel);
    }
}
