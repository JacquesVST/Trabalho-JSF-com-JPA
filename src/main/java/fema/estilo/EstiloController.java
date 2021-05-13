package fema.estilo;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class EstiloController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estilo estilo = new Estilo();
	private Boolean showTable;
	@Inject
	private EstiloDAO estiloDAO;

	public void addEstilo() {
		try {
			this.showTable = false;
			this.estiloDAO.save(estilo);
			this.estilo = new Estilo();
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEstilo(Estilo estilo) {
		try {
			this.showTable = false;
			this.estiloDAO.delete(estilo);
			this.showTable = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Boolean getShowTable() {
		return showTable;
	}

	public void setShowTable(Boolean showTable) {
		this.showTable = showTable;
	}

	public EstiloDAO getEstiloDAO() {
		return estiloDAO;
	}

	public void setEstiloDAO(EstiloDAO estiloDAO) {
		this.estiloDAO = estiloDAO;
	}

}
