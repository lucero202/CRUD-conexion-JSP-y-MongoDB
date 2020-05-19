package MySpa;

import com.mongodb.BasicDBObject;

public class Reserva {
	
	private int cod_reserva;
	private String nom_reserva;
	private int fecha_reseva;
	private int hora_reserva;
	private int precio_reserva;
	private String cat_reserva;
	private int cod_cliente;
	private int cod_empleado;
	private int cod_servicio;
	
	public Reserva() {
	}

	public Reserva(int cod_reserva, String nom_reserva, int fecha_reseva, int hora_reserva, int precio_reserva, String cat_reserva, 
					int cod_cliente, int cod_empleado, int cod_servicio ) {
		this.cod_reserva=cod_reserva;
		this.nom_reserva=nom_reserva;
		this.fecha_reseva=fecha_reseva;
		this.hora_reserva=hora_reserva;
		this.precio_reserva=precio_reserva;
		this.cat_reserva=cat_reserva;
		this.cod_cliente=cod_cliente;
		this.cod_empleado=cod_empleado;
		this.cod_servicio=cod_servicio;
	
		
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Reserva(BasicDBObject dBObjectreserva) {
		
	
		this.cod_reserva= dBObjectreserva.getInt("cod_empleado");
		this.nom_reserva= dBObjectreserva.getString("nom_reserva");
		this.fecha_reseva= dBObjectreserva.getInt("fecha_reseva");
		this.hora_reserva= dBObjectreserva.getInt("hora_reserva");
		this.precio_reserva= dBObjectreserva.getInt("precio_reserva");		
		this.cat_reserva= dBObjectreserva.getString("cat_reserva");
		this.cod_cliente= dBObjectreserva.getInt("cod_cliente");
		this.cod_empleado= dBObjectreserva.getInt("cod_empleado");
		this.cod_servicio= dBObjectreserva.getInt("cod_servicio");
	
		
	}

	public BasicDBObject dBObjectreserva() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectreserva = new BasicDBObject();
		dBObjectreserva.append("cod_reserva", this.getCod_reserva());
		dBObjectreserva.append("nom_reserva", this.getNom_reserva());
		dBObjectreserva.append("fecha_reseva", this.getFecha_reseva());
		dBObjectreserva.append("hora_reserva", this.getHora_reserva());
		dBObjectreserva.append("precio_reserva", this.getPrecio_reserva());
		dBObjectreserva.append("cat_reserva", this.getCat_reserva());
		dBObjectreserva.append("cod_cliente", this.getCod_cliente());
		dBObjectreserva.append("cod_empleado", this.getCod_empleado());
		dBObjectreserva.append("cod_servicio", this.getCod_servicio());
		

		return dBObjectreserva;
	}
	
	
	public int getCod_reserva() {
		return cod_reserva;
	}

	public void setCod_reserva(int cod_reserva) {
		this.cod_reserva = cod_reserva;
	}

	public String getNom_reserva() {
		return nom_reserva;
	}

	public void setNom_reserva(String nom_reserva) {
		this.nom_reserva = nom_reserva;
	}

	public int getFecha_reseva() {
		return fecha_reseva;
	}

	public void setFecha_reseva(int fecha_reseva) {
		this.fecha_reseva = fecha_reseva;
	}

	public int getHora_reserva() {
		return hora_reserva;
	}

	public void setHora_reserva(int hora_reserva) {
		this.hora_reserva = hora_reserva;
	}

	public int getPrecio_reserva() {
		return precio_reserva;
	}

	public void setPrecio_reserva(int precio_reserva) {
		this.precio_reserva = precio_reserva;
	}

	public String getCat_reserva() {
		return cat_reserva;
	}

	public void setCat_reserva(String cat_reserva) {
		this.cat_reserva = cat_reserva;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(int cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public int getCod_servicio() {
		return cod_servicio;
	}

	public void setCod_servicio(int cod_servicio) {
		this.cod_servicio = cod_servicio;
	}

	@Override
	public String toString() {
		
		
		return "Codigo Reserva: " + this.getCod_reserva() + "/Nombre Reserva"+ this.getNom_reserva()+ "/Fecha Reserva"+ this.getFecha_reseva()+
				"/Hora Resereva"+this.getHora_reserva()+ "/Precio Reserva"+ this.getPrecio_reserva()+   "/Categoria Resereva"+this.getCat_reserva()+ 
				"/Codigo Cliente"+this.getCod_cliente()+ "Codigo Empleado"+this.getCod_empleado()+ "/Codigo Servicio" +  this.getCod_servicio();
	}
}