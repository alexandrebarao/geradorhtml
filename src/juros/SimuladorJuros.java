/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juros;

import banco.Banco;
import contasbancarias.ContaPrazo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class SimuladorJuros {

    Banco banco;
    ContaPrazo prazo;
    String valorInicial;

    public SimuladorJuros(Banco b, ContaPrazo p) {
        banco = b;
        prazo = p;
        valorInicial = "1000";
        prazo.getSaldo(); // obrigar a atualizar os dias..
    }

    public void geraHTML() throws FileNotFoundException, IOException {

        StringBuilder sb = new StringBuilder();
        int i = 1;

        BufferedReader br = new BufferedReader(new FileReader("./src/templates/tabela.html"));
        try {

            String line = br.readLine();

            while (line != null) {

                switch (i) {
                    
                    case 45:

                        sb.append("<td>" + valorInicial + "&euro;</td>");
                        break;

                    case 46:
                        sb.append("<td>" + prazo.getDias() + " </td>");
                        break;
                    case 47:
                        sb.append("<td>" + prazo.getSaldo() + "&euro;</td>");
                        break;
                    case 48:
                        sb.append("<td>" + prazo.pesquisaTaxaJuro(prazo.getDias()) + "%</td>");
                        break;
//
                    case 65:
                        
                        for (int j = 0; j < banco.getTabelaJuros().getListaIntervalos().size(); j++) {
                            IntervaloJuros ij = banco.getTabelaJuros().getListaIntervalos().get(j);
                            sb.append("<tr>");
                            sb.append("<td>" + ij.getDiasInicial() + "</td>");
                            sb.append("<td>" + ij.getDiasFinal() + "</td>");
                            sb.append("<td>" + ij.getTaxaJuro() + "</td>");
                            sb.append("</tr>");
                        }
                        
                       // sb.append(System.lineSeparator());
                        break;

                    case 66:case 67: case 68: case 69: break;
                    default:
                      //  if ( i < 65 && i > 69) {
                            sb.append(line);
                       // } 
                }

                sb.append(System.lineSeparator());
                line = br.readLine();
                ++i;
            }
            String documentoHTML = sb.toString();
            // System.out.println(documentoHTML);
        } finally {
            br.close();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./src/simulacoeshtml/simulacao.html"));
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
