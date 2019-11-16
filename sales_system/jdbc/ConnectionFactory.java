package br.com.salessystem.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author henrique
 */
public class ConnectionFactory { 
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/BDSALES","groot","groot123");
        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}
