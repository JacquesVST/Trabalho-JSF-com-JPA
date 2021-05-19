package fema.banda;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import fema.JpaManager;

@SessionScoped
public class BandaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private JpaManager jpaManager;

	@SuppressWarnings("unchecked")
	public List<Banda> getBandas() throws SQLException {
		String query = "select * from banda";
		Query consulta = jpaManager.getEntityManager().createNativeQuery(query, Banda.class);
		List<Banda> bandas = consulta.getResultList();
		return bandas;
	}

	public Banda findById(Integer id) throws SQLException {
		return jpaManager.getEntityManager().find(Banda.class, id);
	}

	public void save(Banda banda) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().persist(banda);
		jpaManager.getEntityManager().getTransaction().commit();
	}

	public void delete(Banda banda) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().remove(banda);
		jpaManager.getEntityManager().getTransaction().commit();
	}
}
