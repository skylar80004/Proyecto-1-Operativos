/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rigo-PC
 */
public class Proceso {
    
    
    private int identificador;
    private String estado;
    private int prioridad;
    private int ProgramCounter;

    public Proceso(int identificador, String estado, int prioridad) {
        this.identificador = identificador;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    
    
    public void ImprimirProceso(){
        System.out.println("Proceso # " + this.identificador +
        " estado: " + this.estado + " Prioridad: " + this.prioridad);
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
