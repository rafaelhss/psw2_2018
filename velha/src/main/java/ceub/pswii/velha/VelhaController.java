/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    
    
}
