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
    public void ImprimirColaProcesos(){

        for (Proceso proceso : this.listaProcesos) {
            proceso.ImprimirProceso();
        }

    }

       public void AgregarProceso(Proceso proceso){
        this.listaProcesos.add(proceso);
    }




}
