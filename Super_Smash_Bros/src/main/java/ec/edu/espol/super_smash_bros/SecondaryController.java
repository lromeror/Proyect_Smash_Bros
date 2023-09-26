package ec.edu.espol.super_smash_bros;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.util.Duration;

public class SecondaryController implements Initializable{
    
    private Personaje personaje;
    @FXML
    private ImageView viñeta;
    @FXML
    private ImageView tortuga;
    @FXML
    private AnchorPane anchorPane;
    
    public void setPersonaje(Personaje p){
        this.personaje = p;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        // Establece el tamaño del AnchorPane para que coincida con el tamaño de la pantalla
        anchorPane.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
        anchorPane.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());
        anchorPane.widthProperty().addListener((observableValue, oldWidth, newWidth) -> adjustSizesAndPositions());
        anchorPane.heightProperty().addListener((observableValue, oldHeight, newHeight) -> adjustSizesAndPositions());
        // Posicionar la tortuga en la esquina inferior izquierda
//        AnchorPane.setBottomAnchor(tortuga, 0.0);
//        AnchorPane.setLeftAnchor(tortuga, 0.0);
//
//        // Hacer que la viñeta llene el ancho restante del AnchorPane
//        AnchorPane.setBottomAnchor(viñeta, 0.0);
//        AnchorPane.setLeftAnchor(viñeta, tortuga.getImage().getWidth() * 1.05); // 5% más del ancho de la tortuga
    //        AnchorPane.setRightAnchor(viñeta, 0.0);
//        tortuga.getStyleClass().add("tamaño_tortuga");
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), tortuga); // Duración de la animación en segundos
        translateTransition.setFromX(-tortuga.getFitWidth()); // Posición inicial (fuera del área visible a la izquierda)
        translateTransition.setToX(tortuga.getParent().getLayoutBounds().getWidth()); // Posición final (fuera del área visible a la derecha)
//        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Repetir la animación indefinidamente
        translateTransition.setAutoReverse(false); // No invertir la animación al regresar

        // Inicia la animación
        translateTransition.play();
        String videoPath = "src/main/resources/Video_prueba/01_ Mario – Super Smash Bros. Ultimate.mp4"; // Reemplaza con la ruta a tu archivo de video
        File videoFile = new File(videoPath);
        String videoUrl = videoFile.toURI().toString();
        
        // Crear Media, MediaPlayer y MediaView
        
        Media media = new Media(videoUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
                
        // Posicionar el MediaView en la esquina superior izquierda
        AnchorPane.setTopAnchor(mediaView, 0.0);
        AnchorPane.setLeftAnchor(mediaView, 0.0);
        double paneWidth = anchorPane.getWidth();
        double paneHeight = anchorPane.getHeight();
        mediaView.setFitWidth(paneWidth * 0.3); // Ejemplo: 30% del ancho del AnchorPane
        mediaView.setFitHeight(paneHeight * 0.5); // Ejemplo: 50% del alto del AnchorPane

        // Añadir MediaView al AnchorPane
        anchorPane.getChildren().add(mediaView);

        // Iniciar la reproducción del video
        mediaPlayer.play();
    }
    
    private void adjustSizesAndPositions() {
        double paneWidth = anchorPane.getWidth();
        double paneHeight = anchorPane.getHeight();

        tortuga.setFitWidth(paneWidth * 0.5);
        tortuga.setFitHeight(paneHeight * 0.5);
        AnchorPane.setBottomAnchor(tortuga, 0.0);
        AnchorPane.setLeftAnchor(tortuga, 0.0);

        viñeta.setFitWidth(paneWidth * 0.7);
        viñeta.setFitHeight(paneHeight);
        viñeta.getStyleClass().add("margin_botton");
        AnchorPane.setBottomAnchor(viñeta, 0.0);
        AnchorPane.setLeftAnchor(viñeta, paneWidth * 0.3);
    }
}