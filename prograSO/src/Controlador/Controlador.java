/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
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
    private ColaMensajes colaMensajesProcesados;
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
    
    
    
    public boolean Create(String contenido){
        
        
        String tipoContenido = this.configuracionSistema.getFormato().getContenido();
        
        
        int tamanoCola = Singleton.getInstance().getControlador().getColaMensajes().getListaMensajes().size();
        int maximo = Singleton.getInstance().getControlador().getColaMensajes().getTamano();
        
        if(tamanoCola<maximo){
            int idMensaje = Singleton.getInstance().getCantidadMensajesCreados();
            int largo = this.configuracionSistema.getFormato().getTamano();

            Mensaje mensaje = new Mensaje(idMensaje, tipoContenido, -1, -1, largo, contenido);

            // Agrega mensaje a la cola de mensajes
            Singleton.getInstance().getControlador().AgregarMensaje(mensaje);
            int cantidadMensajes = Singleton.getInstance().getCantidadMensajesCreados();
            cantidadMensajes++;

            Singleton.getInstance().setCantidadMensajesCreados(cantidadMensajes);
            //Singleton.getInstance().getControlador().colaMensajes.ImprimirColaMensaje();
            return true;
        }
        
        return false;
    }
    
    public boolean Send(int destino, String contenidoMensaje){
        
        boolean sendDirect = this.IsDirectSend();
        boolean sendBlocking = this.isBlockingSend();
        
        if(sendDirect){ // Direccionamiento Directo    (FiFo/Prioridad)

            boolean agregarMensaje = agregarIdDestinoAMensaje(contenidoMensaje, destino);
            
            if(!agregarMensaje){ // El mensaje no se puedo enviar ya que el proceso esta bloqueado               
                return false;
            }
            boolean receiveDirectExplicit = this.isReceiveExplicit();

            if(receiveDirectExplicit){
                agregarFuenteExplicito(contenidoMensaje, destino);
            }
            efectuarManejoCola(destino);
        } // Direccionamiento Indirecto
        else{ 
            boolean isIndirectStatic = this.isReceiveIndirectStatic();
            if(isIndirectStatic){ // Direccionamiento indirecto estatico
                System.out.println("Direccionamiento Indirecto estatico");
                Mensaje mensaje = this.colaMensajes.encontrarMensaje(contenidoMensaje);
                boolean agregar = this.casilleroMensaje.AgregarMensajeEstatico(mensaje);
                return agregar;
            }else{
                System.out.println("Direccionamiento Indirecto dinamico");
                Mensaje mensaje = this.colaMensajes.encontrarMensaje(contenidoMensaje);
                this.casilleroMensaje.AgregarMensajeDinamico(mensaje);         
            }
             
        }
        
        return true;
        
    }
    
    public boolean Receive(int idProcesoFuente, String contenido){
        
        
        boolean isDirectAdressing = this.IsDirectSend();
        if(isDirectAdressing){ // Direccionamiento Directo (FiFo/Prioridad)
            
            boolean receiveDirectExplicit = this.isReceiveExplicit();
            
            if(receiveDirectExplicit){ // Receive Directo Explicito
                boolean envio = agregarIdFuenteAMensaje(contenido, idProcesoFuente);
                efectuarManejoCola(idProcesoFuente);
                return envio;
            }          
            else{ // Receive Directo Implicito
                boolean envio = agregarIdFuenteAMensaje(contenido, idProcesoFuente);
                if(envio){
                   agregarFuenteImplicito(contenido, idProcesoFuente); 
                }
                efectuarManejoCola(idProcesoFuente);
                return envio;
            }
            
        }
        else{ // Direccionamiento Indirecto
            
            Mensaje mensaje = this.casilleroMensaje.SacarMensaje();
            boolean eliminado = this.colaMensajes.getListaMensajes().remove(mensaje);
            if(eliminado){
                this.colaMensajesProcesados.agregarMensaje(mensaje);
                return eliminado;
            }
            return false;
        }
       
    }
    
    public void efectuarManejoCola(int proceso){
        if(this.getConfiguracionSistema().getManejoColas().getTipo().equals("FIFO")){ //FIFO
            Mensaje msg = this.primeroColaMensajes();
            String contenido = (String) msg.getContenido();
            if(completitudMensaje(contenido)){
                if(this.getColaMensajes().getListaMensajes().size()>0){
                    efectuarManejoCola(proceso);
                }
            }else{
                this.getColaProcesos().cambiarPC(proceso, true);
            }

        }else{ //prioridad
             ejecutarPrioridades(proceso);
        }
    }
    
    public void ejecutarPrioridades(int proceso){
        int cantidad = this.getColaMensajes().getListaMensajes().size();
        ArrayList<Integer> listaPrioridades;
        int pos;
        
        for(int i=0;i<cantidad;i++){
            listaPrioridades = determinarPrioridadMensajes();
            pos = determinarPrioridadMenor(listaPrioridades);
            //System.out.println("Posicion menor prioridad: "+pos);
            Mensaje msg = (Mensaje) this.colaMensajes.getListaMensajes().get(pos);
            String contenido = (String) msg.getContenido();
            if(completitudMensaje(contenido)){
                //System.out.println("Elimino un valor");
            }else{
                this.getColaProcesos().cambiarPC(proceso, true);
            }
        }
    }
    
    public ArrayList<Integer> determinarPrioridadMensajes(){
        ArrayList<Integer> listaPrioridad = new ArrayList<>();
        for(int i=0;i<this.colaMensajes.getListaMensajes().size();i++){
           Mensaje msg = (Mensaje) this.colaMensajes.getListaMensajes().get(i);
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
        return this.getColaProcesos().getListaProcesos().get(proceso).getPrioridad();
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
            return this.colaMensajes.agregarIdFuente(contenido, idFuente);
            
        }
        
    }
    
    public boolean completitudMensaje(String contenidoMensaje){
        String contenidoActual;
        Mensaje mensaje;
        for(int i=0;i<this.colaMensajes.getListaMensajes().size();i++){
            mensaje = (Mensaje) this.colaMensajes.getListaMensajes().get(i);
            contenidoActual = (String) mensaje.getContenido();
            if (contenidoActual.equals(contenidoMensaje)){
                if(mensaje.getDestino()!=-1 && mensaje.getFuente()!=-1){
                    this.colaMensajesProcesados.getListaMensajes().add(mensaje);
                    this.getColaProcesos().cambiarPC(mensaje.getDestino(), false);
                    this.getColaProcesos().cambiarPC(mensaje.getFuente(), false);
                    return colaMensajes.removerMensaje(mensaje);
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean evaluarFiFo(String operacion){
        Mensaje mensaje = (Mensaje) this.colaMensajes.getListaMensajes().get(0);
        if(operacion.equals("Send")){
            if(mensaje.getFuente()!=-1){
                return true;
            }
        }else{
            if(mensaje.getDestino()!=-1){
                return true;
            }
        }
        return false;
    }
    
    public Mensaje primeroColaMensajes(){
        return (Mensaje) this.colaMensajes.getListaMensajes().get(0);
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
        String evento;
        for(int i = 0; i < cantidadProcesos; i++){
            
            identificador = Singleton.getInstance().getCantidadProcesosCreados();
            
            //estado = this.configuracionSistema.
            estadoSend = this.configuracionSistema.getSincronizacion().getSend();
            estadoReceive = this.configuracionSistema.getSincronizacion().getReceive();
            
            Proceso proceso = new Proceso(identificador,estadoSend,estadoReceive,identificador);
            int idProceso = proceso.getIdentificador();
            
            // Evento de creacion
            evento = "El proceso " + String.valueOf(idProceso) + " fue creado";
            proceso.AgregarEvento(evento);
            
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

    public ColaMensajes getColaMensajesProcesados() {
        return colaMensajesProcesados;
    }

    public void setColaMensajesProcesados(ColaMensajes colaMensajesProcesados) {
        this.colaMensajesProcesados = colaMensajesProcesados;
    }
    
    
    
}
