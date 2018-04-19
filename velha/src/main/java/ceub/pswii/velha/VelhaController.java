/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael.soares
 */
@RestController
public class VelhaController {
    
    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private JogadaRepository jogadaRepository;
    
    
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos", method = RequestMethod.POST)
    public Jogo criarJogo(@RequestBody Jogo jogo){
        return jogoRepository.save(jogo);
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos", method = RequestMethod.GET)
    public Iterable<Jogo> listarJogos(@RequestParam(value = "finalizado", 
            defaultValue = "false") Boolean finalizado){
        if(finalizado == true){
            return jogoRepository.findByFinalizado(finalizado);
        } else {
            return jogoRepository.findAll();
        }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos/{id}", method = RequestMethod.GET)
    public Jogo buscarJogo(@PathVariable(value = "id") Integer identificador){
        return jogoRepository.findByIdentificador(identificador);
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST
                    , value = "/jogos/{id}/jogadas")
    public Jogada criarJogada(@PathVariable("id") Integer idJogo,
                              @RequestBody Jogada jogada){
        
        Jogo jogo = jogoRepository.findByIdentificador(idJogo);
        if(jogo != null){
            if(jogo.getJogadas() == null){
                jogo.setJogadas(new ArrayList<Jogada>());
            }
            
            if(!jogo.isFinalizado()){
                if(jogo.getVez() == null || 
                    jogo.getVez().equals("") ||
                    jogo.getVez().equals(jogada.getJogador())){
                
                        jogada = jogadaRepository.save(jogada);
                        jogo.getJogadas().add(jogada);

                        if(jogada.getJogador().equals(jogo.getJogador1())){
                            jogo.setVez(jogo.getJogador2());
                        } else {
                            jogo.setVez(jogo.getJogador1());
                        }
                        
                        jogoRepository.save(jogo);
                }
            }
        }
        
        return null;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/jogos/{id}")
    public void deletarJogo(@PathVariable("id") Integer idJogo){
        jogoRepository.deleteById(idJogo);
    }
    
    
    
}
