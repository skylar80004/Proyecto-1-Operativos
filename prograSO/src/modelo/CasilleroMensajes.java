/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.Singleton;
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
    
    
    
    public String getCasilleroString(){
        
        String casillero = "";
        String mensajeActual;
        String mensajeCompleto = "";
        
        int id;
        String tipo ; 
        int destino;
        int fuente;
        int largo;
        String contenido;
        
        
        for(Mensaje mensaje : this.listaMensajes){
            
            id = mensaje.getId();
            contenido = (String)mensaje.getContenido();
            tipo = mensaje.getTipo();
            destino = mensaje.getDestino();
            fuente = mensaje.getFuente();
            largo = mensaje.getLargo();
            
            mensajeCompleto = "ID: " + String.valueOf(id) + " Contenido: " 
                    + contenido + " Destino: " + 
                    String.valueOf(destino) + " Fuente: " + String.valueOf(fuente) 
                    + " Largo: " + largo  + "\n"; 
            
            casillero = casillero + mensajeCompleto;
            
        }
        return casillero;
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
            
            //Singleton.getInstance().getControlador().getColaMensajes().removerMensaje(mensaje);
            //Singleton.getInstance().getControlador().getColaMensajesProcesados().agregarMensaje(mensaje);
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
    
    public void ejecutarPrioridades(){
        int cantidad = this.listaMensajes.size();
        ArrayList<Integer> listaPrioridades;
        int pos;
        
        for(int i=0;i<cantidad;i++){
            listaPrioridades = determinarPrioridadMensajes();
            pos = determinarPrioridadMenor(listaPrioridades);
            //System.out.println("Posicion menor prioridad: "+pos);
            Mensaje msg = (Mensaje) this.listaMensajes.get(pos);
            String contenido = (String) msg.getContenido();
            if(Singleton.getInstance().getControlador().completitudMensaje(contenido)){
                //System.out.println("Elimino un valor");
            }
        }
    }
    
    public ArrayList<Integer> determinarPrioridadMensajes(){
        ArrayList<Integer> listaPrioridad = new ArrayList<>();
        for(int i=0;i<this.listaMensajes.size();i++){
           Mensaje msg = (Mensaje) this.listaMensajes.get(i);
           int fuente = msg.getFuente();
           int destino = msg.getDestino();
           int prioridadFuente = obtenerPrioridadProceso(fuente);
           int prioridadDestino = obtenerPrioridadProceso(destino);
           listaPrioridad.add(prioridadDestino+prioridadFuente);
        
        }
        
        return listaPrioridad;
    }
    
    public int determinarPrioridadMenor(ArrayList<Integer> prioridades){
        int result=0;
        int valor=prioridades.get(0);
        int valor1=0;
        for(int i=1;i<prioridades.size();i++){
            valor1 = prioridades.get(i);
            //if(valor1>=0){
                if(valor1<valor){
                    result=i;
                }
            //}
        }
        return result;
    }
    
    public int obtenerPrioridadProceso(int proceso){
        if(proceso==-1){
            return -999;
        }
        return Singleton.getInstance().getControlador().getColaProcesos().getListaProcesos().get(proceso).getPrioridad();
    }
    
    public boolean AgregarMensajeEstatico(Mensaje mensaje){
        
        
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

    public boolean AgregarMensajeDinamico(Mensaje mensaje){

        this.listaMensajes.add(mensaje);
        this.listaMensajesCola.add(mensaje);
        return true;
        
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
