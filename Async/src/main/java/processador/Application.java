package processador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

	}

	@Autowired
	private MessageOutRepository messageOutRepository;
	
	@Autowired 
	private MessageInRepository messageInRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Processando...");
		
		MessageIn messageIn = null;
		do {
			messageIn = messageInRepository.findTop1();
			//Thread.sleep(100);
		} while (messageIn == null);
		
		MessageOut messageOut = processar(messageIn);
		
		messageOutRepository.save(messageOut);
		
	}

	private MessageOut processar(MessageIn messageIn) {
		MessageOut resposta = new MessageOut();
		resposta.setInfoOut(converter(messageIn.getInfoIn()));
		return resposta;
	}
	
	public String converter(String texto) {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("z", "p");
        map.put("e", "o");
        map.put("n", "l");
        map.put("i", "a");
        map.put("t", "r");
        map.put("p", "z");
        map.put("o", "e");
        map.put("l", "n");
        map.put("a", "i");
        map.put("r", "t");
        map.put("Z", "P");
        map.put("E", "O");
        map.put("N", "L");
        map.put("I", "A");
        map.put("T", "R");
        map.put("P", "Z");
        map.put("O", "E");
        map.put("L", "N");
        map.put("A", "I");
        map.put("R", "T");
        
              
        String letras[] = texto.split("");
        
        
        String textoConvertido = "";
        
        for (String letra : letras) {
            String code = map.get(letra);
            if (code != null)
                textoConvertido = textoConvertido + code;
            else
                textoConvertido = textoConvertido + letra;
        }
        
        return textoConvertido;
    } 

}
