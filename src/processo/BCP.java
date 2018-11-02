/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo;

import java.util.LinkedList;

/**
 *
 * @author guilherme
 */
public class BCP {
    private int id;
    private int prioridade;
    private String estado;
    private int tempo;
    private LinkedList<Integer> listaIO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public LinkedList<Integer> getListaIO() {
        return listaIO;
    }

    public void setListaIO(LinkedList<Integer> listaIO) {
        this.listaIO = listaIO;
    }
    
}
