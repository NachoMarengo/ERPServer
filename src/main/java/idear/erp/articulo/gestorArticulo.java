package idear.erp.articulo;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class gestorArticulo {
	
    private static final Logger _traza = Logger.getLogger(gestorArticulo.class.getName());
	
	SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Articulo.class).buildSessionFactory();
	Session miSession = miFactory.openSession();
	
	public void guardarArticulo(Articulo miArticulo) {
		
		try {
			
			miSession.beginTransaction();
			miSession.save(miArticulo);
			miSession.getTransaction().commit();
			miSession.close();
			
			_traza.log(Level.INFO, "Articulo correctamente ingresado");
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	
	public void actualizarArticulo(Articulo miArticulo) {
	    try {
	        miSession.beginTransaction();
	        miSession.update(miArticulo);
	        miSession.getTransaction().commit();
	        miSession.close();

	        _traza.log(Level.INFO, "Articulo correctamente actualizado");
	    } catch (Exception e) {
	        _traza.log(Level.INFO, e.toString());
	    } finally {
	        // Cerrar la sesión de Hibernate
	    }
	}
	
	public List<Articulo> leerArticulo() {
		try {
			miSession.beginTransaction();
			List<Articulo> articulos = miSession.createQuery("from Articulo")
							.setMaxResults(100)
							.getResultList();
			for(Articulo articulo: articulos) {
				_traza.log(Level.INFO, articulo.toString());
			}
			miSession.close();
			return articulos;
		} catch (Exception e) {
			_traza.log(Level.INFO, e.toString());
		} finally {
		}
		return null;
	}

	
	public Articulo leerArticulo(int id) {
		try {
			miSession.beginTransaction();
			Articulo articulo = (Articulo) miSession.createQuery("from Articulo where id = :id")
							.setParameter("id", id)
							.uniqueResult();
			_traza.log(Level.INFO, articulo.toString());
			miSession.close();
			return articulo;
		} catch (Exception e) {
			_traza.log(Level.INFO, e.toString());
		} finally {
		}
		return null;
	}
	
	public void bajaArticulo(int id) {
		try {
			miSession.beginTransaction();
			Articulo articulo = (Articulo) miSession.createQuery("from Articulo where id = :id")
							.setParameter("id", id)
							.uniqueResult();
			if (articulo != null) {
				miSession.delete(articulo);
				_traza.log(Level.INFO, "Articulo con id " + id + " dado de baja correctamente");
			} else {
				_traza.log(Level.INFO, "No se encontró ningún artículo con el id " + id);
			}
			miSession.getTransaction().commit();
		} catch (Exception e) {
			miSession.getTransaction().rollback();
			_traza.log(Level.INFO, "Error al dar de baja el artículo con id " + id + ": " + e.getMessage());
		} finally {
			miSession.close();
		}
	}
	
}
