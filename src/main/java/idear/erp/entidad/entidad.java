package idear.erp.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "dni")
    private String dni;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "cuil")
    private String cuil;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "tel_cel")
    private String telCel;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @Column(name = "es_juridico")
    private boolean esJuridico;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "id_cuenta")
    private Long idCuenta;

    @Column(name = "id_localidad")
    private Long idLocalidad;

    @Column(name = "IIBB")
    private String iibb;

    public Entidad() {
    }

    public Entidad(String nombre, String descripcion, String dni, String cuit, String cuil, String domicilio, String telCel, String fechaCreacion, boolean esJuridico, String observacion, Long idCuenta, Long idLocalidad, String iibb) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dni = dni;
        this.cuit = cuit;
        this.cuil = cuil;
        this.domicilio = domicilio;
        this.telCel = telCel;
        this.fechaCreacion = fechaCreacion;
        this.esJuridico = esJuridico;
        this.observacion = observacion;
        this.idCuenta = idCuenta;
        this.idLocalidad = idLocalidad;
        this.iibb = iibb;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelCel() {
		return telCel;
	}

	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEsJuridico() {
		return esJuridico;
	}

	public void setEsJuridico(boolean esJuridico) {
		this.esJuridico = esJuridico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getIibb() {
		return iibb;
	}

	public void setIibb(String iibb) {
		this.iibb = iibb;
	}

	@Override
	public String toString() {
		return "Entidad [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dni=" + dni + ", cuit="
				+ cuit + ", cuil=" + cuil + ", domicilio=" + domicilio + ", telCel=" + telCel + ", fechaCreacion="
				+ fechaCreacion + ", esJuridico=" + esJuridico + ", observacion=" + observacion + ", idCuenta="
				+ idCuenta + ", idLocalidad=" + idLocalidad + ", iibb=" + iibb + "]";
	}
    
}