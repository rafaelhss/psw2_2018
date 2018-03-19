package cliente;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ClienteController {

    @RequestMapping("/cliente")
	@CrossOrigin(origins = "*")
    public List<Cliente> listarClientes() {
        
		
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