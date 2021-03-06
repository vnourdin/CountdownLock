package countdownlock;

import countdownlock.generic.URLLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Compte à rebours");

        URL location = URLLoader.getURL("config/ConfigWindow.fxml");

        Scene scene = new Scene(FXMLLoader.load(location));
        scene.getStylesheets().add("countdownlock/MyStylesheet.css");

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }
}
