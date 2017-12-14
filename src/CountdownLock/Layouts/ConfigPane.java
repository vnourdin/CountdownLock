package CountdownLock.Layouts;

import CountdownLock.Labels.ConfigLabel;
import CountdownLock.TextFields.MyTextField;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ConfigPane extends MyVBox {

    public ConfigPane() {
        super();

        ConfigLine titleLine = new ConfigLine();
        ConfigLabel title = new ConfigLabel("Configuration");
        titleLine.getChildren().add(title);
        titleLine.setBorder(new Border(new BorderStroke(Color.MIDNIGHTBLUE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2, 2, 2, 2))));
        titleLine.setPadding(new Insets(30, 30, 30, 30));

        ConfigLine firstLine = new ConfigLine();
        ConfigLabel wordsLabel = new ConfigLabel("Mots à trouver:");
        MyTextField wordsInput = new MyTextField();

        firstLine.getChildren().addAll(wordsLabel, wordsInput);

        this.getChildren().addAll(titleLine, firstLine);
    }
}
