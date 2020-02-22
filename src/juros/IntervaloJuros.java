/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juros;

/**
 *
 * @author Administrator
 */
public class IntervaloJuros {
    private long diasInicial;
    private long diasFinal; 
    private double taxaJuro;
    
    public IntervaloJuros(long diasInicial, long diasFinal, double taxaJuro) {
        this.diasInicial = diasInicial;
        this.diasFinal = diasFinal;
        this.taxaJuro = taxaJuro;
    }

    public long getDiasInicial() {
        return diasInicial;
    }

    public long getDiasFinal() {
        return diasFinal;
    }

    public double getTaxaJuro() {
        return taxaJuro;
    }
    
    
}
