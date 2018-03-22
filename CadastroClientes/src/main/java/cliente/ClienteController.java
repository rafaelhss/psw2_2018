package cliente;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.ArrayList;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class ClienteController {

    List<Cliente> clientes = gerarClientes();
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public void atualizarCliente(@PathVariable("id")Integer id,
                                 @RequestBody Cliente clienteNovo){
       
        for (Cliente cliente : clientes) {
            if(cliente.getId() == id){
                Cliente c = cliente;
                clientes.remove(cliente);
                
                if(clienteNovo.getDatanascimento() != null)
                    c.setDatanascimento(clienteNovo.getDatanascimento());
                
                if(clienteNovo.getNome() != null)
                    c.setNome(clienteNovo.getNome());
                
                if(clienteNovo.getSobrenome() != null)
                    c.setSobrenome(clienteNovo.getSobrenome());
                
                if(clienteNovo.getStatus() != null)
                    c.setStatus(clienteNovo.getStatus());
                
                clientes.add(c);
                
                
            }
        }
        
        
    }
    
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/cliente/{id}", method = RequestMethod.DELETE)
    public void deletarCliente(@PathVariable("id") Integer id){
        System.out.println("Estou removendo o id: " + id);
        for (Cliente cliente : clientes) {
            if(cliente != null && cliente.getId() == id){
                clientes.remove(cliente);
            }
        }
        
        boolean remove = clientes.remove(id); //TODO nao eh assim! corrigir
        System.out.println("size: " + clientes.size());
    }
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> listarClientes() {
        return clientes;
    }

    private List<Cliente> gerarClientes() {
        List<Cliente> resultado = new ArrayList<>();
        Cliente c1 = new Cliente();
        c1.setNome("Joao");
        c1.setSobrenome("dasCouvez");
        c1.setId(1);
        c1.setStatus("Ativo");
        c1.setDatanascimento("01/01/1992");
        resultado.add(c1);
        Cliente c2 = new Cliente();
        c2.setNome("Maria");
        c2.setSobrenome("dasCouvez");
        c2.setId(2);
        c2.setStatus("Ativo");
        c2.setDatanascimento("01/01/1990");
        resultado.add(c2);
        return resultado;
    }
}