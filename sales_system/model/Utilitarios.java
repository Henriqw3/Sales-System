package br.com.salessystem.model;


import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author henrique
 */
public class Utilitarios {
    
    public void LimpaTela(JPanel container){
        //To clear fields in panel
        
        Component components[] = container.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }   
    }
}
