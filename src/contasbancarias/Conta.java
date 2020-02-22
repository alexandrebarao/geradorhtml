/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasbancarias;
import banco.*;
import entidades.Cliente;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import movimentos.Deposito;
import movimentos.Extrato;
import movimentos.Levantamento;

/**
 *
 * @author Administrator
 */
public abstract class Conta {
    private Banco banco;
    private static int proximoNumero = 0;
    private int numero;
    private double saldo;
    private Date dataCriacaoConta;
    
    private Extrato extrato;
    
    private List<Cliente> listaClientes;
    
    // Extracto
    
    public Conta(Banco b) {
        banco = b;
        ++proximoNumero;
        numero = proximoNumero;
        
        dataCriacaoConta = new Date();
        extrato = new Extrato();
        listaClientes = new ArrayList<>(); 
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public Banco getBanco() {
        return banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean levantar(double valor) {
        boolean estado = true;
        
        if ( valor <= getSaldo() ) {
            saldo-=valor;
            extrato.adicionaMovimento(new Levantamento(getBanco().getDataSistema(), valor));
        }
        
        
        return estado;
    }
    
    public boolean depositar (double valor) {
        saldo+=valor;
        extrato.adicionaMovimento(new Deposito(getBanco().getDataSistema(), valor));
        return true;
    }
    
    
    /**
     * @param aProximoNumero the proximoNumero to set
     */
    
    // Por causa da leitura BD
    public static void setProximoNumero(int aProximoNumero) {
        proximoNumero = aProximoNumero;
    }

//    Overkill uma vez que se pode fazer tudo a partir do método getListaClientes
//    public void adicionaCliente(Cliente cliente) {
//        listaClientes.add(cliente);
//    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public boolean removerCliente(int nif) { // desassociar cliente
        boolean estado = false; 
        
        for (int i = 0 ; i < listaClientes.size(); i++ ) {
            if (  listaClientes.get(i).getNIF() == nif ) {
                estado = true; 
                listaClientes.remove(i); 
                break;
            }
        }
        
        return estado;
    }
    
    @Override
    public String toString() {
        return "Conta #" + numero + " " + getSaldo() + " [" + dataCriacaoConta.toString() + "]";
    }

    public Date getDataCriacaoConta() {
        return dataCriacaoConta;
    }


    
    
}
