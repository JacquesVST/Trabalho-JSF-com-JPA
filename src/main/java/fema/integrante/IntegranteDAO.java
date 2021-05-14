package fema.integrante;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Query;

import fema.persistence.JpaManager;

@SessionScoped
public class IntegranteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private JpaManager jpaManager;

	public IntegranteDAO(JpaManager jpaManager) {
		this.jpaManager = jpaManager;
	}

	@SuppressWarnings("unchecked")
	public List<Integrante> findAll() throws SQLException {
		Query consulta = jpaManager.getEntityManager().createNativeQuery("select * from integrante order by id",
				Integrante.class);
		return consulta.getResultList();
	}

	public Integrante findById(Integer id) throws SQLException {
		return jpaManager.getEntityManager().find(Integrante.class, id);
	}

	public void save(Integrante integrante) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().persist(integrante);
		jpaManager.getEntityManager().getTransaction().commit();
	}

	public void delete(Integrante integrante) throws SQLException {
		jpaManager.getEntityManager().getTransaction().begin();
		jpaManager.getEntityManager().remove(integrante);
		jpaManager.getEntityManager().getTransaction().commit();
	}
}
