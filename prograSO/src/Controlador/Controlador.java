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
