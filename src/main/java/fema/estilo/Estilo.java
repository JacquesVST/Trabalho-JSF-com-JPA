package fema.estilo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import fema.banda.Banda;

@Entity(name="estilo")
public class Estilo {
	
	@Id
	@SequenceGenerator(name = "sequence_estilo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_estilo")
	private Integer id;
	private String nome;
	private String bpm;
	
	@OneToMany(mappedBy = "estilo")
	private List<Banda> bandas = new ArrayList<>();
	
	public Estilo() {
		
	}
	
	public Estilo(String nome, String bpm) {
		this.nome = nome;
		this.bpm = bpm;
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
	public String getBpm() {
		return bpm;
	}
	public void setBpm(String bpm) {
		this.bpm = bpm;
	}
	public List<Banda> getBandas() {
		return bandas;
	}
	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}
	
	@Override
	public String toString() {
		return "---> " + id + " - " + nome + " - " + bpm;
	}
	
}