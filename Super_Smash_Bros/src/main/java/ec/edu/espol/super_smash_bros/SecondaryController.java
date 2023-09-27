package ec.edu.espol.super_smash_bros;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class SecondaryController implements Initializable{
    
    private Personaje personaje;
    @FXML
    private ImageView viñeta;
    @FXML
    private ImageView tortuga;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView imagenLuchador;
    @FXML
    private Text nombre;
    @FXML
    private Button regresar;
<<<<<<< HEAD
=======
    private MediaPlayer mediaPlayer;
<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
>>>>>>> 15f4b7176ea774aab44e18bf0fdc0511804e7267

    DataSingleton data = DataSingleton.getInstance();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personaje = data.getPersonaje();
        Font customFont = Font.loadFont(getClass().getResource("/fonts/Big_Apple_3PM.ttf").toExternalForm(), 90);
//        personaje = new Personaje("Bayonetta","bayonetta.png");
        nombre.setText(personaje.getName());
//        nombre.setTextFill(Color.BLACK);
        try{
            nombre.setFont(customFont);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        nombre.setTextAlignment(TextAlignment.CENTER);
        nombre.setWrappingWidth(440);
        
//        
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
        
        String videoPath = "src/main/resources/videos_Smash_bros/"+personaje.getImagen().replace("png","mp4");
        File videoFile = new File(videoPath);
        String videoUrl = videoFile.toURI().toString();
        
        // Crear Media, MediaPlayer y MediaView
        Media media = new Media(videoUrl);
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        // Ajustar el tamaño del MediaView a 600px x 600px
        mediaView.setFitWidth(480);
        mediaView.setFitHeight(480);

        // Crear un clip circular para el MediaView
        Rectangle clip = new Rectangle(mediaView.getFitWidth(), mediaView.getFitHeight());
        clip.setArcWidth(90); // Ajusta según el radio de borde deseado
        clip.setArcHeight(90); // Ajusta según el radio de borde deseado
        mediaView.setClip(clip);

        // Añadir listeners para ajustar el clip si el tamaño del MediaView cambia
        mediaView.fitWidthProperty().addListener((observable, oldValue, newValue) -> {
            clip.setWidth(newValue.doubleValue());
        });
        mediaView.fitHeightProperty().addListener((observable, oldValue, newValue) -> {
            clip.setHeight(newValue.doubleValue());
        });

        // Posicionar el MediaView en la esquina superior izquierda con márgenes
        AnchorPane.setTopAnchor(mediaView, 30.0); // Margen superior de 40px
        AnchorPane.setLeftAnchor(mediaView, 20.0); // Margen izquierdo de 20px

        // Añadir el MediaView al AnchorPane
        anchorPane.getChildren().add(mediaView);

        // Iniciar la reproducción del video
        mediaPlayer.play();
//        imagenLuchador.setFitHeight(900);
        PersonajeHablando hilo1 = new PersonajeHablando(personaje);
        hilo1.start();
        
        
    }
    
    private void adjustSizesAndPositions() {
        double paneWidth = anchorPane.getWidth();
        double paneHeight = anchorPane.getHeight();

        tortuga.setFitWidth(paneWidth * 0.55);
        tortuga.setFitHeight(paneHeight * 0.55);
        AnchorPane.setBottomAnchor(tortuga, 0.0);
        AnchorPane.setLeftAnchor(tortuga, 25.0);

        viñeta.setFitWidth(paneWidth * 0.7);
        viñeta.setFitHeight(paneHeight);
        viñeta.getStyleClass().add("margin_botton");
        AnchorPane.setBottomAnchor(viñeta, 0.0);
        AnchorPane.setLeftAnchor(viñeta, paneWidth * 0.32);
        imagenLuchador.setFitWidth(400);
        imagenLuchador.setFitHeight(400);
        
        AnchorPane.setTopAnchor(imagenLuchador, 0.0);
        AnchorPane.setRightAnchor(imagenLuchador, 0.0);
        
        AnchorPane.setBottomAnchor(regresar, paneHeight * 0.01);
        AnchorPane.setRightAnchor(regresar, paneWidth * 0.01);
        
        AnchorPane.setTopAnchor(nombre, 80.0);
        AnchorPane.setRightAnchor(nombre, 400.0);
        
    }

    @FXML
    private void switchToPrimary(MouseEvent event) throws IOException {
<<<<<<< HEAD

=======
<<<<<<< Updated upstream
        
>>>>>>> 15f4b7176ea774aab44e18bf0fdc0511804e7267
        data.cerrarSesion();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        } 
<<<<<<< HEAD
        

=======

=======
        SessionManager.getInstance().cerrarSesion();
        // Detener la reproducción del video
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
>>>>>>> Stashed changes
>>>>>>> 15f4b7176ea774aab44e18bf0fdc0511804e7267
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("tablero.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setFullScreen(true);
        scene.getStylesheets().add(getClass().getResource("Styles/style1.css").toExternalForm());
        stage.setScene(scene);
    }

    public class PersonajeHablando extends Thread{
        private Personaje per;
        private String carpetaInicio = "images_png_1/";
        private String carpetaFin = "images_png_2/";

        public PersonajeHablando(Personaje p){
            per= p;
        }
        @Override
        public void run(){
            for (int i=0; i<31; i++){
                try{
                Platform.runLater(()->{
                imagenLuchador.setImage(new Image(carpetaInicio+per.getImagen()));
                // Depende de como este el nomnre de la imagen, si con extension o no
                });
                Thread.sleep(1000);
                Platform.runLater(()->{
                    imagenLuchador.setImage(new Image(carpetaFin+per.getImagen()));
                    // Depende de como este el nomnre de la imagen, si con extension o no
                });
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                
            }
            }
        }
    }
}