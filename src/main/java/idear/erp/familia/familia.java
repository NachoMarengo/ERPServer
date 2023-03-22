package idear.erp.familia;

import jakarta.persistence.*;

@Entity
@Table(name = "familia")
public class Familia {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "nombre")
	    private String nombre;

	    @ManyToOne
	    @JoinColumn(name = "familia_sup_id")
	    private Familia familiaSup;

	    @Column(name = "contaminante")
	    private boolean contaminante;

	    public Familia() {}

	    public Familia(long id,String nombre, Familia familiaSup, boolean contaminante) {
	    	this.id = id;
	        this.nombre = nombre;
	        this.familiaSup = familiaSup;
	        this.contaminante = contaminante;  
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Familia getFamiliaSup() {
			return familiaSup;
		}

		public void setFamiliaSup(Familia familiaSup) {
			this.familiaSup = familiaSup;
		}

		public boolean isContaminante() {
			return contaminante;
		}

		public void setContaminante(boolean contaminante) {
			this.contaminante = contaminante;
		}

		@Override
		public String toString() {
			return "Familia [id=" + id + ", nombre=" + nombre + ", familiaSup=" + familiaSup + ", contaminante="
					+ contaminante + "]";
		}
	   
}
