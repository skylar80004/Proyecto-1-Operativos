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
        
        
        if(tipoLargo.equals("LargoFijo")){
            
            int largoActual = this.listaMensajes.size();
            if(largoActual <= largoMaximo){
                
                this.listaMensajes.add(mensaje);
                return true;
                
            }
            else{
                
                return false;
                
            }
            
        }
        else{ // Largo variable
            
            this.listaMensajes.add(mensaje);
            return true;
            
        }
        
        
    }
    
}
