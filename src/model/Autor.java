package model;

public class Autor {
    
    private int id_autor;
    private String nome;
    private int id_login;
    
    public Autor(){
        
    }

    public Autor(int id_autor, String nome, int id_login) {
        this.id_autor = id_autor;
        this.nome = nome;
        this.id_login = id_login;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }


   
}
