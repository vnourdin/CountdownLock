package CountdownLock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Compte à rebours");

        // Scene scene = new Scene(new ConfigPane());
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ConfigWindow.fxml")));
        scene.getStylesheets().add("CountdownLock/MyStylesheet.css");

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }
}
