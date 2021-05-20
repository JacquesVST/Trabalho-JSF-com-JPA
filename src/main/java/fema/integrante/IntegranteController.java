package fema.integrante;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fema.banda.Banda;
import fema.banda.BandaDAO;

@Named
@SessionScoped
public class IntegranteController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integrante> integrantes = new ArrayList<Integrante>();

	private Integrante integrante = new Integrante();
	private Banda banda = new Banda();

	private Boolean mostrarTabela = true;

	@Inject
	private IntegranteDAO integranteDAO;
	@Inject
	private BandaDAO bandaDAO;

	public void listarIntegrantes() {
		try {
			this.mostrarTabela = false;
			this.integrantes = this.integranteDAO.getIntegrantes();
			this.mostrarTabela = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarIntegrante() {
		try {
			this.mostrarTabela = false;
			this.banda = this.bandaDAO.getBandas().stream().filter(b -> b.getId().equals(this.banda.getId()))
					.findFirst().get();
			this.integrante.setBanda(this.banda);
			this.integranteDAO.save(this.integrante);
			this.integrante = new Integrante();
			this.banda = new Banda();
			this.mostrarTabela = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerIntegrante(Integrante integrante) {
		try {
			this.mostrarTabela = false;
			this.integranteDAO.delete(integrante);
			this.mostrarTabela = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Integrante> getIntegrantes() {
		this.listarIntegrantes();
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Boolean getMostrarTabela() {
		return mostrarTabela;
	}

	public void setMostrarTabela(Boolean mostrarTabela) {
		this.mostrarTabela = mostrarTabela;
	}

	public IntegranteDAO getIntegranteDAO() {
		return integranteDAO;
	}

	public void setIntegranteDAO(IntegranteDAO integranteDAO) {
		this.integranteDAO = integranteDAO;
	}

	public BandaDAO getBandaDAO() {
		return bandaDAO;
	}

	public void setBandaDAO(BandaDAO bandaDAO) {
		this.bandaDAO = bandaDAO;
	}

}
