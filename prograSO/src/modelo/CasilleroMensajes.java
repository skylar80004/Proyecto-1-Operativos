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
    private ArrayList<Integer> listaPrioridades;
    private int largoMaximo;
    private String manejoCola;
    private String tipoLargo; 
   // private String
    
    
    public CasilleroMensajes(int largoMaximo, String manejoCola, String tipoLargo){
        
        listaMensajes = new ArrayList<>();
        listaMensajesCola = new LinkedList<>();
        listaPrioridades = new ArrayList<>();
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
        int prioridad;
        
        int i=0;
        for(Mensaje mensaje : this.listaMensajes){
            
            id = mensaje.getId();
            contenido = (String)mensaje.getContenido();
            tipo = mensaje.getTipo();
            destino = mensaje.getDestino();
            fuente = mensaje.getFuente();
            largo = mensaje.getLargo();
            prioridad = listaPrioridades.get(i);
            mensajeCompleto = "ID: " + String.valueOf(id) + " Contenido: " 
                    + contenido + " Destino: " + 
                    String.valueOf(destino) + " Fuente: " + String.valueOf(fuente) 
                    + " Largo: " + largo +" Prioridad: "+String.valueOf(prioridad) + "\n"; 
            
            casillero = casillero + mensajeCompleto;
            i+=1;
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

            return mensaje;

        }
        else{ // Prioridad
            
            int prioridadActual = determinarPrioridadMenor(listaPrioridades);
            
            Mensaje mensajeARetornar = listaMensajes.get(prioridadActual);
            
            this.listaMensajesCola.remove(mensajeARetornar); 
            listaMensajes.remove(mensajeARetornar);
            return mensajeARetornar;

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
            int numero = (int) (Math.random() * 10) + 1;
            listaPrioridades.add(numero);
            return true;
            
        }
        else{
            return false;
            
        }
        
    }

    public boolean AgregarMensajeDinamico(Mensaje mensaje){

        this.listaMensajes.add(mensaje);
        this.listaMensajesCola.add(mensaje);
        int numero = (int) (Math.random() * 10) + 1;
        listaPrioridades.add(numero);
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
