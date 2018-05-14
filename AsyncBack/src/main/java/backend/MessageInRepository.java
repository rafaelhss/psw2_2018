package backend;

import org.springframework.data.repository.CrudRepository;

public interface MessageInRepository extends CrudRepository<MessageIn, Integer>{
	public MessageIn findTop1By();
}
