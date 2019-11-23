/**
 *
 * @author henrique
 */

package br.com.salessystem.dao;

import br.com.salessystem.jdbc.ConnectionFactory;
import br.com.salessystem.model.Clientes;
import br.com.salessystem.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.awt.List;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientesDAO {
    
    //Connection Data Bank
    private Connection conn;
    //Methods
    
    public ClientesDAO(){
        this.conn = new ConnectionFactory().getConnection();
        //when creating a new obj the connection to BDSALES is made
    }
    
    public void cadastrarCliente(Clientes obj){
        
        try{
    
            //Command Sql create
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //connected database and organize the command sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            // Executing the command sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " >> Registered Successfully << ");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, " >> Erro << "+e);
        }
    }
    public void alterarCliente(Clientes obj){
        
        try{
    
            //Command Sql create
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,"
                    + "cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //connected database and organize the command sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            // Executing the command sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " >> Altered Successfully << ");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, " >> Erro << "+e);
        }
    }
    
    
    public void excluirCliente(Clientes obj){
        
        try{
    
            //Command Sql create
            String sql = "delete from tb_clientes where id = ?";

            //connected database and organize the command sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            // Executing the command sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " >> Successfully Deleted << ");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, " >> Erro << "+e);
        }
    }

    /**
     *
     * @return list of objects model clients data
     */
    public List<Clientes> listarClientes(){
        
        try {
            //creating list
            List<Clientes> lista;
            lista = new ArrayList<>();
            
            //creating command sql, organizing and running
            String sql = "select * from tb_clientes";
            //to execute
            PreparedStatement stmt = conn.prepareStatement(sql);
            //to receive after execute
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){//while he can go through the registries
                Clientes obj = new Clientes();
                //take datas and put in a obj model client
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                //adiciona o objeto a lista
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException error) {
            
            JOptionPane.showMessageDialog(null," Erro >> "+error);
            return null;
        }
    }
    
    public List<Clientes> buscaClientePorNome(String nome){
        
        try {
            //creating list
            List<Clientes> lista;
            lista = new ArrayList<>();
            
            //creating command sql, organizing and running
            String sql = "select * from tb_clientes where nome like ?";
            //to execute
            PreparedStatement stmt = conn.prepareStatement(sql);
            //to receive after execute
            stmt.setString(1, nome);// in ? = indice 1,  set nome
            ResultSet rs = stmt.executeQuery();
            
             
            
            return lista;
            
        } catch (SQLException error) {
            
            JOptionPane.showMessageDialog(null," Erro >> "+error);
            return null;
        }
    }
        
    public Clientes consultaPorNome(String nome){
        
        try {
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            //to execute
            ResultSet rs = stmt.executeQuery();    
            Clientes obj = new Clientes();    

            if(rs.next()){//if there someone take

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Client not found!");
            return null;
        }
    }
    
    //Busca CEP
    public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
