package controller;

//import com.sun.jndi.ldap.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Autor;

public class AutorDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public AutorDAO(){
    
       //ABRIR CONEXÃO COM O BANCO DE DADOS
       this.con = ConexaoBD.Conectar();
   }
    
    public int inserir(Autor a){
        try {
            String sql = "insert into autor (nome, id_login) values (?,2)";
            
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// REFERENCIA A CONEXÃO
            
            cmd.setString(1, a.getNome());
            //cmd.setInt(2, a.getId_login());
            
            if(cmd.executeUpdate() > 0){
                ResultSet rs = cmd.getGeneratedKeys();
                return (rs.next()) ? rs.getInt(1): -1;
            }else{
                return -1;
            }
            
        } catch (SQLException e) {
            System.out.println("ERRO SQL" + e.getMessage());
        }finally{
        ConexaoBD.Desconectar(con);//FECHAR CONEXÃO
    }
        return 0;
        
    }
    
     public void alterar(Autor a) {
        String sql = "UPDATE autor SET nome = ? where = id_autor = ?";// não sei como fazer para chamar o id_editora
       
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, a.getNome());
            preparedStatement.setInt(2, a.getId_autor());
            
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Autor a) {
        String sql = "delete from autor where nome = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, a.getNome());
            
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
