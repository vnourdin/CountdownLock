package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Compte à rebours");

        // FXMLLoader.load(getClass().getResource("sample.fxml"));
        CountdownGroup countdownGroup = new CountdownGroup(null);
        Scene scene = new Scene(countdownGroup, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
