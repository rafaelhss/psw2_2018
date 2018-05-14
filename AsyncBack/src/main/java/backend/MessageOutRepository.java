package backend;

import org.springframework.data.repository.CrudRepository;

public interface MessageOutRepository extends CrudRepository<MessageOut, Integer>{

	MessageOut findByIdentificador(Integer id);

}
