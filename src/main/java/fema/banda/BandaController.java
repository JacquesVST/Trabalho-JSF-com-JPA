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

	private Banda banda = new Banda();
	private Estilo estilo = new Estilo();
	private List<Estilo> estilos = new ArrayList<Estilo>();
	private Boolean showTable;
	@Inject
	private BandaDAO bandaDAO;
	@Inject
	private EstiloDAO estiloDAO;

	public void addBanda() {
		try {
			this.showTable = false;
			this.estilo = this.estiloDAO.findAll().stream().filter(e -> e.getId().equals(this.estilo.getId()))
					.findFirst().get();
			this.banda.setEstilo(this.estilo);
			this.bandaDAO.save(this.banda);
			this.banda = new Banda();
			this.estilo = new Estilo();
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBanda(Banda banda) {
		try {
			this.showTable = false;
			this.bandaDAO.delete(banda);
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<Estilo> getEstilos() {
		return estilos;
	}

	public void setEstilos(List<Estilo> estilos) {
		this.estilos = estilos;
	}

	public Boolean getShowTable() {
		return showTable;
	}

	public void setShowTable(Boolean showTable) {
		this.showTable = showTable;
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
