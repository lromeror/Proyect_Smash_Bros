package ec.edu.espol.super_smash_bros;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

    @FXML
    private VBox content;
    private ArrayList<Personaje> personajes;
    
//    DataSingleton data = DataSingleton.getInstance();
    
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
        content.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth()-15);
        personajes = Personaje.readPersonajes("smash.txt");
        int ind = 0;
        for (int i = 0; i < 19; i++){
            HBox row = new HBox();
            for (int j = 0; j < 4; j++){
                
                try{
                    Personaje per = personajes.get(ind);
//                    Move[] movimientos = {new Move("Bola de fuego",TipoMovimiento.NORMAL, "/data/mario/normal.jpg"),
//                    new Move("Capa",TipoMovimiento.LAT, "/data/mario/lat.jpg"),
//                    new Move("Supersalto puñetazo",TipoMovimiento.UP, "/data/mario/up.jpg"),
//                    new Move("F.L.U.D.D",TipoMovimiento.DOWN, "/data/mario/down.jpg")};
//                    Personaje per = new Personaje("Mario",movimientos,new Move("Mario final",TipoMovimiento.FO, "/data/mario/final.jpg"), "mario.png","El plomero favorito de todos es un personaje equilibrado que está listo para enfrenta cualquier situación.");
//                    
                    Image img = new Image("images_png_1/"+per.getImagen());
                    
                    ImageView imgV = new ImageView(img);
                    Text text = new Text(per.getName());
                    imgV.setFitWidth(300);
                    
                    Tarjeta boton = new Tarjeta();
                    boton.setPrefWidth(100);
                    VBox.setMargin(boton, new Insets(20, 5, 5, 20));
                    boton.getChildren().add(imgV);
                    boton.getChildren().add(text);
                    boton.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event t) -> {
//                        Personaje p = boton.getPersonaje();
//                        data.setPersonaje(p);
                        try {
                            SessionManager.getInstance().setPersonaje(per);
                            switchToSecondary();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    row.getChildren().add(boton);
                    ind++;
                }
                catch(Exception e){
                    Move[] movimientos = {new Move("Bola de fuego",TipoMovimiento.NORMAL, "/data/mario/normal.jpg"),
                    new Move("Capa",TipoMovimiento.LAT, "/data/mario/lat.jpg"),
                    new Move("Supersalto puñetazo",TipoMovimiento.UP, "/data/mario/up.jpg"),
                    new Move("F.L.U.D.D",TipoMovimiento.DOWN, "/data/mario/down.jpg")};
                    Personaje per = new Personaje("Mario",movimientos,new Move("Mario final",TipoMovimiento.FO, "/data/mario/final.jpg"), "mario.png","El plomero favorito de todos es un personaje equilibrado que está listo para enfrenta cualquier situación.");
//                    
                    Image img = new Image("images_png_2/"+per.getImagen());
                    
                    ImageView imgV = new ImageView(img);
                    Text text = new Text(per.getName());
                    imgV.setFitWidth(300);
                    
                    Tarjeta boton = new Tarjeta();
//                    boton.setPrefWidth(100);
//                    VBox.setMargin(boton, new Insets(20, 5, 5, 20));
                    boton.getChildren().add(imgV);
                    boton.getChildren().add(text);
                    boton.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event t) -> {
//                        Personaje p = boton.getPersonaje();
//                        data.setPersonaje(p);
                        try {
                            SessionManager.getInstance().setPersonaje(per);
                            switchToSecondary();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    row.getChildren().add(boton);
                    ind++;
                }
            }
            content.getChildren().add(row);
        }
        
        ImageView ima = new ImageView(new Image("taws/footer.jpg"));
        
//        ima.fitWidthProperty().bind(ima.fitHeightProperty());
        ima.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()-15);
//        ima.setFitHeight();
        content.getChildren().add(ima);
    }
}
