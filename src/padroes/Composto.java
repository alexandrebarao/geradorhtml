/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Composto extends Componente{
    ArrayList lista; 
    
    public Composto() {
        lista = new ArrayList();
    }
    
    
    public String getTexto() {
        String txt = "[" + super.getTexto() + "] ";
        for ( int i = 0; i < lista.size(); i++ ) {
            Componente c = (Componente) lista.get(i);
            
            txt+="\n   > "+ c.getTexto();
        }
        return txt;
    }
    
    
    public void adiciona(Componente c) {
        lista.add(c);
    }
}
