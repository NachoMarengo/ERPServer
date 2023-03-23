package idear.erp.entidad.obraSocial;

import idear.erp.entidad.Entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "obra_social")
public class ObraSocial  extends Entidad{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_planes")
    private int id_planes;

	public ObraSocial(Long id, int id_planes) {
		super();
		this.id = id;
		this.id_planes = id_planes;
	}

	public ObraSocial() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getId_planes() {
		return id_planes;
	}

	public void setId_planes(int id_planes) {
		this.id_planes = id_planes;
	}

	@Override
	public String toString() {
		return "ObraSocial [id=" + id + ", id_planes=" + id_planes + "]";
	}
    
    

}
