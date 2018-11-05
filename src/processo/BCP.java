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
    private int tempoChegada;
    private int tempoTotal;
    private LinkedList<Integer> listaIO;
    public BCP(){
        this.listaIO = new LinkedList<>();
    }

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

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempo) {
        this.tempoChegada = tempo;
    }
    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempo) {
        this.tempoTotal = tempo;
    }

    public LinkedList<Integer> getListaIO() {
        return listaIO;
    }

    public void setListaIO(LinkedList<Integer> listaIO) {
        this.listaIO = listaIO;
    }
    
    public void printProcesso(){
        System.out.print("P" + this.getId()+" ");
        //System.out.println("Tamanho: " + this.getTempoTotal());
        //System.out.println("Prioridade: " + this.getPrioridade());
        //System.out.println("TempoChegada: " + this.getTempoChegada());
    }
    
    public void copiaProcesso(BCP processo){
        this.id = processo.id;
        this.estado = processo.estado;
        this.listaIO = processo.listaIO;
        this.prioridade = processo.prioridade;
        this.tempoChegada = processo.tempoChegada;
        this.tempoTotal = processo.tempoTotal;
    }
    
}
