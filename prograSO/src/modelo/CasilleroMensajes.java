/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author josed
 */
public class CasilleroMensajes {
    
    private Queue<Mensaje> listaMensajesCola;
    private ArrayList<Mensaje> listaMensajes; 
    private int largoMaximo;
    private String manejoCola;
    private String tipoLargo; 
   // private String
    
    
    public CasilleroMensajes(int largoMaximo, String manejoCola, String tipoLargo){
        
        listaMensajes = new ArrayList<Mensaje>();
        listaMensajesCola = new LinkedList<Mensaje>();
        this.largoMaximo = largoMaximo;
        this.manejoCola = manejoCola;
        this.tipoLargo = tipoLargo;
  
    }
    
    
    
    public Mensaje SacarMensaje(){ // Las listas de mensajes son paralelas
        
        if(this.manejoCola.equals("FIFO")){
            
            Mensaje mensaje = this.listaMensajesCola.poll();
            
            String contenido = (String)mensaje.getContenido();
            
            Mensaje mensajeTemporal;
            String contenidoTemporal;
            // Se saca el mensaje de la lista de mensajes normal
            
            for(int i = 0; i<this.listaMensajes.size();i++){
                
                mensajeTemporal = this.listaMensajes.get(i);
                contenidoTemporal = (String)mensajeTemporal.getContenido();
                
                if(contenido.equals(contenidoTemporal)){
                    listaMensajes.remove(i);
                }
            }
            
            return mensaje;

        }
        else{ // Prioridad
            
            
            int prioridadActual = 0 ;
            int prioridadTemporal = 0 ;
            for(Mensaje mensaje: this.listaMensajes){
                             
                prioridadTemporal = mensaje.getDestino();
                if(prioridadTemporal < prioridadActual){
                    prioridadActual = prioridadTemporal;
                }    
            }
            
            
            Mensaje mensajeARetornar = null;
            
            for(Mensaje mensaje : this.listaMensajes){
                
                if(mensaje.getDestino() == prioridadActual){
                    mensajeARetornar = mensaje;
                    break;
                }
                
            }
            
            this.listaMensajesCola.remove(mensajeARetornar); 
            return mensajeARetornar;

        }
        
    }
    
    public Mensaje EncontrarMensaje(String contenidoMensaje){
        
        
        
        String contenidoActual;
        for(Mensaje mensaje : listaMensajes){
            
            contenidoActual = (String)mensaje.getContenido();
            if (contenidoActual.equals(contenidoMensaje)){
                return mensaje;
            }
        }
        return null;
    
        
    }
    
    public boolean AgregarMensaje(Mensaje mensaje){
        
        
        int largoActual = this.listaMensajes.size();
        if(largoActual < this.largoMaximo){
            
            this.listaMensajes.add(mensaje);
            this.listaMensajesCola.add(mensaje);
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
