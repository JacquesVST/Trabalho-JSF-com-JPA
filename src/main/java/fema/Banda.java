package fema;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banda {
	
	@Id
	private Integer id;
	
	private String nome;
	
	private String anoInicio;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
