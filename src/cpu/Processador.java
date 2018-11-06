/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import java.util.LinkedList;
import processo.BCP;

/**
 *
 * @author tuchinski
 */
public class Processador {

    public static int cicloIO = 2;

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
            Escalonador atual = listaAlg.get(i);
            LinkedList<BCP> listaAtualExecutados = new LinkedList<>();
            do {
                BCP p = atual.escalonar();
                int tempoExecutado;
                if (p != null) {
                    listaAtualExecutados.add(p);
                    if ((p.getTempoTotal() - quantum) < 0) {
                        tempoExecutado = p.getTempoTotal();
                        ciclo += p.getTempoTotal();
                    } else {
                        tempoExecutado = quantum;
                        ciclo += quantum;
                    }
                    p.setTempoTotal(p.getTempoTotal() - quantum);

                    if (p.getTempoTotal() <= 0) {
                        atual.getListaProcessos().remove(p);
                        atual.getListaAptos().remove(p);
                    }

                } else {
                    tempoExecutado = 1;
                    ciclo++;
                }
                decrementarBloqueados(atual, tempoExecutado);
                if (p != null && p.needBlock(ciclo)) {
                    int indexP = atual.returnIndexProcessoNaLista(p.getId(), atual.getListaAptos());
                    atual.listaBloqueado.add(atual.listaAptos.remove(indexP));
                }
            } while (!atual.getListaProcessos().isEmpty());
            ordemExecutados.add(listaAtualExecutados);
            Processador.ciclo = 0;
        }
    }

    private void decrementarBloqueados(Escalonador es, int tempoExecutado) {
        for (BCP p : es.getListaBloqueado()) {
            p.tempoIO -= tempoExecutado;
            if (p.tempoIO <= 0) {
                p.tempoIO = Processador.cicloIO;
                p.isBlocked = false;
                int indexP = es.returnIndexProcessoNaLista(p.getId(), es.listaBloqueado);
                es.listaAptos.add(es.listaBloqueado.remove(indexP));
            }
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
