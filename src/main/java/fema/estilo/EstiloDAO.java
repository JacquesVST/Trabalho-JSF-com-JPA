package fema.estilo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import fema.persistence.JpaManager;

@SessionScoped
public class EstiloDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private JpaManager jpaManager;

	@SuppressWarnings("unchecked")
	public List<Estilo> findAll() throws SQLException {
		Query consulta = jpaManager.getEntityManager().createNativeQuery("select * from estilo order by id", Estilo.class);
		return consulta.getResultList();
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
