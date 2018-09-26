/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.CasilleroMensajes;
import modelo.ColaMensajes;
import modelo.ColaProcesos;
import modelo.ConfiguracionSistema;
import modelo.ListaSolicitudes;
import modelo.Mensaje;
import modelo.Proceso;
import modelo.Solicitudes;

/**
 *
 * @author Rigo-PC
 */
public class Controlador {
    
    private ColaMensajes colaMensajes;
    private ConfiguracionSistema configuracionSistema;
    private ColaProcesos colaProcesos;
    private CasilleroMensajes casilleroMensaje;
    private ListaSolicitudes listaSolicitudes;

    public CasilleroMensajes getCasilleroMensaje() {
        return casilleroMensaje;
    }

    public void setCasilleroMensaje(CasilleroMensajes casilleroMensaje) {
        this.casilleroMensaje = casilleroMensaje;
    }

    
    public void CambiarEstadoProcesoReceive(int idProceso, String estado){
        
        int idTemporal;
        Proceso procesoTemporal ;
        for(int i = 0; i < this.colaProcesos.getListaProcesos().size();i++){
            
            procesoTemporal =  this.colaProcesos.getListaProcesos().get(i);
            idTemporal = procesoTemporal.getIdentificador();
            if(idTemporal == idProceso){
                
                procesoTemporal.setEstadoReceive(estado);
                this.colaProcesos.getListaProcesos().set(i, procesoTemporal);
                return;
                
            }
        }
    }
    
