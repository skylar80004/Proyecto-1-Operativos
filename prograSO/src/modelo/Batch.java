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
import javax.swing.JOptionPane;

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
       String tamanoMailBoxString = "";
       
       
       
       
       
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
                       case(10): {
                           tamanoMailBoxString = linea;
                           break;
                           
                       }
                   }
                   
                   cantidadInstruccionConfiguracion++;
  
               }
               else if(create){
                   
                   if(Singleton.getInstance().getControlador().getConfiguracionSistema() == null){
                       
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
        int tamanoMailBox = 0;
        
        CasilleroMensajes casilleroMensajes = new CasilleroMensajes(tamanoMailBox,manejoColasString,tipoLargo);
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
                   
        
                   
                   String contenido = linea;
                   int largoMensaje = contenido.length();
                   int largoMaximo = Singleton.getInstance().getControlador().getConfiguracionSistema().getFormato().getTamano();
                   if(Singleton.getInstance().getControlador().getConfiguracionSistema().getFormato().getLargo().equals("Largo Fijo")){
                       
                       if(largoMensaje > largoMaximo){
                           String mensajeDialog = "El tamaño del mensaje es mayor que el permitido";
                           String tituloBarra = "Tamano no permitido";
                           this.mensajeDialog(mensajeDialog, tituloBarra);
                           return;
                       }
                   }
                   
                   boolean estado = Singleton.getInstance().getControlador().Create(contenido);
        
                   if(estado){
                       String mensajeDialogoContenido = "Se ha creado el mensaje";
                       String tituloDialogoContenido = "Mensaje creado";
                       this.mensajeDialog(mensajeDialogoContenido ,tituloDialogoContenido);
                   }
                   else{
                       String mensajeDialogoContenido = "No se ha creado el mensaje";
                       String tituloDialogoContenido = "Mensaje no creado";
                       this.mensajeDialog(mensajeDialogoContenido ,tituloDialogoContenido);
                   }
               }
               
               else if(send){
                   
                   String idDestinoString = linea;
                   linea = br.readLine();
                   String contenidoMensaje = linea;
                   
                   int idProcesoDestino;
                   try{
                       idProcesoDestino = Integer.parseInt(idDestinoString);
                   }
                   catch(Exception e){
                       idProcesoDestino = 0;
                   }

                   

                    boolean sendBoolean = Singleton.getInstance().getControlador().Send(idProcesoDestino, contenidoMensaje);

                    String contenidoMensajeDialog = "Se ha enviado el mensaje";
                    String tituloBarra = "Send";

                    if(sendBoolean){
                        String var = "El proceso: "+String.valueOf(idProcesoDestino)+" pudo recibir el mensaje: "+contenidoMensaje;
                        Singleton.getInstance().getControlador().getColaProcesos().agregarEventoProceso(idProcesoDestino,var);
                        contenidoMensajeDialog = "Se ha enviado el mensaje";
                        this.mensajeDialog(contenidoMensajeDialog, tituloBarra);

                    }
                    else{
                        String var = "El proceso: "+String.valueOf(idProcesoDestino)+" no pudo recibir el mensaje: "+contenidoMensaje;
                        Singleton.getInstance().getControlador().getColaProcesos().agregarEventoProceso(idProcesoDestino,var);
                        contenidoMensajeDialog = "El mensaje no se pudo enviar";
                        this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
                    }  
               }
               else if(receive){
                   
                   String idProcesoFuenteString = linea;
                   linea = br.readLine();
                   String contenidoMensaje = linea;
                   int idProcesoFuente;
                   try{
                       idProcesoFuente = Integer.parseInt(idProcesoFuenteString);
                   }
                   catch(Exception e){
                       idProcesoFuente = 0;
                   }
        
                    boolean receiveBoolean = Singleton.getInstance().getControlador().Receive(idProcesoFuente,contenidoMensaje);
                    String contenidoMensajeDialog = "";
                    String tituloBarra = "Receive";

                    if(receiveBoolean){
                        String var = "El proceso: "+String.valueOf(idProcesoFuente)+" pudo enviar el mensaje: "+contenidoMensaje;
                        Singleton.getInstance().getControlador().getColaProcesos().agregarEventoProceso(idProcesoFuente,var);
                        contenidoMensajeDialog = "Receive procesado";
                        this.mensajeDialog(contenidoMensajeDialog, tituloBarra);

                    }
                    else{
                        String var = "El proceso: "+String.valueOf(idProcesoFuente)+"no pudo enviar el mensaje: "+contenidoMensaje;
                        Singleton.getInstance().getControlador().getColaProcesos().agregarEventoProceso(idProcesoFuente,var);
                        contenidoMensajeDialog = "Receive no procesado";
                        this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
                    }
               }
           }
       }
       
       
        
        
       
       
       
   }
   public void mensajeDialog(String mensaje, String tituloBarra){
        
        JOptionPane.showMessageDialog(null, mensaje, tituloBarra, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
