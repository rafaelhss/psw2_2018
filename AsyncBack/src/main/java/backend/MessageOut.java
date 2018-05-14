package backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageOut {
	
	@Id
	private Integer identificador;

	private String infoOut;
	


	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getInfoOut() {
		return infoOut;
	}

	public void setInfoOut(String infoOut) {
		this.infoOut = infoOut;
	}
	
	
}
