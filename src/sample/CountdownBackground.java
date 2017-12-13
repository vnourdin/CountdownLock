package sample;

import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CountdownBackground extends Rectangle {
    public CountdownBackground() {
        this.setWidth(400);
        this.setHeight(250);

        this.setArcWidth(30);
        this.setArcHeight(30);

        this.setFill(Color.GRAY);

        Reflection reflect = new Reflection();
        reflect.setFraction(0.25);
        reflect.setBottomOpacity(0);
        reflect.setTopOpacity(0.5);

        this.setEffect(reflect);

        this.setTranslateX(50);
        this.setTranslateY(50);
    }
}
