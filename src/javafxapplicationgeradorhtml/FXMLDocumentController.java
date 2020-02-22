/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationgeradorhtml;

import banco.Banco;
import contasbancarias.ContaPrazo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import juros.SimuladorJuros;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {
    
    private Banco banco;
    private ContaPrazo cp;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        SimuladorJuros s = new SimuladorJuros(banco, cp);
        s.geraHTML();
        
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        banco = Banco.getInstance();
        cp = new ContaPrazo(banco);
       
                
        cp.depositar(1000);
        banco.setDataSistema(2020, 8, 1);
     
        
        
    }    
    
}
