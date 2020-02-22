/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import contasbancarias.Conta;
import entidades.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import juros.IntervaloJuros;
import juros.TabelaJuros;
import padroes.Componente;
import padroes.Composto;
import padroes.Elemento;

/**
 *
 * @author Administrator
 */
public class Banco {
    
    static Banco  banco;
    
    private  LocalDate dataSistema;
    private List<Cliente> listaClientes;
    private TabelaJuros tabelaJuros;
    private List<Conta> listaContas;
     
     
    private Banco() {
          banco = null;
//        Date d = new Date();
//        dataSistema = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
          dataSistema = LocalDate.now();
          listaClientes = new ArrayList<>();
          listaContas = new ArrayList<>();
          tabelaJuros = new TabelaJuros();
          tabelaJuros.getListaIntervalos().add(new IntervaloJuros(1,30,0.01));
          tabelaJuros.getListaIntervalos().add(new IntervaloJuros(31,60,0.02));
          tabelaJuros.getListaIntervalos().add(new IntervaloJuros(61,180,0.03));
          tabelaJuros.getListaIntervalos().add(new IntervaloJuros(181,365,0.1));
          
    }

    public static Banco getInstance() {
        if ( banco != null) {
            return banco;
        } 
        banco = new Banco();
        return banco;
    }
    public String consultaContasClientes() {
        // padrão composto
        
        String consulta = "";
        
        for ( int i = 0 ; i<listaContas.size();i++ ) {
            consulta+="\n";
            Conta c = listaContas.get(i);
            Composto comp = new Composto();
            comp.setTexto(c.toString());
            
            for ( int j = 0 ; j < c.getListaClientes().size(); j++ ) {
                Cliente cli = getListaClientes().get(j);
                Elemento elemento = new Elemento();
                elemento.setTexto(cli.toString());
                comp.adiciona(elemento);
            }
            
            consulta+=comp.getTexto();
        }
        
        return consulta;
    }

    
    
    public List<Conta> getListaContas() {
        return listaContas;
    }

    public double totalSaldos() {
        double total = 0.0;
        
        for ( int i = 0; i < listaContas.size(); i++ ) {
            Conta c = listaContas.get(i);
            total+=c.getSaldo();
        }
        return total;
    }
    
    public double mediaSaldos() {
        return totalSaldos() / listaContas.size();
    }
    
    
    public TabelaJuros getTabelaJuros() {
        return tabelaJuros;
    }

    public LocalDate getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(int ano, int mes, int dia) {
        dataSistema = LocalDate.of(ano, mes, dia);
        
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

   
    
}
