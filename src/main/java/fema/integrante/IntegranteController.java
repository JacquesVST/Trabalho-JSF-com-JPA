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
	
	private Integrante integrante = new Integrante();
	private Banda banda = new Banda();
	private List<Banda> bandas = new ArrayList<Banda>();
	private Boolean showTable;
	@Inject
	private IntegranteDAO integranteDAO;
	@Inject
	private BandaDAO bandaDAO;

	public void addIntegrante() {
		try {
			this.showTable = false;
			this.banda = this.bandaDAO.findAll().stream()
					.filter(b -> b.getId().equals(this.banda.getId()))
					.findFirst()
					.get();
			this.integrante.setBanda(this.banda);
			this.integranteDAO.save(this.integrante);
			this.integrante = new Integrante();
			this.banda = new Banda();
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeIntegrante(Integrante integrante) {
		try {
			this.showTable = false;
			this.integranteDAO.delete(integrante);
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}

	public Boolean getShowTable() {
		return showTable;
	}

	public void setShowTable(Boolean showTable) {
		this.showTable = showTable;
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
