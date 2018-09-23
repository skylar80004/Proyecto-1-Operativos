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
    
    
    public void Send(int destino, String contenidoMensaje){
        
        boolean sendDirect = this.IsDirectSend();
        boolean sendBlocking = this.isBlockingSend();
        
        if(sendDirect){ // Direccionamiento Directo
            
            agregarIdDestinoAMensaje(contenidoMensaje, destino);
            
            
        } // Direccionamiento Indirecto
        else{
            
            
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
