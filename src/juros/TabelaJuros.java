/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juros;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TabelaJuros {
    private List<IntervaloJuros> listaIntervalos;
    
    public TabelaJuros() {
        listaIntervalos = new ArrayList<>(); 
    }

    public List<IntervaloJuros> getListaIntervalos() {
        return listaIntervalos;
    }
    
    public double taxaJuro(long numeroDias) {

        double t=1.0; 
        
        for (int i = 0; i< listaIntervalos.size(); i++ ) {
            
            long li = listaIntervalos.get(i).getDiasInicial();
            long lf = listaIntervalos.get(i).getDiasFinal();
            t = listaIntervalos.get(i).getTaxaJuro();
//            System.out.println("Taxa juro criação " + t);
            if ( numeroDias >= li && numeroDias <= lf ) {
                break;
            }
          
        }
//        System.out.println("Taxa juro escolhida " + t);      
        return t;
    }
    
}
