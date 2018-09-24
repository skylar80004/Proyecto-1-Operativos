/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class CasilleroMensajes {
    
    private ArrayList<Mensaje> listaMensajes;
    private int largoMaximo;
    private String manejoCola;
    private String tipoLargo; 
   // private String 
    public CasilleroMensajes(int largoMaximo, String manejoCola, String tipoLargo){
        
        listaMensajes = new ArrayList<Mensaje>();
        this.largoMaximo = largoMaximo;
        this.manejoCola = manejoCola;
        this.tipoLargo = tipoLargo;
  
    }
    
    public boolean AgregarMensaje(Mensaje mensaje){
        
        
        int largoActual = this.listaMensajes.size();
        if(largoActual < this.largoMaximo){
            
            this.listaMensajes.add(mensaje);
            return true;
            
        }
        else{
            return false;
            
        }
        
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public int getLargoMaximo() {
        return largoMaximo;
    }

    public void setLargoMaximo(int largoMaximo) {
        this.largoMaximo = largoMaximo;
    }

    public String getManejoCola() {
        return manejoCola;
    }

    public void setManejoCola(String manejoCola) {
        this.manejoCola = manejoCola;
    }

    public String getTipoLargo() {
        return tipoLargo;
    }

    public void setTipoLargo(String tipoLargo) {
        this.tipoLargo = tipoLargo;
    }
    
}
