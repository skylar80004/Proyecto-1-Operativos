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
    private String estadoSend;
    private String estadoReceive;
    private int prioridad;
    private int ProgramCounter;
    private ArrayList<String> logEventos;

    public Proceso(int identificador, String estadoSend, String estadoReceive, int prioridad) {
        
        this.identificador = identificador;
        this.estadoSend = estadoSend;
        this.estadoReceive = estadoReceive;
        this.prioridad = prioridad;
        this.logEventos = new ArrayList<String>();
    }
    
    
    public void AgregarEvento(String evento){
        this.logEventos.add(evento);
    }
    
    public String getEstadoSend() {
        return estadoSend;
    }

    public void setEstadoSend(String estadoSend) {
        this.estadoSend = estadoSend;
    }

    public String getEstadoReceive() {
        return estadoReceive;
    }

    public void setEstadoReceive(String estadoReceive) {
        this.estadoReceive = estadoReceive;
    }

    
    
    public void ImprimirProceso(){
        System.out.println("Proceso # " + this.identificador +
        " estado Send: " + this.estadoSend + " estado Receive: " + estadoReceive + " Prioridad: " + this.prioridad);
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
