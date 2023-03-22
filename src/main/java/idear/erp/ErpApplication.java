package idear.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import idear.erp.articulo.gestorArticulo;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
		
		gestorArticulo miGestorArticulo = new gestorArticulo();
		miGestorArticulo.bajaArticulo(1);
	}

}
