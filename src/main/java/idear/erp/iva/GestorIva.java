package idear.erp.iva;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class GestorIva {
	private static final Logger LOGGER = Logger.getLogger(GestorIva.class.getName());
	private static final String QUERY_LEER_TODOS = "from iva";
	private static final String QUERY_LEER_POR_ID = "from iva where id = :id";

	private final SessionFactory sessionFactory;
	private final Session session;

	public GestorIva() {
	    sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Iva.class).buildSessionFactory();
	    session = sessionFactory.openSession();
	}

	public void guardarIva(Iva iva) {
		session.save(iva);
	    LOGGER.log(Level.INFO, "Iva correctamente ingresado");
	    session.close();
	}

	public void actualizarIva(Iva iva) {
	    session.update(iva);
	    LOGGER.log(Level.INFO, "Iva correctamente actualizado");
	    session.close();
	}

	public List<Iva> leerIva() {
		List<Iva> ivas = session.createQuery(QUERY_LEER_TODOS).setMaxResults(100).getResultList();
		session.close();
		return ivas;
	}

	public Iva leerIva(int id) {
		Iva iva = (Iva) session.createQuery(QUERY_LEER_POR_ID).setParameter("id", id).uniqueResult();
		LOGGER.log(Level.INFO, iva.toString());
		session.close();
		return iva;
	}

	public void darDeBajaIva(int id) {
		Iva iva = leerIva(id);
	    if (iva != null) {
	        try {
	            session.beginTransaction();
	            session.delete(iva);
	            session.getTransaction().commit();
	            LOGGER.log(Level.INFO, "Iva con id " + id + " dado de baja correctamente");
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            LOGGER.log(Level.INFO, "Error al dar de baja el Iva con id " + id + ": " + e.getMessage());
	        } finally {
	            session.close();
	        }
	    } else {
	        LOGGER.log(Level.INFO, "No se encontró ningún Iva con el id " + id);
	    }
	}

}
