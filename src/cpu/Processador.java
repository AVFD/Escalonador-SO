/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import algoritmos.RoundRobin;
import algoritmos.Sjf;
import java.util.LinkedList;

/**
 *
 * @author tuchinski
 */
public class Processador {

    private LinkedList<Escalonador> listaAlg;
    
    public Processador(LinkedList<Escalonador> listaAlg){
        this.listaAlg = listaAlg;
    }
    public void processar() {
        int size = listaAlg.size();
        for (int i = 0; i < size; i++) {
            
            
        }
    }
}
