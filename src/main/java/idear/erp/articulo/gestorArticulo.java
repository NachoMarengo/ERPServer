package idear.erp.articulo;

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
public class GestorArticulo {
	
    private static final Logger LOGGER = Logger.getLogger(GestorArticulo.class.getName());
    private static final String QUERY_LEER_TODOS = "from Articulo";
    private static final String QUERY_LEER_POR_ID = "from Articulo where id = :id";
	
    private final SessionFactory sessionFactory;
    private final Session session;
    
    public GestorArticulo() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulo.class).buildSessionFactory();
        session = sessionFactory.openSession();
    }

	public void guardarArticulo(Articulo miArticulo) {
		session.save(miArticulo);
        LOGGER.log(Level.INFO, "Articulo correctamente ingresado");
        session.close();
	}
	
	public void actualizarArticulo(Articulo miArticulo) {
        session.update(miArticulo);
        LOGGER.log(Level.INFO, "Articulo correctamente actualizado");
        session.close();
	}
	
	public List<Articulo> leerArticulo() {
		List<Articulo> articulos = session.createQuery(QUERY_LEER_TODOS).setMaxResults(100).getResultList();
		for(Articulo articulo: articulos) {
			LOGGER.log(Level.INFO, articulo.toString());
		}
		session.close();
		return articulos;
	}
	
	public Articulo leerArticulo(int id) {
		Articulo articulo = (Articulo) session.createQuery(QUERY_LEER_POR_ID).setParameter("id", id).uniqueResult();
		LOGGER.log(Level.INFO, articulo.toString());
		session.close();
		return articulo;
	}
	
	public void bajaArticulo(int id) {
	    Articulo articulo = leerArticulo(id);
	    if (articulo != null) {
	        try {
	            session.beginTransaction();
	            session.delete(articulo);
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
