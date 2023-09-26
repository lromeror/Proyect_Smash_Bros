/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.super_smash_bros;

import java.io.Serializable;

/**
 *
 * @author Swat
 */
public class Personaje implements Serializable{
    
    private String name;
    private Moves[] moves = new Moves[4];
    
    public Personaje(String name_p, Moves[] moves_a){
        name = name_p;
        moves = moves_a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Moves[] getMoves() {
        return moves;
    }

    public void setMoves(Moves[] moves) {
        this.moves = moves;
    }
    
    
}
