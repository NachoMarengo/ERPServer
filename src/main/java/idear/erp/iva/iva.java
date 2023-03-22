package idear.erp.iva;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "iva")
public class Iva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "nombre", nullable = false)
	String nombre;
	@Column(name = "porcentaje", nullable = false)
	double porcentaje;
	
	public Iva() {
	}

	public Iva(int id, String nombre, double porcentaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Iva [id=" + id + ", nombre=" + nombre + ", porcentaje=" + porcentaje + "]";
	}
	
	
	
	
}
