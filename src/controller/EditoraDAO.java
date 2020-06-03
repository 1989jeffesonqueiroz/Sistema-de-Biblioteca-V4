package controller;

import java.sql.*;
import model.Editora;


public class EditoraDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Editora editora) {
        String sql = "insert into editora (nome)values(?)";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, editora.getNome()); 
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void alterar(Editora editora) {
        String sql = "UPDATE editora SET nome = ? WHERE id_editora = ?";// não sei como fazer para chamar o id_editora
       
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.setInt(2, editora.getId_editora());
            
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Editora editora) {
        String sql = "delete from editora where nome = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
