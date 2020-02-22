/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

import contasbancarias.Conta;
import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class Transferencia extends Movimento {
        
      Conta contaDestino; 
      
      public Transferencia(LocalDate dataMovimento, double valor, Conta contaDestino) {
        super(dataMovimento, valor);
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "TRF" + " " + getValor() + " Conta Destino: " + contaDestino.getNumero() + " "+ getDataMovimento().toString();
    }
    
}
