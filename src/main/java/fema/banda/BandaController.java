package fema.banda;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fema.estilo.Estilo;
import fema.estilo.EstiloDAO;

@Named
@SessionScoped
public class BandaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Banda> bandas = new ArrayList<Banda>();

	private Banda banda = new Banda();
	private Estilo estilo = new Estilo();

	private Boolean mostrarTabela = true;

	@Inject
	private BandaDAO bandaDAO;
	@Inject
	private EstiloDAO estiloDAO;

	public void listarBandas() {
		try {
			this.mostrarTabela = false;
			bandas = this.bandaDAO.getBandas();
			this.mostrarTabela = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarBanda() {
		try {
			this.mostrarTabela = false;
			this.estilo = estiloDAO.getEstilos().stream().filter(e -> e.getId().equals(this.estilo.getId())).findFirst()
					.get();
			this.banda.setEstilo(this.estilo);
			this.bandaDAO.save(banda);
			this.banda = new Banda();
			this.estilo = new Estilo();
			this.mostrarTabela = true;
			this.listarBandas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerBanda(Banda banda) {
		try {
			this.mostrarTabela = false;
			this.bandaDAO.delete(banda);
			this.mostrarTabela = true;
			this.listarBandas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Banda> getBandas() {
		this.listarBandas();
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Boolean getMostrarTabela() {
		return mostrarTabela;
	}

	public void setMostrarTabela(Boolean mostrarTabela) {
		this.mostrarTabela = mostrarTabela;
	}

	public BandaDAO getBandaDAO() {
		return bandaDAO;
	}

	public void setBandaDAO(BandaDAO bandaDAO) {
		this.bandaDAO = bandaDAO;
	}

	public EstiloDAO getEstiloDAO() {
		return estiloDAO;
	}

	public void setEstiloDAO(EstiloDAO estiloDAO) {
		this.estiloDAO = estiloDAO;
	}
}
