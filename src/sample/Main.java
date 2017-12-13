package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compte à rebours");

        String[] words = {"Miam", "Test", "autre", "encore"};
        CountdownGroup countdownGroup = new CountdownGroup(words);
        Scene scene = new Scene(countdownGroup, 700, 800);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
