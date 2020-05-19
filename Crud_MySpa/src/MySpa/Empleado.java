package MySpa;

import com.mongodb.BasicDBObject;

public class Empleado {
	
	private int cod_empleado ;
	private String nom_empleado ;
	private int tele_empleado ;
	private String cat_empleado ;
	
	
	public Empleado() {
	}

	public Empleado(int cod_empleado, String nom_empleado, int tele_empleado, String cat_empleado) {
		this.cod_empleado=cod_empleado;
		this.nom_empleado=nom_empleado;
		this.tele_empleado=tele_empleado;
		this.cat_empleado=cat_empleado;
		
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Empleado(BasicDBObject dBObjectempleado) {
		
		this.cod_empleado = dBObjectempleado.getInt("cod_empleado");
		this.nom_empleado = dBObjectempleado.getString("nom_empleado");
		this.tele_empleado = dBObjectempleado.getInt("tele_empleado");
		this.cat_empleado = dBObjectempleado.getString("cat_empleado");
		
		
		
	}

	public BasicDBObject dBObjectempleado() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectempleado = new BasicDBObject();
		dBObjectempleado.append("cod_empleado", this.getCod_empleado());
		dBObjectempleado.append("nom_empleado", this.getNom_empleado());
		dBObjectempleado.append("tele_empleado", this.getTele_empleado());
		dBObjectempleado.append("cat_empleado", this.getCat_empleado());
		


		return dBObjectempleado;
	}


	public int getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(int cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNom_empleado() {
		return nom_empleado;
	}

	public void setNom_empleado(String nom_empleado) {
		this.nom_empleado = nom_empleado;
	}

	public int getTele_empleado() {
		return tele_empleado;
	}

	public void setTele_empleado(int tele_empleado) {
		this.tele_empleado = tele_empleado;
	}

	public String getCat_empleado() {
		return cat_empleado;
	}

	public void setCat_empleado(String cat_empleado) {
		this.cat_empleado = cat_empleado;
	}

	@Override
	public String toString() {
		return "Codigo Empleado: " + this.getCod_empleado() + " / Nombre Empleado: " + this.getNom_empleado() +
				" / Telefono Empleado: " + this.getTele_empleado() + "/ Categoria Empleado"+ this.getCat_empleado();
				
	}
}