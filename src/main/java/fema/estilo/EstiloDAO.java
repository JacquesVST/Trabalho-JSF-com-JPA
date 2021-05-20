package fema.estilo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import fema.JpaManager;

@SessionScoped
public class EstiloDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private JpaManager jpaManager;

	@SuppressWarnings("unchecked")
	public List<Estilo> getEstilos() throws SQLException {
		String query = "select * from estilo";
		Query consulta = jpaManager.getEntityManager().createNativeQuery(query, Estilo.class);
		List<Estilo> estilos = consulta.getResultList();
		return estilos;
	}

	public Estilo findById(Integer id) throws SQLException {
		return jpaManager.getEntityManager().find(Estilo.class, id);
	}

	public void save(Estilo estilo) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().persist(estilo);
		jpaManager.getEntityManager().getTransaction().commit();
	}

	public void delete(Estilo estilo) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().remove(estilo);
		jpaManager.getEntityManager().getTransaction().commit();
	}
}
