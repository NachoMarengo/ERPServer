package idear.erp.familia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Transactional
public class GestorFamilia {

    private static final Logger LOGGER = Logger.getLogger(GestorFamilia.class.getName());
    private static final String QUERY_LEER_TODOS = "from familia";
    private static final String QUERY_LEER_POR_ID = "from familia where id = :id";
	
    private final SessionFactory sessionFactory;
    private final Session session;
    
    public GestorFamilia() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Familia.class).buildSessionFactory();
        session = sessionFactory.openSession();
    }

	public void guardarFamilia(Familia familia) {
		session.save(familia);
        LOGGER.log(Level.INFO, "Familia correctamente ingresada");
        session.close();
	}
	
	public void actualizarFamilia(Familia familia) {
        session.update(familia);
        LOGGER.log(Level.INFO, "Familia correctamente actualizada");
        session.close();
	}
    
	public List<Familia> leerFamilias() {
		List<Familia> familias = session.createQuery(QUERY_LEER_TODOS).setMaxResults(100).getResultList();
		session.close();
		return familias;
	}
	
	public Familia leerFamiliaPorId(int id) {
		Familia familia = (Familia) session.createQuery(QUERY_LEER_POR_ID).setParameter("id", id).uniqueResult();
		LOGGER.log(Level.INFO, familia.toString());
		session.close();
		return familia;
	}
	
	public void darDeBajaFamilia(int id) {
		Familia familia = leerFamiliaPorId(id);
	    if (familia != null) {
	        try {
	            session.beginTransaction();
	            session.delete(familia);
	            session.getTransaction().commit();
	            LOGGER.log(Level.INFO, "Familia con id " + id + " dada de baja correctamente");
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            LOGGER.log(Level.INFO, "Error al dar de baja la familia con id " + id + ": " + e.getMessage());
	        } finally {
	            session.close();
	        }
	    } else {
	        LOGGER.log(Level.INFO, "No se encontró ninguna familia con el id " + id);
	    }
	}
    
}
