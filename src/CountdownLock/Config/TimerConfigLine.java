package CountdownLock.Config;

import javafx.scene.control.ComboBox;

public class TimerConfigLine extends ConfigLine {
    private ComboBox timeChooser;

    public TimerConfigLine() {
        ConfigLabel timeLabel = new ConfigLabel("Durée du chronomètre: ");

        this.timeChooser = new ComboBox<Integer>();
        timeChooser.getItems().addAll(5, 10, 15, 20, 25, 30);

        this.getChildren().addAll(timeLabel, timeChooser);
    }

    public int getTime() {
        return ((int) this.timeChooser.getSelectionModel().getSelectedItem());
    }
}
