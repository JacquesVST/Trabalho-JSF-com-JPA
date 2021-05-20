package fema;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Controlador implements Serializable {

	private static final long serialVersionUID = 1L;

	public String irParaPagina(String pagina) {
		return pagina;
	}

}
