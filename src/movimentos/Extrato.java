/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Extrato {
    List<Movimento> extracto;
    
    public Extrato() {
        extracto = new ArrayList<>();
    }
    
    public void adicionaMovimento(Movimento movimento) {
        extracto.add(movimento);
    }

    @Override
    public String toString() {
        String txt = "";
        for ( int i = 0; i<extracto.size(); i++ ) {
            Movimento m = extracto.get(i);
            txt += "\n" + m.toString();
        }
        return txt;
    }
    
    
}
