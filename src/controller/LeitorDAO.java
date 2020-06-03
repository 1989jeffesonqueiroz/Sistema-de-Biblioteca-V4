package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import model.Leitor;

public class LeitorDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    
 public void cadastrar(Leitor leitor) {
        String sql = "insert into leitor (nome, cpf, data_nascimento, telefone, email, rua, numero, bairro, cidade, cep, uf, id_login) \n" +
"VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,2)";
        
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, leitor.getNome()); 
            preparestatement.setString(2, leitor.getCpf());
            preparestatement.setDate(3, leitor.getDataNascimento());//converter
            preparestatement.setString(4, leitor.getTelefone());
            preparestatement.setString(5, leitor.getEmail());
            preparestatement.setString(6, leitor.getRua());
            preparestatement.setString(7, leitor.getNumero());
            preparestatement.setString(8, leitor.getBairro());
            preparestatement.setString(9, leitor.getCidade());
            preparestatement.setString(10, leitor.getCep());
            preparestatement.setString(11, leitor.getUf());
            //preparestatement.setInt(12, leitor.getId_login());
            
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void aleterar(Leitor leitor) {
        String sql = "UPDATE leitor SET nome = ?, cpf=?,data_nascimento= ?, telefone= ?,email= ?,rua= ?,numero= ?,bairro= ?,cidade=? ,cep= ?,uf=?, id_login=2 \n" +
"WHERE  id_leitor = ?";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
             preparestatement.setString(1, leitor.getNome()); 
            preparestatement.setString(2, leitor.getCpf());
            preparestatement.setDate(3, leitor.getDataNascimento());//converter
            preparestatement.setString(4, leitor.getTelefone());
            preparestatement.setString(5, leitor.getEmail());
            preparestatement.setString(6, leitor.getRua());
            preparestatement.setString(7, leitor.getNumero());
            preparestatement.setString(8, leitor.getBairro());
            preparestatement.setString(9, leitor.getCidade());
            preparestatement.setString(10, leitor.getCep());
            preparestatement.setString(11, leitor.getUf());
            preparestatement.setInt(13, leitor.getId_leitor());
            
           
            preparestatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Leitor leitor) {
        String sql = "DELETE FROM leitor WHERE id_leitor = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, leitor.getId_leitor());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
