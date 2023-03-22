package idear.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import idear.erp.articulo.GestorArticulo;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
		
		GestorArticulo miGestorArticulo = new GestorArticulo();
		miGestorArticulo.leerArticulo(5);
	}

}
