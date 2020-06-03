package model;

import java.util.ArrayList;

public class Livro {
    
    private String titulo;
    private String autor;
    private String editora;
    private String anoedicao;
    private int volume;
    //private ArrayList<Autor> listaAutor = new ArrayList<Autor>();
   // private ArrayList<Editora> listaEditora = new ArrayList<Editora>();

    public Livro(String titulo, String autor, String editora, String anoedicao, int volume) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoedicao = anoedicao;
        this.volume = volume;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoedicao() {
        return anoedicao;
    }

    public void setAnoedicao(String anoedicao) {
        this.anoedicao = anoedicao;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    
    
}
