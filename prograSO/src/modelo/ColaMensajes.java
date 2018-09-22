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

    
    public void agregarMensaje(Mensaje mensaje){
        this.listaMensajes.add(mensaje);
        
    }
    
    public void ImprimirColaMensaje(){
        
        for(Mensaje mensaje: this.listaMensajes){
            mensaje.ImprimirMensaje();
        }
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
