/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.super_smash_bros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Swat
 */
public class Personaje implements Serializable{
    
    private String name;
    private Move[] moves = new Move[4];
    private Move FO;
    private String imagen;
    private String descripcion;
    private HashMap<String, String[]> preguntaRespuestas;

    public Personaje(String name, Move[] moves, Move FO, String imagen, String descripcion,HashMap<String, String[]> preguntaRespuestas){
        this.name = name;
        this.moves = moves;
        this.FO = FO;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.preguntaRespuestas = preguntaRespuestas;
    }
    
    public Personaje(String name, String imagen){
        this.name = name;
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public Move[] getMoves() {
        return moves;
    }

    public Move getFO() {
        return FO;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    public void setFO(Move FO) {
        this.FO = FO;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HashMap<String, String[]> getPreguntaRespuestas(){
        return this.preguntaRespuestas;
    }
    
    public static ArrayList<Personaje> readPersonajes(String nomfile){
        ArrayList<Personaje> personajes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nomfile,StandardCharsets.UTF_8))){
            br.readLine();
            br.readLine();
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] tokens = line.split(";");
                String nombre = tokens[1];
                String image = tokens[4].replace("jpg", "png").strip();
                String descripcion = tokens[5];
                
                String[] FinalMove = tokens[3].split(":");
                Move FO = new Move(FinalMove[0],TipoMovimiento.FO, FinalMove[1]);
                String[] movimientos = tokens[2].split(",");
                Move[] moves = new Move[4];
                int ind = 0;
                for (String s: movimientos){
                    String[] mov = s.split(":");
                    Move move = null;
                    switch(mov[1].strip()){
                        case "NORMAL":
                            move = new Move(mov[0].strip(),TipoMovimiento.NORMAL,mov[2].strip());
                            break;
                        case "LAT":
                            move = new Move(mov[0],TipoMovimiento.LAT,mov[2]);
                            break;
                        case "UP":
                            move = new Move(mov[0],TipoMovimiento.UP,mov[2]);
                            break;
                        case "DOWN":
                            move = new Move(mov[0],TipoMovimiento.DOWN,mov[2]);
                            break;
                    }
                    moves[ind] = move;
                    ind++;
                }
                
                // lista de pregunta respuestas
                String pregunta = tokens[6]; // key
                String[] respuestas = tokens[7].split(","); //value
                HashMap <String, String[]> preguntasRespuestas = new HashMap<String, String[]>();
                preguntasRespuestas.put(pregunta, respuestas);

                //para obtener la key en este caso 
                // String keyPregunta = preguntaRespuestas.keySet().stream().findFirst().get()

                // para obtener el valor de las respuestas de la pregunta
                // preguntasRespuestas.get(keyPregunta r espuestas);
                Personaje personaje = new Personaje(nombre, moves, FO, image, descripcion,preguntasRespuestas);
                personajes.add(personaje);
            }
        }
            
        catch (Exception ex) {
            // Move[] movimientos = {new Move("Bola de fuego",TipoMovimiento.NORMAL, "/data/mario/normal.jpg"),
            //         new Move("Capa",TipoMovimiento.LAT, "/data/mario/lat.jpg"),
            //         new Move("Supersalto puñetazo",TipoMovimiento.UP, "/data/mario/up.jpg"),
            //         new Move("F.L.U.D.D",TipoMovimiento.DOWN, "/data/mario/down.jpg")};
            // Personaje p = new Personaje("Mario",movimientos,new Move("Mario final",TipoMovimiento.FO, "/data/mario/final.jpg"), "mario.jpg","El plomero favorito de todos es un personaje equilibrado que está listo para enfrenta cualquier situación.");
            // personajes.add(p);
        }
        
        return personajes;
    
    }
    
}
