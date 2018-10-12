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
public class Proceso {
    
    
    private int identificador;
    private String estado;
    private int prioridad;
    private int ProgramCounter;
    private ArrayList<String> logEventos;
    private boolean uso;
    
    public Proceso(int identificador,String estado, int prioridad) {
        
        this.identificador = identificador;
        this.prioridad = prioridad;
        this.logEventos = new ArrayList<String>();
        this.uso=false;
        this.estado = estado;
    }
    
    public String getLogEventos(int cantidadEventos){
        
        if(cantidadEventos == -1){
            String evento;
            String logEventos = "";
            for(int i = 0 ; i <  this.logEventos.size(); i++){

                evento = this.logEventos.get(i);
                logEventos = logEventos + evento + "\n";           
            }
            return logEventos; 
        }
        
        else{
            
            String evento;
            String logEventos = "";
            for(int i = 0 ; i < cantidadEventos && i < this.logEventos.size(); i++){
                evento = this.logEventos.get(i);
                logEventos = logEventos + evento + "\n";           
        }
            return logEventos;
            
        }
        
    }
    public void AgregarEvento(String evento){
        this.logEventos.add(evento);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public boolean isUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    } 
    
    public void ImprimirProceso(){
        System.out.println("Proceso # " + this.identificador +
        " Estado:  " + estado + "Prioridad: " + this.prioridad);
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getProgramCounter() {
        return ProgramCounter;
    }

    public void setProgramCounter(int ProgramCounter) {
        this.ProgramCounter = ProgramCounter;
    }
    
    
}
