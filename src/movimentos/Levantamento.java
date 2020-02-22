/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class Levantamento extends Movimento {

    public Levantamento(LocalDate dataMovimento, double valor) {
        super(dataMovimento, valor);
    }

    @Override
    public String toString() {
        return "LEV" + " " + getValor() + " " + getDataMovimento().toString();
    }
    
    
}
