/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import algoritmos.RoundRobin;
import java.util.LinkedList;
import processo.BCP;

/**
 *
 * @author tuchinski
 */
public class Processador {

    private LinkedList<Escalonador> listaAlg;
    private LinkedList<LinkedList<BCP>> ordemExecutados;
    public static int ciclo = 0;
    private int quantum = 1;

    public Processador(LinkedList<Escalonador> listaAlg) {
        this.listaAlg = listaAlg;
        this.ordemExecutados = new LinkedList<>();
    }

    public void processar() {
        int size = listaAlg.size();
        for (int i = 0; i < size; i++) {
            if (listaAlg.get(i).getClass() == algoritmos.RoundRobin.class){
                this.quantum = 4;
            }
            else {
                this.quantum = 1;
            }
            Escalonador atual = listaAlg.get(i);
            LinkedList<BCP> listaAtualExecutados = new LinkedList<>();
            do {
                BCP p = atual.escalonar();
                if (p != null) {
                    listaAtualExecutados.add(p);
                    if ((p.getTempoTotal() - quantum) < 0) {
                        ciclo += p.getTempoTotal();
                    } else {
                        ciclo += quantum;
                    }
                    atual.getListaProcessos().get(atual.returnIndexProcessoNaLista(p.getId())).setTempoTotal(p.getTempoTotal() - quantum);
                    p.setTempoTotal(p.getTempoTotal() - quantum);
                    if (p.getTempoTotal() <= 0) {
                        atual.removeById(p.getId(), atual.getListaProcessos());
                        atual.removeById(p.getId(), atual.getListaAptos());
                    }
                    
                    if (listaAlg.get(i).getClass() == algoritmos.RoundRobin.class){
                        BCP pTemp = listaAtualExecutados.removeFirst();
                        listaAtualExecutados.addLast(pTemp);
                    }

                } else {
                    ciclo++;
                }
            } while (!atual.getListaProcessos().isEmpty());
            ordemExecutados.add(listaAtualExecutados);
            Processador.ciclo = 0;
        }
    }

    public LinkedList<Escalonador> getListaAlg() {
        return listaAlg;
    }

    public void setListaAlg(LinkedList<Escalonador> listaAlg) {
        this.listaAlg = listaAlg;
    }

    public LinkedList<LinkedList<BCP>> getOrdemExecutados() {
        return ordemExecutados;
    }

    public void setOrdemExecutados(LinkedList<LinkedList<BCP>> ordemExecutados) {
        this.ordemExecutados = ordemExecutados;
    }

}
