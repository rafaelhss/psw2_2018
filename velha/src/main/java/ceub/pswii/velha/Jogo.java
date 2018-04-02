/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rafael.soares
 */
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private String jogador1;
    private String jogador2;
    private boolean finalizado;
    private String vez;

    public String getVez() {
        return vez;
    }

    public void setVez(String vez) {
        this.vez = vez;
    }
    

    
    
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
    
    
    
    
    @OneToMany
    private List<Jogada> jogadas;

  
    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public List<Jogada> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Jogada> jogadas) {
        this.jogadas = jogadas;
    }
    
    
}