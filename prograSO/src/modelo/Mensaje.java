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
public class Mensaje {
        
    private int id;
    private String tipo;
    private int destino;
    private int fuente;
    private int largo;
    private Object contenido;
    
    public Mensaje(){
        
    }
    
    public Mensaje(int id, String tipo, int destino, int fuente, int largo, Object contenido) {
        this.id = id;
        this.tipo = tipo;
        this.destino = destino;
        this.fuente = fuente;
        this.largo = largo;
        this.contenido = contenido;
    }
    
    
    public void ImprimirMensaje(){
        
        System.out.println("ID Mensaje: " + this.id + " Tipo Contenido: " + this.tipo + " Destino: " + destino + 
                " Fuente: " + fuente + " Largo: " + largo + " Contenido: " + contenido);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getFuente() {
        return fuente;
    }

    public void setFuente(int fuente) {
        this.fuente = fuente;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
    
    
}
