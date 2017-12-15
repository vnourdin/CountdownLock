package CountdownLock.Config;

import javafx.scene.control.ComboBox;

public class TimerConfigLine extends ConfigLine {
    private ComboBox<Integer> timeChooser;

    public TimerConfigLine() {
        ConfigLabel timeLabel = new ConfigLabel("Durée du chronomètre: ");

        this.timeChooser = new ComboBox<>();
        this.timeChooser.getItems().addAll(5, 10, 15, 20, 25, 30);
        this.timeChooser.setOnAction(type -> ((ConfigPane) this.getParent()).updateButton());

        this.getChildren().addAll(timeLabel, this.timeChooser);
    }

    public boolean isFilled() {
        return !this.timeChooser.getSelectionModel().isEmpty();
    }

    public int getTime() {
        return (this.timeChooser.getSelectionModel().getSelectedItem());
    }
}
