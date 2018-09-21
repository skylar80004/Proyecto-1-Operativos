/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rigo-PC
 */
public class Direccionamiento {
    private String directoReceive;
    private String indirecto;
    private int tamano;

    public Direccionamiento(String directoReceive, String indirecto, int tamano) {
        this.directoReceive = directoReceive;
        this.indirecto = indirecto;
        this.tamano = tamano;
    }

    public String getDirectoReceive() {
        return directoReceive;
    }

    public void setDirectoReceive(String directoReceive) {
        this.directoReceive = directoReceive;
    }

    public String getIndirecto() {
        return indirecto;
    }

    public void setIndirecto(String indirecto) {
        this.indirecto = indirecto;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    
    
}
