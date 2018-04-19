/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha.jkp;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rafael.Soares
 */
public interface JogoJkpRepository extends CrudRepository<JogoJkp, Integer>{
    //public JogoJkp findByIdentificador(Integer id);
    
    //public List<JogoJkp> findByNomeJogadorAndVitoriaOrderByNomeJogador(String nome, boolean v);
}
