/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.super_smash_bros;

/**
 *
 * @author josel
 */
public class DataSingleton {
    
    private static final DataSingleton instance = new DataSingleton();
    
    private Personaje personaje;
    
    private DataSingleton(){}

    public static DataSingleton getInstance(){
        return instance;
    }
    
    public Personaje getPersonaje(){
        return personaje;
    }
    
    public void setPersonaje(Personaje p){
        this.personaje = p;
    }
    
    public void cerrarSesion() {
        this.personaje = null;
    }
}
