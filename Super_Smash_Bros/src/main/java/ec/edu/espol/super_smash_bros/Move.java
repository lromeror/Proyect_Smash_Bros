/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.super_smash_bros;

/**
 *
 * @author josel
 */
public class Move {
    private String name;
    private TipoMovimiento tipo;
    private String imagen;

    public Move(String name, TipoMovimiento tipo, String imagen) {
        this.name = name;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
