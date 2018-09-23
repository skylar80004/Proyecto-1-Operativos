/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.ColaMensajes;
import modelo.ColaProcesos;
import modelo.ConfiguracionSistema;
import modelo.Mensaje;
import modelo.Proceso;

/**
 *
 * @author Rigo-PC
 */
public class Controlador {
    
    private ColaMensajes colaMensajes;
    private ConfiguracionSistema configuracionSistema;
    private ColaProcesos colaProcesos;

    
    
    
    public void CambiarEstadoProceso(int idProceso, String estado){
        
        int idTemporal;
        Proceso procesoTemporal ;
        for(int i = 0; i < this.colaProcesos.getListaProcesos().size();i++){
            
            procesoTemporal =  this.colaProcesos.getListaProcesos().get(i);
            idTemporal = procesoTemporal.getIdentificador();
            if(idTemporal == idProceso){
                
                procesoTemporal.setEstado(estado);
                this.colaProcesos.getListaProcesos().set(i, procesoTemporal);
                return;
                
            }
        }
    }
    
    public boolean isBlockingSend(){
        
        String configSyncSend = this.configuracionSistema.getSincronizacion().getSend();
        if(configSyncSend.equals("Blocking")){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    

    
    public boolean isReceiveExplicit(){
        
        return this.configuracionSistema.getDireccionamiento().isReceiveExplicit();
        
    }
    public boolean isReceiveIndirectStatic(){
       return this.configuracionSistema.getDireccionamiento().isIndirectStatic();
    }
    
    
    public void Receive(int idProcesoFuente, String contenido){
        
        
        boolean isDirectAdressing = this.IsDirectSend();
        if(isDirectAdressing){ // Direccionamiento Directo
            
            boolean receiveDirectExplicit = this.isReceiveExplicit();
            
            if(receiveDirectExplicit){ // Receive Directo Explicito
                          System.out.println("Recieve Directo Explicito");
            }          
            else{ // Receive Directo Implicito
                System.out.println("Recieve Directo Implicito");
            }
            
        }
        else{ // Direccionamiento Indirecto
            boolean isIndirectStatic = this.isReceiveIndirectStatic();
            if(isIndirectStatic){ // Direccionamiento indirecto estatico
                System.out.println("Recieve Indirecto estatico");
            }
            else{ // Direccionamiento indirecto dinamico
                System.out.println("Recieve Indirecto dinamico");
            }
        }
        
        
        
        
        
    }
    public void Create(String tipoContenido, String destinoString, String fuenteString, int largo, String contenido){
        
        
        int destino = Integer.parseInt(destinoString);
        int fuente = Integer.parseInt(fuenteString);
        int idMensaje = Singleton.getInstance().getCantidadMensajesCreados();
        
        
        Mensaje mensaje = new Mensaje(idMensaje, tipoContenido, destino, fuente, largo, contenido);
        
        // Agrega mensaje a la cola de mensajes
        Singleton.getInstance().getControlador().AgregarMensaje(mensaje);
        int cantidadMensajes = Singleton.getInstance().getCantidadMensajesCreados();
        cantidadMensajes++;
        
        Singleton.getInstance().setCantidadMensajesCreados(cantidadMensajes);
        
    }
    public void Send(int destino, String contenidoMensaje){
        
        boolean sendDirect = this.IsDirectSend();
        boolean sendBlocking = this.isBlockingSend();
        
        if(sendDirect){ // Direccionamiento Directo
            
            agregarIdDestinoAMensaje(contenidoMensaje, destino);
            
            
        } // Direccionamiento Indirecto
        else{
            
            // El mensaje ya se encuentra en la cola de mensajes       
        }
        
        // Synchronization
        
        if(sendBlocking){
            this.CambiarEstadoProceso(destino, "Blocked");
        }
        
        
        
    }
    public boolean agregarIdDestinoAMensaje(String contenido, int idDestino){
        
        return this.colaMensajes.agregarIdDestino(contenido, idDestino);
    }
    
        
    public Mensaje encontrarMensaje(String contenidoMensaje){
        Mensaje mensaje = this.colaMensajes.encontrarMensaje(contenidoMensaje);
        return mensaje;
    }
    // Pregunta si la configuracion tiene Send de tipo Directo
    public boolean IsDirectSend(){
        
        
        boolean isDirect = this.configuracionSistema.getDireccionamiento().isDirect();
        //String direcionamiento = this.getConfiguracionSistema().getDireccionamiento();
        return isDirect;
        
    }
    
    public ColaMensajes getColaMensajes() {
        return colaMensajes;
    }
    
    public void AgregarMensaje(Mensaje mensaje){
        
        this.colaMensajes.agregarMensaje(mensaje);
        
    }
            

    public void setColaMensajes(ColaMensajes colaMensajes) {
        this.colaMensajes = colaMensajes;
    }

    public ConfiguracionSistema getConfiguracionSistema() {
        return configuracionSistema;
    }

    public void setConfiguracionSistema(ConfiguracionSistema configuracionSistema) {
        this.configuracionSistema = configuracionSistema;
    }

    public ColaProcesos getColaProcesos() {
        return colaProcesos;
    }

    public void setColaProcesos(ColaProcesos colaProcesos) {
        this.colaProcesos = colaProcesos;
    }
    
    
    public boolean crearProcesos(){
        
        int identificador ;
        int cantidadProcesos = this.getConfiguracionSistema().getNumeroProcesos();
        
        
        if (cantidadProcesos == 0){
            return false;
        }
        
        for(int i = 0; i < cantidadProcesos; i++){
            
            identificador = Singleton.getInstance().getCantidadProcesosCreados();
            Proceso proceso = new Proceso(identificador,"Ready",identificador);
            identificador++;
            Singleton.getInstance().setCantidadProcesosCreados(identificador);
            
            //Singleton.getInstance().getControlador().getColaProcesos();
            Singleton.getInstance().getControlador().getColaProcesos().AgregarProceso(proceso);
            
        }
        return true;
    }
    
    
    
}
