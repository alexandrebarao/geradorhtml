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
public abstract class Movimento {
    
    private LocalDate dataMovimento;
    private double valor;

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public double getValor() {
        return valor;
    }
    
    public Movimento(LocalDate dataMovimento, double valor) {
        this.dataMovimento = dataMovimento;
        this.valor = valor;
    }
    
}
