/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha.jkp;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael.Soares
 */
@RestController
public class JkpController {
    private int TESOURA = 0;
    private int PAPEL = 1;
    private int PEDRA = 2;
    private int SPOCK = 3;
    private int LAGARTO = 4;
    
    @Autowired
    private JogoJkpRepository jkpRepository;
    
    @RequestMapping(value="/jogador/{nome}/jogos", method = RequestMethod.POST)
    public void criarJogo(@PathVariable("nome") String nome,
                            @RequestBody JogoJkp jogo){
        
        Integer jogadaServidor = new Random().nextInt(4);
        
        if(jogo.getJogada() == TESOURA // Tesoura
                && jogadaServidor == PAPEL){ // Tesoura
            jogo.setVitoria(true);
        }
        
        jkpRepository.save(jogo);
        
        
        
        
        
    }
    
    
}
