package idear.erp.unidadMedida;

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
public class GestorUnidadMedida {

    private static final Logger LOGGER = Logger.getLogger(GestorUnidadMedida.class.getName());
    private static final String QUERY_LEER_TODOS = "from unidadmedida";
    private static final String QUERY_LEER_POR_ID = "from unidadmedida where id = :id";
	
    private final SessionFactory sessionFactory;
    private final Session session;
    
    public GestorUnidadMedida() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UnidadMedida.class).buildSessionFactory();
        session = sessionFactory.openSession();
    }

	public void guardarUnidadMedida(UnidadMedida unidadMedida) {
		session.save(unidadMedida);
        LOGGER.log(Level.INFO, "unidadMedida correctamente ingresado");
        session.close();
	}
	
	public void actualizarUnidadMedida(UnidadMedida unidadMedida) {
        session.update(unidadMedida);
        LOGGER.log(Level.INFO, "unidadMedida correctamente actualizado");
        session.close();
	}
    
	public List<UnidadMedida> leerUnidadMedida() {
		List<UnidadMedida> UnidadMedida = session.createQuery(QUERY_LEER_TODOS).setMaxResults(100).getResultList();
		session.close();
		return UnidadMedida;
	}
	
	public UnidadMedida leerUnidadMedida(int id) {
		UnidadMedida unidadMedida = (UnidadMedida) session.createQuery(QUERY_LEER_POR_ID).setParameter("id", id).uniqueResult();
		LOGGER.log(Level.INFO, unidadMedida.toString());
		session.close();
		return unidadMedida;
	}
	
	public void bajaArticulo(int id) {
		UnidadMedida unidadMedida = leerUnidadMedida(id);
	    if (unidadMedida != null) {
	        try {
	            session.beginTransaction();
	            session.delete(unidadMedida);
	            session.getTransaction().commit();
	            LOGGER.log(Level.INFO, "Articulo con id " + id + " dado de baja correctamente");
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            LOGGER.log(Level.INFO, "Error al dar de baja el artículo con id " + id + ": " + e.getMessage());
	        } finally {
	            session.close();
	        }
	    } else {
	        LOGGER.log(Level.INFO, "No se encontró ningún artículo con el id " + id);
	    }
	}
    
}
