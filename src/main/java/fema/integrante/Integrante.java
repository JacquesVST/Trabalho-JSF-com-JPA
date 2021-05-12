package fema.integrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import fema.banda.Banda;

@Entity(name="integrante")
public class Integrante {
	
	@Id
	@SequenceGenerator(name = "sequence_integrante", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_integrante")
	private Integer id;
	private String nome;
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@ManyToOne
    @JoinColumn(name = "id_banda")
	private Banda banda;
	
	public Integrante() {
		
	}
	
	public Integrante(String nome, String dataNascimento, Banda banda) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.banda = banda;
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Banda getBanda() {
		return banda;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	
	@Override
	public String toString() {
		return "---> " + id + " - " + nome + " - " + dataNascimento;
	}
	
}