package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    
    private final Connection con = ConexaoBD.Conectar();
    
 public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, senha, tipo, id_login) values (?,?,?,2)";
     //id_login iserir no direto do comando
        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, usuario.getNome());
            preparestatement.setString(2, usuario.getSenha());
            preparestatement.setString(3, usuario.getTipo());
            //executando comando sql
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 
    public void excluir(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE nome = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
