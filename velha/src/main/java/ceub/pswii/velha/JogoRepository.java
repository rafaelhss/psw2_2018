/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceub.pswii.velha;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.soares
 */
public interface JogoRepository extends CrudRepository<Jogo, Integer>{

    public Iterable<Jogo> findByFinalizado(Boolean finalizado);
    
    public Jogo findByIdentificador(Integer identificador);
    
}
