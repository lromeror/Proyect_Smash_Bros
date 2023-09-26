package ec.edu.espol.super_smash_bros;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

    @FXML
    private VBox content;
    private SecondaryController estadisticas;
    private ArrayList<Personaje> personajes;

    private void switchToSecondary() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("tablero.fxml"));
        Scene scene = new Scene(root);
        SecondaryController controlador = loader.getController(); 
        Stage stage = (Stage) content.getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("Styles/style1.css").toExternalForm());
        stage.setScene(scene);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int ind = 0;
        for (int i = 0; i < 24; i++){
            HBox row = new HBox();
            for (int j = 0; i < 3; i++){
                Personaje per = personajes.get(ind);
                ImageView imgV = new ImageView();
                //Aqui se setearia la imagen
                //agregar personaje acontinuacion
                Tarjeta boton = new Tarjeta();
                boton.getChildren().add(imgV);
                boton.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event t) -> {
                    Personaje p = boton.getPersonaje();
                    estadisticas.setPersonaje(p);
                    try {
                        switchToSecondary();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                row.getChildren().add(boton);
                ind++;
            }
            content.getChildren().add(row);
        }
    }
}
