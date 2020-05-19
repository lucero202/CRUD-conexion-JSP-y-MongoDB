package MySpa;

import com.mongodb.BasicDBObject;

public class Cliente {
	
	private int cod_cliente;
	private String nom_cliente;
	private int tele_cliente;
	private String correo_cliente;
	private String dire_cliente;
	private int eda_cliente;
	
	public Cliente() {
	}

	public Cliente(int cod_cliente, String nom_cliente, int tele_cliente, String correo_cliente, String dire_cliente, int eda_cliente) {
		this.cod_cliente=cod_cliente;
		this.nom_cliente=nom_cliente;
		this.tele_cliente=tele_cliente;
		this.correo_cliente=correo_cliente;
		this.dire_cliente=dire_cliente;
		this.eda_cliente=eda_cliente;

	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Cliente(BasicDBObject dBObjectcliente) {
		
		this.cod_cliente = dBObjectcliente.getInt("cod_cliente");
		this.nom_cliente = dBObjectcliente.getString("nom_cliente");
		this.tele_cliente = dBObjectcliente.getInt("tele_cliente");
		this.correo_cliente = dBObjectcliente.getString("correo_cliente");
		this.dire_cliente = dBObjectcliente.getString("dire_cliente");
		this.eda_cliente = dBObjectcliente.getInt("eda_cliente");
		
		
	}

	public BasicDBObject dBObjectcliente() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectcliente = new BasicDBObject();
		dBObjectcliente.append("cod_cliente", this.getCod_cliente());
		dBObjectcliente.append("nom_cliente", this.getNom_cliente());
		dBObjectcliente.append("tele_cliente", this.getTele_cliente());
		dBObjectcliente.append("correo_cliente", this.getCorreo_cliente());
		dBObjectcliente.append("dire_cliente", this.getDire_cliente());
		dBObjectcliente.append("eda_cliente", this.getEda_cliente());


		return dBObjectcliente;
	}



	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public int getTele_cliente() {
		return tele_cliente;
	}

	public void setTele_cliente(int tele_cliente) {
		this.tele_cliente = tele_cliente;
	}

	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}

	public String getDire_cliente() {
		return dire_cliente;
	}

	public void setDire_cliente(String dire_cliente) {
		this.dire_cliente = dire_cliente;
	}

	public int getEda_cliente() {
		return eda_cliente;
	}

	public void setEda_cliente(int eda_cliente) {
		this.eda_cliente = eda_cliente;
	}

	@Override
	public String toString() {
		return "Codigo Cliente: " + this.getCod_cliente() + " / Nombre Cliente: " + this.getNom_cliente() +
				" / Telefono Cliente: " + this.getTele_cliente() + "/ Correo Cliente"+ this.getCorreo_cliente()
				 + "/ Direccion del Cliente"+ this.getDire_cliente() + "/ Edad Cliente"+ this.getEda_cliente();
	}
}