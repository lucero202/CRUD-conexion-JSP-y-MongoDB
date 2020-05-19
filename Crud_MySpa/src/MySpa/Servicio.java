
package MySpa;

import com.mongodb.BasicDBObject;

public class Servicio {
	
	private int cod_servicio  ;
	private String tipo_servicio  ;
	private int valor_servicio  ;
	
	public Servicio() {
	}

	public Servicio(int cod_servicio, String tipo_servicio, int valor_servicio) {
		this.cod_servicio=cod_servicio;
		this.tipo_servicio=tipo_servicio;
		this.valor_servicio=valor_servicio;
	
		
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Servicio(BasicDBObject dBObjectservicio) {
		
		this.cod_servicio = dBObjectservicio.getInt("cod_servicio");
		this.tipo_servicio = dBObjectservicio.getString("tipo_servicio");
		this.valor_servicio = dBObjectservicio.getInt("valor_servicio");
	
		
		
	}

	public BasicDBObject dBObjectservicio() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectservicio = new BasicDBObject();
		dBObjectservicio.append("cod_servicio", this.getCod_servicio());
		dBObjectservicio.append("tipo_servicio", this.getTipo_servicio());
		dBObjectservicio.append("valor_servicio", this.getValor_servicio());

		


		return dBObjectservicio;
	}


	public int getCod_servicio() {
		return cod_servicio;
	}

	public void setCod_servicio(int cod_servicio) {
		this.cod_servicio = cod_servicio;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public int getValor_servicio() {
		return valor_servicio;
	}

	public void setValor_servicio(int valor_servicio) {
		this.valor_servicio = valor_servicio;
	}

	@Override
	public String toString() {
		return "Codigo Servicio: " + this.getCod_servicio() + " / Tipo Servicio: " + this.getTipo_servicio() +
				" / Valor Servicio: " + this.getValor_servicio();
		
	}
}