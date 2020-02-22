/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Cliente {
    private String designacao;
    private int nif; 
    private String email; 
    private Date dataCriacaoCliente;

    public Cliente(String designacao, int nif, String email) {
        this.designacao = designacao;
        this.nif = nif;
        this.email = email; 
        
        dataCriacaoCliente = new Date();
    }
    
    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getNIF() {
        return nif;
    }

    public void setNIF(int nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCriacaoCliente() {
        return dataCriacaoCliente;
    }

    @Override
    public String toString() {
        return designacao + " NIF:" + nif + " " + email;
    }
    
    
    
    
}
