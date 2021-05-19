package fema;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;

@SessionScoped
public class BandaDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private JpaManager jpaManager;

	@SuppressWarnings("unchecked")
	public List<Banda> getBandas() {
		String query = "select * from banda";
		Query consulta = jpaManager.getEntityManager().createNativeQuery(query, Banda.class);
		List<Banda> bandas = consulta.getResultList();
		return bandas;
	}
}
