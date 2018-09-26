/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Rigo-PC
 */
public class ColaProcesos {
    private int tamano;
    private ArrayList<Proceso> listaProcesos;

    public ColaProcesos(int tamano){

        this.tamano = tamano;
        listaProcesos = new ArrayList<Proceso>();
    }


    public ArrayList<Proceso> getListaProcesos(){
        return this.listaProcesos;
    }
    
    
    public boolean isProcessSendBlocked(int idProceso){
        
        for(Proceso proceso : this.listaProcesos){
            
            int idProcesoTemporal = proceso.getIdentificador();
            String estadoTemporal  = proceso.getEstadoSend();
            if(idProcesoTemporal == idProceso && estadoTemporal.equals("Blocking")){
                return true;
            }
        }
        return false;
        
    }
    
    public boolean isProcessReceiveBlocked(int idProceso){
        
        for(Proceso proceso : this.listaProcesos){
            
            int idProcesoTemporal = proceso.getIdentificador();
            String estadoTemporal  = proceso.getEstadoReceive();
            if(idProcesoTemporal == idProceso && estadoTemporal.equals("Blocking")){
                return true;
            }
        }
        return false;
        
    }
    
    public void ImprimirColaProcesos(){

        for (Proceso proceso : this.listaProcesos) {
            proceso.ImprimirProceso();
        }

    }

       public void AgregarProceso(Proceso proceso){
        this.listaProcesos.add(proceso);
    }


    public void agregarEventoProceso(int proceso,String evento){
        for(int i=0;i<this.listaProcesos.size();i++){
            Proceso proc = this.listaProcesos.get(i);
            if(proc.getIdentificador()==proceso){
                proc.AgregarEvento(evento);
                this.listaProcesos.set(i, proc);
            }
        }
    }

}
