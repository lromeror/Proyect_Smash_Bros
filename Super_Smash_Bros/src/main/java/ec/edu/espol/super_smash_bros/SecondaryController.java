package ec.edu.espol.super_smash_bros;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SecondaryController implements Initializable{
    
    private Personaje personaje;
    @FXML
    private ImageView viñeta;
    @FXML
    private ImageView tortuga;
    
    public void setPersonaje(Personaje p){
        this.personaje = p;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), tortuga); // Duración de la animación en segundos
        translateTransition.setFromX(-tortuga.getFitWidth()); // Posición inicial (fuera del área visible a la izquierda)
        translateTransition.setToX(tortuga.getParent().getLayoutBounds().getWidth()); // Posición final (fuera del área visible a la derecha)
//        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Repetir la animación indefinidamente
        translateTransition.setAutoReverse(false); // No invertir la animación al regresar

        // Inicia la animación
        translateTransition.play();
    }
}