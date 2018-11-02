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
public class TabelaDeProcessos {
    LinkedList<BCP> tabelaDeProcesso;

    public LinkedList<BCP> getTabelaDeProcesso() {
        return tabelaDeProcesso;
    }

    public void setTabelaDeProcesso(LinkedList<BCP> tabelaDeProcesso) {
        this.tabelaDeProcesso = tabelaDeProcesso;
    }
    
}
