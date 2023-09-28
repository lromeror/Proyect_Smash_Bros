package ec.edu.espol.super_smash_bros;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
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
import javafx.scene.layout.Background;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

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

    private MediaPlayer mediaPlayer;
    
    DataSingleton data = DataSingleton.getInstance();
    @FXML
    private HBox cuadroTime;
    private ImageView imagen1;
    private ImageView imagen2;
    @FXML
    private VBox cuadroPreguntas;
    @FXML
    private Text label_reloj;
//    private PoderesCambiando poderes;
    @FXML
    private Button opcion1;
    @FXML
    private Button opcion3;
    @FXML
    private Button opcion2;
    @FXML
    private Button opcion4;
    @FXML
    private Text labelpregunta;
    @FXML
    private Label msg;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        personaje = data.getPersonaje();
        rellenarPreguntas(personaje);
        AnchorPane.setBottomAnchor(cuadroPreguntas, 30.0);
        AnchorPane.setRightAnchor(cuadroPreguntas, 120.0);
        AnchorPane.setTopAnchor(cuadroTime, 240.0);
        AnchorPane.setRightAnchor(cuadroTime, 500.0);
        opcion1.getStyleClass().add("rounded");
        opcion2.getStyleClass().add("rounded");
        opcion3.getStyleClass().add("rounded");
        opcion4.getStyleClass().add("rounded");
        labelpregunta.setWrappingWidth(550);
        
//      labelpregunta.setWrappingWidth(440);
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
//        anchorPane.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
//        anchorPane.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());
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
//        VBox datos = new VBox();
//        VBox movimientos = movimientos();
//        Text descrip = new Text(personaje.getDescripcion());
//        datos.getChildren().addAll(movimientos,descrip);
//        imagenLuchador.setFitHeight(900);
        PersonajeHablando hilo1 = new PersonajeHablando(personaje);
//        poderes = new PoderesCambiando(personaje);
        Reloj reloj = new Reloj();
        reloj.start();
        hilo1.start();
        
        
//        poderes.start();
        
        
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
        
        AnchorPane.setTopAnchor(nombre, 70.0);
        AnchorPane.setRightAnchor(nombre, 350.0);
        
    }

    @FXML
    private void switchToPrimary(MouseEvent event) throws IOException {
        
        data.cerrarSesion();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        } 
//        poderes.interrupt();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("tablero.fxml"));
        Scene scene = new Scene(root,Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
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
            per = p;
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
    
    
    
//    public class PoderesCambiando extends Thread{
//        
//        private String[] paths = new String[4];
//        public PoderesCambiando(Personaje p){ 
//            Move[] m = p.getMoves();
//            for(int i = 0; i<4; i++){
//                try{
//                    this.paths[i] = m[i].getImagen();
//                }
//                //zzzz
//                catch(Exception e){
//                    this.paths[i] = "";
//                }
//            }
//        }
//
//        public void run(){
//            // Imaginando que existe imv_r1 y imv_r2
//        while (true){
//            try{
//                Platform.runLater(() -> {
//                    imagen1.setImage(new Image(this.paths[0]));
//                    imagen2.setImage(new Image(this.paths[1]));
//                });
//                
//                Thread.sleep(5000);
//                Platform.runLater(() -> {
//                    imagen1.setImage(new Image(this.paths[2]));
//                    imagen2.setImage(new Image(this.paths[3]));
//                });
//                
//                Thread.sleep(5000);
//            }
//            catch(InterruptedException e){
//                
//            }
//            }
//        }
//    }
    public class Reloj extends Thread {
        
        public Reloj() {
           
        }
        
        public void run(){
 
            for (int i=30; i>0;i--){
                final int j = i;
                try{
                    if(i<10){
                        Platform.runLater(()->{
                            label_reloj.setText("0"+j);
                            label_reloj.setFill(Color.RED);
                        });
                    }
                    else{
                        Platform.runLater(()->{
                            label_reloj.setText(""+j);
                        });
                    }
                    Thread.sleep(1000);
                }
                catch(InterruptedException ie){

                }  
            
            } 
            Platform.runLater(()->{
                label_reloj.setText("00");
                label_reloj.setFill(Color.RED);
                msg.setText("Perdiste");
                msg.setTextFill(Color.RED);
            });
            
        }
    }

    public void shuffle(String[] respuestas){
        List<String> pList = Arrays.asList(respuestas);
        Collections.shuffle(pList);
        pList.toArray(respuestas);
    }

    public void rellenarPreguntas(Personaje p){
        String pregunta = p.getPreguntaRespuestas().keySet().stream().findFirst().get();
        String[] respuestas = p.getPreguntaRespuestas().get(pregunta);
        labelpregunta.setText(pregunta);
        String respuestaCorrecta = respuestas[0];
        shuffle(respuestas);
        opcion1.setText(respuestas[0]);
        opcion2.setText(respuestas[1]);
        opcion3.setText(respuestas[2]);
        opcion4.setText(respuestas[3]);
        accion(opcion1,respuestaCorrecta);
        accion(opcion2,respuestaCorrecta);
        accion(opcion3,respuestaCorrecta);
        accion(opcion4,respuestaCorrecta);
    }

    public void accion(Button btnRespuesta, String respuestaCorrecta){
        
        btnRespuesta.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event t)->{
           if (btnRespuesta.getText().equals(respuestaCorrecta)){
               btnRespuesta.setStyle("-fx-background-color:#CBCB5C;");
               btnRespuesta.getStyleClass().add("rounded");
               msg.setText("Ganaste");
               msg.setTextFill(Color.GREEN);
           }
           else{
               btnRespuesta.setStyle("-fx-background-color:#F41E1E;");
               btnRespuesta.getStyleClass().add("rounded");
               msg.setText("Perdiste");
               msg.setTextFill(Color.RED);

           }
        });
    }
    
    
    
    
}