    public void CambiarEstadoProcesoSend(int idProceso, String estado){
        
        int idTemporal;
        Proceso procesoTemporal ;
        for(int i = 0; i < this.colaProcesos.getListaProcesos().size();i++){
            
            procesoTemporal =  this.colaProcesos.getListaProcesos().get(i);
            idTemporal = procesoTemporal.getIdentificador();
            if(idTemporal == idProceso){
                
                procesoTemporal.setEstadoSend(estado);
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
    
    
    public boolean Receive(int idProcesoFuente, String contenido){
        
        
        boolean isDirectAdressing = this.IsDirectSend();
        if(isDirectAdressing){ // Direccionamiento Directo
            
            boolean receiveDirectExplicit = this.isReceiveExplicit();
            
            if(receiveDirectExplicit){ // Receive Directo Explicito
                boolean envio = agregarIdFuenteAMensaje(contenido, idProcesoFuente);
                return envio;
            }          
            else{ // Receive Directo Implicito
                boolean envio = agregarIdFuenteAMensaje(contenido, idProcesoFuente);
                if(envio){
                   agregarFuenteImplicito(contenido, idProcesoFuente); 
                }
                return envio;
            }
            
        }
        else{ // Direccionamiento Indirecto
            boolean isIndirectStatic = this.isReceiveIndirectStatic();
            if(isIndirectStatic){ // Direccionamiento indirecto estatico
                
                
                Mensaje mensaje = this.casilleroMensaje.SacarMensaje();
                String contenidoMensaje = (String)mensaje.getContenido();
                Mensaje mensaje2 = this.colaMensajes.encontrarMensaje(contenido);
                System.out.println("Recieve Indirecto estatico");
                return false;
                
            }
            else{ // Direccionamiento indirecto dinamico
                System.out.println("Recieve Indirecto dinamico");
                return false;
            }
        }
        
  
    }
    public void Create(String contenido){
        
        
        String tipoContenido = this.configuracionSistema.getFormato().getContenido();
        int idMensaje = Singleton.getInstance().getCantidadMensajesCreados();
        //String largoString = this.configuracionSistema.getFormato().getTamano();
        int largo = this.configuracionSistema.getFormato().getTamano();
        
        
        Mensaje mensaje = new Mensaje(idMensaje, tipoContenido, 0, 0, largo, contenido);
        
        // Agrega mensaje a la cola de mensajes
        Singleton.getInstance().getControlador().AgregarMensaje(mensaje);
        int cantidadMensajes = Singleton.getInstance().getCantidadMensajesCreados();
        cantidadMensajes++;
        
        Singleton.getInstance().setCantidadMensajesCreados(cantidadMensajes);
        Singleton.getInstance().getControlador().colaMensajes.ImprimirColaMensaje();
        
    }
    public boolean Send(int destino, String contenidoMensaje){
        
        boolean sendDirect = this.IsDirectSend();
        boolean sendBlocking = this.isBlockingSend();
        
        if(sendDirect){ // Direccionamiento Directo
            
            boolean agregarMensaje = agregarIdDestinoAMensaje(contenidoMensaje, destino);
            
            if(!agregarMensaje){ // El mensaje no se puedo enviar ya que el proceso esta bloqueado
                return false;
            }
            boolean receiveDirectExplicit = this.isReceiveExplicit();
            
            if(receiveDirectExplicit){
                agregarFuenteExplicito(contenidoMensaje, destino);
            }
        } // Direccionamiento Indirecto
        else{
            System.out.println("Direccionamiento Indirecto");
            
            Mensaje mensaje = this.colaMensajes.encontrarMensaje(contenidoMensaje);
            boolean agregar = this.casilleroMensaje.AgregarMensaje(mensaje);
            
            if(!agregar){
                System.out.println("No se agrego");
                return false;
            }
            
            int largoActualCasillero = this.casilleroMensaje.getListaMensajes().size();
            int largoMaximo = this.casilleroMensaje.getLargoMaximo();
            System.out.println("Largo maximo del casillero: " + largoMaximo );
            System.out.println("Cantidad de mensajes en el casillero: " + largoActualCasillero);

            // El mensaje ya se encuentra en la cola de mensajes       
        }
        
        // Synchronization
        
        /*
        if(sendBlocking){
            this.CambiarEstadoProceso(destino, "Blocked");
        }
        */
        
        
        return true;
        
        
        
    }
    
    public void setSolicitud(Solicitudes solicitudes){
        this.listaSolicitudes.getListaSolicitudes().add(solicitudes);
    }
    
    public boolean agregarFuenteImplicito(String idMensaje,int idProcesoFuente){
        Solicitudes solicitud = new Solicitudes(idMensaje, idProcesoFuente, "ReceiveImplicito", true);
        this.listaSolicitudes.getListaSolicitudes().add(solicitud);
        return true;
    }
    public boolean agregarFuenteExplicito(String idMensaje,int idProcesoFuente){
        Solicitudes solicitud = new Solicitudes(idMensaje, idProcesoFuente, "ReceiveExplicito", true);
        this.listaSolicitudes.getListaSolicitudes().add(solicitud);
        return true;
    }
    
    public boolean isProcessSendBlocked(int idProceso){
        
        return this.colaProcesos.isProcessSendBlocked(idProceso);
        
    }
    
    public boolean isProcessReceiveBlocked(int idProceso){
        
        return this.colaProcesos.isProcessReceiveBlocked(idProceso);
        
    }
    
    public boolean agregarIdDestinoAMensaje(String contenido, int idDestino){
        
        boolean isProcessReceiveBlocked = this.isProcessReceiveBlocked(idDestino);
        if(isProcessReceiveBlocked){
            return false;
            
        }
        else{
            return this.colaMensajes.agregarIdDestino(contenido, idDestino);
            
        }
        
    }
    
    public boolean agregarIdFuenteAMensaje(String contenido, int idFuente){
        
        boolean isProcessSourceBlocked = this.isProcessSendBlocked(idFuente);
        if(isProcessSourceBlocked){
            return false;
            
        }
        else{
            System.out.println("SD");
            return this.colaMensajes.agregarIdFuente(contenido, idFuente);
            
        }
        
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
        
        String estadoSend ;
        String estadoReceive;
        for(int i = 0; i < cantidadProcesos; i++){
            
            identificador = Singleton.getInstance().getCantidadProcesosCreados();
            
            //estado = this.configuracionSistema.
            estadoSend = this.configuracionSistema.getSincronizacion().getSend();
            estadoReceive = this.configuracionSistema.getSincronizacion().getReceive();
            
            Proceso proceso = new Proceso(identificador,estadoSend,estadoReceive,identificador);
            identificador++;
            Singleton.getInstance().setCantidadProcesosCreados(identificador);
            
            //Singleton.getInstance().getControlador().getColaProcesos();
            Singleton.getInstance().getControlador().getColaProcesos().AgregarProceso(proceso);
            
        }
        return true;
    }

    public ListaSolicitudes getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ListaSolicitudes listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
    
    
    
}
