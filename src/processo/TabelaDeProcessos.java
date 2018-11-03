/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processo;

import java.util.LinkedList;
import leituraArquivo.LerArquivo;

/**
 *
 * @author guilherme
 */
public class TabelaDeProcessos {

    public static TabelaDeProcessos tp = null;
    LinkedList<BCP> tabelaDeProcesso;

    public TabelaDeProcessos() {
        this.tabelaDeProcesso = new LinkedList<>();
    }

    public static TabelaDeProcessos getInstance() {
        if (tp == null) {
            tp = new LerArquivo().lerArquivo();
        }
        return tp;
    }

    public LinkedList<BCP> getTabelaDeProcesso() {
        return tabelaDeProcesso;
    }

    public void setTabelaDeProcesso(LinkedList<BCP> tabelaDeProcesso) {
        this.tabelaDeProcesso = tabelaDeProcesso;
    }

}
