/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasbancarias;

import banco.Banco;
import java.util.*;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author Administrator
 */
public class ContaPrazo extends Conta {
    private LocalDate dataCriacaoMovimento;// dataUltimoDeposito
    private double taxaJuro;
    private boolean podeDepositar; 
    private long dias;
    
    public ContaPrazo(Banco b) {
        super(b);
        podeDepositar = true;
        taxaJuro = 0.0;
    }

    @Override
    public boolean depositar(double valor) {
        boolean estado = false;
        if ( podeDepositar )  { // o mesmo que if ( podeDepositar = true ) 
            super.depositar(valor);
            dataCriacaoMovimento = getBanco().getDataSistema();
            podeDepositar = false;
            estado = true;
        }
        
        return estado; 
    }

    public long getDias() {
        return dias;
    }

    
    @Override
    public boolean levantar(double valor) {
        
        boolean estado;
        
        //liquidar
        if ( valor != saldoAcumulado() ) {
            estado = false;
        }   else {
            podeDepositar = true;
            depositar(calculaJuros()); //  +100
            super.levantar(valor); // 1100
            podeDepositar = true;
            estado = true;
        }
        return estado;
    }
    
    public double saldoAcumulado() {
        return calculaJuros()+super.getSaldo();
    }
   
    private double calculaJuros() {
        dias = ChronoUnit.DAYS.between(dataCriacaoMovimento, getBanco().getDataSistema());
        return ( super.getSaldo() * pesquisaTaxaJuro(dias)  ) ; 
    }
   
    public double pesquisaTaxaJuro(long dias){
        // pesquisa intervalos de juro em função do número de dias
        taxaJuro = getBanco().getTabelaJuros().taxaJuro(dias);
        return taxaJuro;
    }
    public double getSaldo() {
        return saldoAcumulado();
    }
      @Override
    public String toString() {
        return "Conta #" + getNumero() + " " + saldoAcumulado() + "Tx. Juro=" + taxaJuro +" [" + dataCriacaoMovimento.toString() + "]";
    }


    
    
}
