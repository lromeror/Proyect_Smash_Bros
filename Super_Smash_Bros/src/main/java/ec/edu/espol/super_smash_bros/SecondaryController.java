package ec.edu.espol.super_smash_bros;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {
    
    private Personaje personaje;
    
    public void setPersonaje(Personaje p){
        this.personaje = p;
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}