package cliente;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.ArrayList;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class ClienteController {

    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public void atualizarCliente(@RequestBody Cliente clienteNovo){
        clienteRepository.save(clienteNovo);
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public void atualizarCliente(@PathVariable("id")Integer id,
                                 @RequestBody Cliente clienteNovo){
       
        Cliente c = clienteRepository.findOne(id);
        if(c != null) {

            if(clienteNovo.getDatanascimento() != null)
                c.setDatanascimento(clienteNovo.getDatanascimento());

            if(clienteNovo.getNome() != null)
                c.setNome(clienteNovo.getNome());

            if(clienteNovo.getSobrenome() != null)
                c.setSobrenome(clienteNovo.getSobrenome());

            if(clienteNovo.getStatus() != null)
                c.setStatus(clienteNovo.getStatus());

            clienteRepository.save(c);
        }
    }

        
        
    
    
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/cliente/{id}", method = RequestMethod.DELETE)
    public void deletarCliente(@PathVariable("id") Integer id){
        clienteRepository.deleteById(id); 
        
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public Iterable<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    
}