/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha.jkp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rafael.Soares
 */
@Entity
public class JogoJkp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    
    private String nomeJogador;
    
    private boolean vitoria;
    
    private Integer jogada;

    public Integer getJogada() {
        return jogada;
    }

    public void setJogada(Integer jogada) {
        this.jogada = jogada;
    }

    
    
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }
    
    
    
    
    
}
