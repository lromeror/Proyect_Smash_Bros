/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.super_smash_bros;

import javafx.scene.layout.StackPane;

/**
 *
 * @author josel
 */
public class Tarjeta extends StackPane{
    private Personaje personaje;
    
    public Tarjeta(Personaje personaje){
        this.personaje = personaje;
    }
    
    public Tarjeta(){
        
    }
    
    public Personaje getPersonaje(){
        return this.personaje;
    }
}
