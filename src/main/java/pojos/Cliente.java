package pojos;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;
@BsonDiscriminator
public class Cliente extends Persona {
	@BsonProperty("nroCliente")
	private int nroCliente;
	
	public Cliente() {}
	
	public Cliente(int idPersona, int dni, String nombre, String apellido, String telefono, Domicilio domicilio,
			int nroAfiliado, ObraSocial obraSocial,  int nroCliente) {
		super(idPersona, dni, nombre, apellido, telefono, domicilio, nroAfiliado, obraSocial);
		
		this.nroCliente = nroCliente;
	}	
	public int getNroCliente() {
		return nroCliente;
	}
	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}
	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + "]";
	}
	
	

}
