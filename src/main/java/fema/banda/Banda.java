package fema.banda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import fema.estilo.Estilo;
import fema.integrante.Integrante;

@Entity(name="banda")
public class Banda {
	
	@Id
	@SequenceGenerator(name = "sequence_banda", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_banda")
	private Integer id;
	private String nome;
	private String origem;
	
	@ManyToOne
	@JoinColumn(name = "id_estilo")
	private Estilo estilo;
	
	@OneToMany(mappedBy = "banda")
	private List<Integrante> integrantes = new ArrayList<>();
	
	public Banda() {
		
	}
	
	public Banda(String nome, String origem, Estilo estilo) {
		this.nome = nome;
		this.origem = origem;
		this.estilo = estilo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	public List<Integrante> getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}
	
	@Override
	public String toString() {
		return "---> " + id + " - " + nome + " - " + origem;
	}
	
}