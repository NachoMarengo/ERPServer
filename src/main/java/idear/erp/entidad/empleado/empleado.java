package idear.erp.entidad.empleado;

import idear.erp.entidad.Entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "empleados")
	public class Empleado extends Entidad {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "sueldo")
	    private double sueldo;

	    @Column(name = "id_dias_tomados")
	    private int id_diasTomados;

	    @Column(name = "dias_vacaciones")
	    private int diasVacaciones;

	    @Column(name = "dias_tomados_vacaciones")
	    private int diasTomadosVacaciones;

	    @Column(name = "llegadas_tarde")
	    private int llegadasTarde;

	    @Column(name = "primer_aguinaldo")
	    private double primerAguinaldo;

	    @Column(name = "segundo_aguinaldo")
	    private double segundoAguinaldo;

	    @Column(name = "dias_suspenciones")
	    private int diasSuspenciones;

	    @Column(name = "sueldo_por_dia")
	    private double sueldoPorDia;

	    @Column(name = "sueldo_por_hora")
	    private double sueldoPorHora;

	    @Column(name = "sueldo_por_año")
	    private double sueldoPorAño;

	    @Column(name = "id_premio")
	    private int id_premio;

	    @Column(name = "id_bonificaciones")
	    private int id_bonificaciones;

	    @Column(name = "id_obra_social")
	    private int id_obraSocial;

	    public Empleado() {
	    }

	    public Empleado(Long id, double sueldo, int id_diasTomados, int diasVacaciones, int diasTomadosVacaciones, int llegadasTarde, double primerAguinaldo, double segundoAguinaldo, int diasSuspenciones, double sueldoPorDia, double sueldoPorHora, double sueldoPorAño, int id_premio, int id_bonificaciones, int id_obraSocial) {
	        this.id = id;
	        this.sueldo = sueldo;
	        this.id_diasTomados = id_diasTomados;
	        this.diasVacaciones = diasVacaciones;
	        this.diasTomadosVacaciones = diasTomadosVacaciones;
	        this.llegadasTarde = llegadasTarde;
	        this.primerAguinaldo = primerAguinaldo;
	        this.segundoAguinaldo = segundoAguinaldo;
	        this.diasSuspenciones = diasSuspenciones;
	        this.sueldoPorDia = sueldoPorDia;
	        this.sueldoPorHora = sueldoPorHora;
	        this.sueldoPorAño = sueldoPorAño;
	        this.id_premio = id_premio;
	        this.id_bonificaciones = id_bonificaciones;
	        this.id_obraSocial = id_obraSocial;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public double getSueldo() {
			return sueldo;
		}

		public void setSueldo(double sueldo) {
			this.sueldo = sueldo;
		}

		public int getId_diasTomados() {
			return id_diasTomados;
		}

		public void setId_diasTomados(int id_diasTomados) {
			this.id_diasTomados = id_diasTomados;
		}

		public int getDiasVacaciones() {
			return diasVacaciones;
		}

		public void setDiasVacaciones(int diasVacaciones) {
			this.diasVacaciones = diasVacaciones;
		}

		public int getDiasTomadosVacaciones() {
			return diasTomadosVacaciones;
		}

		public void setDiasTomadosVacaciones(int diasTomadosVacaciones) {
			this.diasTomadosVacaciones = diasTomadosVacaciones;
		}

		public int getLlegadasTarde() {
			return llegadasTarde;
		}

		public void setLlegadasTarde(int llegadasTarde) {
			this.llegadasTarde = llegadasTarde;
		}

		public double getPrimerAguinaldo() {
			return primerAguinaldo;
		}

		public void setPrimerAguinaldo(double primerAguinaldo) {
			this.primerAguinaldo = primerAguinaldo;
		}

		public double getSegundoAguinaldo() {
			return segundoAguinaldo;
		}

		public void setSegundoAguinaldo(double segundoAguinaldo) {
			this.segundoAguinaldo = segundoAguinaldo;
		}

		public int getDiasSuspenciones() {
			return diasSuspenciones;
		}

		public void setDiasSuspenciones(int diasSuspenciones) {
			this.diasSuspenciones = diasSuspenciones;
		}

		public double getSueldoPorDia() {
			return sueldoPorDia;
		}

		public void setSueldoPorDia(double sueldoPorDia) {
			this.sueldoPorDia = sueldoPorDia;
		}

		public double getSueldoPorHora() {
			return sueldoPorHora;
		}

		public void setSueldoPorHora(double sueldoPorHora) {
			this.sueldoPorHora = sueldoPorHora;
		}

		public double getSueldoPorAño() {
			return sueldoPorAño;
		}

		public void setSueldoPorAño(double sueldoPorAño) {
			this.sueldoPorAño = sueldoPorAño;
		}

		public int getId_premio() {
			return id_premio;
		}

		public void setId_premio(int id_premio) {
			this.id_premio = id_premio;
		}

		public int getId_bonificaciones() {
			return id_bonificaciones;
		}

		public void setId_bonificaciones(int id_bonificaciones) {
			this.id_bonificaciones = id_bonificaciones;
		}

		public int getId_obraSocial() {
			return id_obraSocial;
		}

		public void setId_obraSocial(int id_obraSocial) {
			this.id_obraSocial = id_obraSocial;
		}

		@Override
		public String toString() {
			return "Empleado [id=" + id + ", sueldo=" + sueldo + ", id_diasTomados=" + id_diasTomados
					+ ", diasVacaciones=" + diasVacaciones + ", diasTomadosVacaciones=" + diasTomadosVacaciones
					+ ", llegadasTarde=" + llegadasTarde + ", primerAguinaldo=" + primerAguinaldo
					+ ", segundoAguinaldo=" + segundoAguinaldo + ", diasSuspenciones=" + diasSuspenciones
					+ ", sueldoPorDia=" + sueldoPorDia + ", sueldoPorHora=" + sueldoPorHora + ", sueldoPorAño="
					+ sueldoPorAño + ", id_premio=" + id_premio + ", id_bonificaciones=" + id_bonificaciones
					+ ", id_obraSocial=" + id_obraSocial + "]";
		}
	    
}
