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

    private LinkedList<Escalonador> listaAlg;
    private LinkedList<BCP> ordemExecutados;
    public Processador(LinkedList<Escalonador> listaAlg){
        this.listaAlg = listaAlg;
        this.ordemExecutados = new LinkedList<>();
    }
    public void processar() {
        int size = listaAlg.size();
        for (int i = 0; i < size; i++) {
            Escalonador atual = listaAlg.get(i);
            while(!atual.terminou){
                atual.escalonar();
                
            }
            
        }
    }
}
