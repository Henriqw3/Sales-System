package br.com.salessystem.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
/**
 *
 * @author henrique
 */
public class ConnectionTest {
    public static void main(String[]args){
        try{
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, ">> Successful Connection <<");
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, ">> Connection Error <<"+erro);
        }
    }
}
