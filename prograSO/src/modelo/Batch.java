/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.Singleton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author josed
 */
public class Batch {
    
    
    
   public Batch(){
       
   }
   
   public void leerArchivo(File file) throws IOException{
       
       FileReader fileReader = new FileReader(file);
       String linea = "";
       BufferedReader br = new BufferedReader(fileReader);
       
       boolean configuracion = false;
       boolean create = false;
       boolean send = false;
       boolean receive = false;
       
       String tipoContenido = "";
       String tipoLargo = "";
       String largoMensajeString = "";
       String manejoColasString = "";
       String syncSend = "";
       String syncReceive = "";
       String addresingType = "";
       String addresingSubType = "";
       String numeroProcesos = "";
       String tamanoColaMensajesString = "";
       
       
       
       
       
       int cantidadInstruccionConfiguracion = 0;
       
       
       
       while( (linea = br.readLine() ) != null){
           
           
           if(linea.equals("#configuracion")){
               
               configuracion = true;
               create = false;
               send = false;
               receive = false;
               cantidadInstruccionConfiguracion = 0;
           }
           
           else if(linea.equals("#create")){
               
               create = true;   
               configuracion = false;
               send = false;
               receive = false;
               cantidadInstruccionConfiguracion = 0;
           }
           
           else if(linea.equals("#send")){
               
               send = true;
               configuracion = false;
               create = false;
               receive = false;
               cantidadInstruccionConfiguracion = 0;
               
           }
           else if(linea.equals("#receive")){
               
               receive = true;
               configuracion = false;
               create = false;
               send = false;
               cantidadInstruccionConfiguracion = 0;
           }
           
           
           else{
               
               if(configuracion){
                   
                   switch(cantidadInstruccionConfiguracion){
                       
                       case(0): { // Tipo de Mensaje
                           
                           tipoContenido = linea;
                           break;
                       }
                       case(1):{
                           
                           tipoLargo = linea;
                           break;
                       }
                       case(2):{
                           
                           largoMensajeString = linea;
                           break;    
                       }
                       case(3): {
                           
                           manejoColasString = linea;
                           break;    
                       }
                       case(4):{
                           
                           syncSend = linea;
                           break;
                           
                       }
                       case(5):{
                           
                           syncReceive = linea;
                           break;
                       }
                       case(6): {
                           addresingType = linea;
                           break;
                       }
                       case(7): {
                           addresingSubType = linea;
                           break;
                           
                       }
                       case(8):{
                           
                           numeroProcesos = linea;
                           break;
                           
                       }
                       case(9):{
                           tamanoColaMensajesString = linea;
                           break;
                       }
                   }
                   
                   cantidadInstruccionConfiguracion++;
                   
                   
                   
               }
               
           }
           
           
           
       }
       
       
       // Instancia de objetos
       
       int largoMensajes = Integer.parseInt(largoMensajeString);
        ManejoColas manejoColas = new ManejoColas(manejoColasString);
        Formato formato = new Formato(tipoContenido,tipoLargo,largoMensajes);
        
        // Direccionamiento
        String addresing = addresingType + addresingSubType;
        Direccionamiento direccionamiento = new Direccionamiento(addresing);
        
        if(addresingType.equals("Directo")){
            direccionamiento.setDirect(true);
            
            if(addresingSubType.equals("Receive Explícito")){
                direccionamiento.setReceiveExplicit(true);
                direccionamiento.setReceiveImplicit(false);
            }
            else{
                direccionamiento.setReceiveExplicit(false);
                direccionamiento.setReceiveImplicit(true);
            }  
        }
        else{
            direccionamiento.setDirect(false);
            if(addresingSubType.equals("Estático")){
                direccionamiento.setIndirectStatic(true);
                direccionamiento.setIndirectDynamic(false);
            }
            else{           
                direccionamiento.setIndirectStatic(false);
                direccionamiento.setIndirectDynamic(true);
                
            }
                
        }
        
        //---------------------------------------------------------------------
        Sincronizacion sincronizacion = new Sincronizacion(syncSend,syncReceive);
        
        // Instancia Confuguracion
        
        int cantidadProcesos = Integer.parseInt(numeroProcesos);
        int tamanoColaMensajes = Integer.parseInt(tamanoColaMensajesString);
        ConfiguracionSistema configuracionSistema = new ConfiguracionSistema(cantidadProcesos, tamanoColaMensajes, sincronizacion, direccionamiento, formato, manejoColas);
        
        // Configuracion
        Singleton.getInstance().getControlador().setConfiguracionSistema(configuracionSistema);
        int tamanoColaProcesos = Singleton.getInstance().getControlador().getConfiguracionSistema().getNumeroProcesos();
        
        // Cola de Procesos
        ColaProcesos colaProcesos = new ColaProcesos(tamanoColaProcesos);
        Singleton.getInstance().getControlador().setColaProcesos(colaProcesos);
        
        // Cola de Mensajes
        ColaMensajes colaMensajes = new ColaMensajes(tamanoColaMensajes);
        Singleton.getInstance().getControlador().setColaMensajes(colaMensajes);
        
        System.out.println("Configuracion Lista");
        
        
        // Casillero de Mensajes int largoMaximo, String manejoCola, String tipoLargo){ 
        CasilleroMensajes casilleroMensajes = new CasilleroMensajes(tamanoColaMensajes,manejoColasString,tipoLargo);
        Singleton.getInstance().getControlador().setCasilleroMensaje(casilleroMensajes);
        
        // Creacion de Procesos
        Singleton.getInstance().getControlador().crearProcesos();
        Singleton.getInstance().getControlador().getColaProcesos().ImprimirColaProcesos();
        
        Singleton.getInstance().getControlador().getColaProcesos().ImprimirColaProcesos();
            
        //lista Solicitudes
        ListaSolicitudes listaSolicitudes = new ListaSolicitudes();
        Singleton.getInstance().getControlador().setListaSolicitudes(listaSolicitudes);
        
        //Cola mensajes procesados
        ColaMensajes colaMensajesProcesados = new ColaMensajes(-1);
        Singleton.getInstance().getControlador().setColaMensajesProcesados(colaMensajesProcesados);
        
        
       
       
       
   }
    
}
