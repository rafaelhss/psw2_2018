package backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	public MessageInRepository messageInRepository;
	
	@Autowired
	public MessageOutRepository messageOutRepository;
	
	
	
	@RequestMapping(value = "/texto/teste/{texto}", method = RequestMethod.GET)
	public Integer testaTexto(@PathVariable("texto") String texto) {
		MessageIn msgIn = new MessageIn();
		msgIn.setInfoIn(texto);
		msgIn = messageInRepository.save(msgIn);
		return msgIn.getId();
	}
	
	
	@RequestMapping(value = "/texto", method = RequestMethod.POST)
	public Integer processaTexto(@RequestBody String texto) {
		MessageIn msgIn = new MessageIn();
		msgIn.setInfoIn(texto);
		msgIn = messageInRepository.save(msgIn);
		return msgIn.getId();
	}
	
	@RequestMapping(value = "/texto/{id}", method = RequestMethod.GET)
	public MessageOut verificaTexto(@PathVariable("id") Integer id) {
		
		MessageOut msgOut = messageOutRepository.findByIdentificador(id);
		return msgOut;
	}
	
	
	

}
