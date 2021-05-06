package pojos;

public class ObraSocial {
	private int idObraSocial;
	private String nombre;
	
	public ObraSocial() {}

	public ObraSocial(int idObraSocial, String nombre) {
		super();
		this.idObraSocial = idObraSocial;
		this.nombre = nombre;
	}

	public int getIdObraSocial() {
		return idObraSocial;
	}

	public void setIdObraSocial(int idObraSocial) {
		this.idObraSocial = idObraSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ObraSocial : " + nombre +" ";
	}
	
	
	

}
