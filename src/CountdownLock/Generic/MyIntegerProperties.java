package CountdownLock.Generic;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MyIntegerProperties extends SimpleIntegerProperty {
    private SimpleStringProperty stringProperty;

    public MyIntegerProperties(int value) {
        super(value);
        this.stringProperty = new SimpleStringProperty(stringVersionOfValue());
    }

    public SimpleStringProperty getStringProperty() {
        return this.stringProperty;
    }

    private String stringVersionOfValue() {
        int value = this.get();
        return (value < 10) ? "0" + value : String.valueOf(value);
    }


    public boolean isZero() {
        return this.get() == 0;
    }

    public boolean isCritical() {
        return this.get() <= 5;
    }

    public void decrease() {
        this.setValue(this.get() - 1);
    }

    @Override
    public void set(int newValue) {
        super.set(newValue);
        this.actualizeString();
    }

    private void actualizeString() {
        this.stringProperty.set(stringVersionOfValue());
    }
}
