/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class ColaMensajes {
    
    private int tamano;
    private ArrayList<Mensaje> listaMensajes;
    
    public ColaMensajes(int tamano) {
        this.tamano = tamano;
        this.listaMensajes = new ArrayList<Mensaje>();
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ArrayList getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    
    
}
