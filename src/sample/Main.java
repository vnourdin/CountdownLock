package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compte à rebours");

        CountdownGroup countdownGroup = new CountdownGroup(null);
        Scene scene = new Scene(countdownGroup, 700, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
