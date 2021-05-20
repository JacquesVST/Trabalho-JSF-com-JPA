package fema.estilo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class EstiloController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Estilo> estilos = new ArrayList<Estilo>();
	
	private Estilo estilo = new Estilo();
	
	private Boolean mostrarTabela = true;
	
	@Inject
	private EstiloDAO estiloDAO;
	
	public void listarEstilos() {
		try {
			this.mostrarTabela = false;
			estilos = this.estiloDAO.getEstilos();
			this.mostrarTabela = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarEstilo() {
		try {
			this.mostrarTabela = false;
			this.estiloDAO.save(estilo);
			this.estilo = new Estilo();
			this.mostrarTabela = true;
			this.listarEstilos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerEstilo(Estilo estilo) {
		try {
			this.mostrarTabela = false;
			this.estiloDAO.delete(estilo);
			this.mostrarTabela = true;
			this.listarEstilos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Estilo> getEstilos() {
		this.listarEstilos();
		return estilos;
	}


	public void setEstilos(List<Estilo> estilos) {
		this.estilos = estilos;
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

	public EstiloDAO getEstiloDAO() {
		return estiloDAO;
	}

	public void setEstiloDAO(EstiloDAO estiloDAO) {
		this.estiloDAO = estiloDAO;
	}

}
