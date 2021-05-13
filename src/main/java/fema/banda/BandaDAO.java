package fema.banda;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import fema.persistence.JpaManager;

@SessionScoped
public class BandaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private JpaManager jpaManager;

	@SuppressWarnings("unchecked")
	public List<Banda> findAll() throws SQLException {
		Query consulta = jpaManager.getEntityManager().createNativeQuery("select * from banda order by id",
				Banda.class);
		return consulta.getResultList();
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
