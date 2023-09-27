package ec.edu.espol.super_smash_bros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.Screen;

/**
 * JavaFX App
 */
public class App extends Application {
    

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    stage.setFullScreen(true);
    Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
    scene = new Scene(root, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
    scene.getStylesheets().add(getClass().getResource("Styles/style1.css").toExternalForm());
    stage.setScene(scene);
    stage.show();

    
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
//        System.out.println(Screen.getPrimary().getVisualBounds().getHeight());
//        System.out.println(Screen.getPrimary().getVisualBounds().getWidth());
    }

}