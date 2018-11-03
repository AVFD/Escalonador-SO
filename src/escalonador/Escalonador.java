/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.util.LinkedList;
import processo.BCP;

/**
 *
 * @author augusto
 */
public abstract class Escalonador {
    LinkedList<String> listaBloqueado;
    
    abstract public void escalonar();
    
    abstract public void ordenar();
    
}
