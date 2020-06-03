package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Livro;

public class LivroDAO {
    
     private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Livro livro) {
        //String sql = "insert into livro (nome, id_login) values(?,2)";
     String sql = "insert into livro (titulo, volume, ano, id_login, id_editora,id_autor) values (?, ?,?,2,?,?)";
     //id_login iserir no direto do comando
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, livro.getTitulo());
            preparestatement.setInt(2, livro.getVolume());
            preparestatement.setString(3, livro.getAnoedicao());
            preparestatement.setString(5, livro.getAutor());
            preparestatement.setString(6, livro.getEditora());
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void aleterar(Livro livro) {
        String sql = "update livro set titulo = ? AND autor ? AND editora = ? AND ano = ? AND volume = ?";// não sei como fazer para chamar o id_editora
      
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
            preparestatement.setString(1, livro.getTitulo());
            preparestatement.setString(2, livro.getAutor());
            preparestatement.setString(3, livro.getEditora());
            preparestatement.setString(4, livro.getAnoedicao());
            preparestatement.setInt(5, livro.getVolume());
           
            preparestatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Livro livro) {
        String sql = "DELETE from livro WHERE titulo = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
