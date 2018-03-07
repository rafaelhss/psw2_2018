/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafael
 */
import javax.persistence.*;

@Entity
public class Edicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private Livro livro;
    
    
    private int ano;
    private int tiragem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTiragem() {
        return tiragem;
    }

    public void setTiragem(int tiragem) {
        this.tiragem = tiragem;
    }
    
    
    
    
    
}
