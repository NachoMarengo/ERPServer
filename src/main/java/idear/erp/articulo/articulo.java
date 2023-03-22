package idear.erp.articulo;

import idear.erp.unidadMedida.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import idear.erp.familia.*;
import idear.erp.iva.*;
import idear.erp.entidad.marca.*;

@Entity
@Table(name = "articulo")
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "code_erp", nullable = false)
	private String codeErp;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	
	@Column(name = "fecha_ulti_actualizacion")
	private String fechaUltiActualizacion;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(name = "stock_critico", nullable = false)
	private int stockCritico;
	
	@Column(nullable = false)
	private double medida;
	
	@Column(name = "precio_costo", nullable = false)
	private double precioCosto;
	
	@Column(name = "precio_venta", nullable = false)
	private double precioVenta;
	
	@ManyToOne
	@JoinColumn(name = "unidad_medida_id")
	private UnidadMedida unidadMedida;
	
	@ManyToOne
	@JoinColumn(name = "familia_id")
	private Familia familia;
	
	@ManyToOne
	@JoinColumn(name = "iva_id")
	private Iva iva;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@Column(nullable = false)
	private boolean envase;
	
	
	public Articulo(int id, String codeErp, String nombre, String descripcion, String fechaCreacion,
			String fechaUltiActualizacion, int cantidad, int stockCritico, double medida, double precioCosto,
			double precioVenta, UnidadMedida unidadMedida, Familia familia,
			Iva iva, Marca marca, boolean envase) {
		super();
		this.id = id;
		this.codeErp = codeErp;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltiActualizacion = fechaUltiActualizacion;
		this.cantidad = cantidad;
		this.stockCritico = stockCritico;
		this.medida = medida;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.unidadMedida = unidadMedida;
		this.familia = familia;
		this.iva = iva;
		this.marca = marca;
		this.envase = envase;
	}
	public Articulo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeErp() {
		return codeErp;
	}
	public void setCodeErp(String codeErp) {
		this.codeErp = codeErp;
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
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaUltiActualizacion() {
		return fechaUltiActualizacion;
	}
	public void setFechaUltiActualizacion(String fechaUltiActualizacion) {
		this.fechaUltiActualizacion = fechaUltiActualizacion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getStockCritico() {
		return stockCritico;
	}
	public void setStockCritico(int stockCritico) {
		this.stockCritico = stockCritico;
	}
	public double getMedida() {
		return medida;
	}
	public void setMedida(double medida) {
		this.medida = medida;
	}
	public double getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	public Iva getIva() {
		return iva;
	}
	public void setIva(Iva iva) {
		this.iva = iva;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public boolean isEnvase() {
		return envase;
	}
	public void setEnvase(boolean envase) {
		this.envase = envase;
	}
	
	@Override
	public String toString() {
		return "articulo [id=" + id + ", codeErp=" + codeErp + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaUltiActualizacion=" + fechaUltiActualizacion
				+ ", cantidad=" + cantidad + ", stockCritico=" + stockCritico + ", medida=" + medida + ", precioCosto="
				+ precioCosto + ", precioVenta=" + precioVenta + ", unidadMedida=" + unidadMedida + ", familia="
				+ familia + ", iva=" + iva + ", marca=" + marca + ", envase=" + envase + "]";
	}
	
}