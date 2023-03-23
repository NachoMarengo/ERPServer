package idear.erp.entidad.comiciontista;

import idear.erp.entidad.Entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comicionista")
public class Comicionista extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dias")
    private int dias;

    @Column(name = "id_articulos")
    private int id_articulos;

    @Column(name = "id_marcas")
    private int id_marcas;

    public Comicionista() {
    }

	public Comicionista(Long id, int dias, int id_articulos, int id_marcas) {
		super();
		this.id = id;
		this.dias = dias;
		this.id_articulos = id_articulos;
		this.id_marcas = id_marcas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getId_articulos() {
		return id_articulos;
	}

	public void setId_articulos(int id_articulos) {
		this.id_articulos = id_articulos;
	}

	public int getId_marcas() {
		return id_marcas;
	}

	public void setId_marcas(int id_marcas) {
		this.id_marcas = id_marcas;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dias=" + dias + ", id_articulos=" + id_articulos + ", id_marcas=" + id_marcas
				+ "]";
	}
    
    
    
}
