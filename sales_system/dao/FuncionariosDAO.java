
package br.com.salessystem.dao;

import br.com.salessystem.jdbc.ConnectionFactory;
import br.com.salessystem.model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique
 */
public class FuncionariosDAO {
    
    //Connection Data Bank
    private Connection conn;
    
    public FuncionariosDAO(){
        this.conn = new ConnectionFactory().getConnection();
        //when creating a new obj the connection to BDSALES is made
    }
    
    //Method Cadastrar Funcionarios
    public void cadastrarFuncionarios(Funcionarios obj){
        
        try{
    
            //Command Sql create
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //connected database and organize the command sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            // Executing the command sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, " >> Registered Successfully << ");

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, " >> Erro << "+e);
        }
    }
     
}
