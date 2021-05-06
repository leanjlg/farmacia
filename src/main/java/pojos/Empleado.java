package pojos;

import org.bson.codecs.pojo.annotations.*;

@BsonDiscriminator
public class Empleado extends Persona{	
	@BsonProperty("cuil")
	private String cuil;
	@BsonProperty("sucursal")
	private int sucursal;
	@BsonProperty("encargado")
	private boolean encargado;
	public Empleado() {}
	public Empleado(int idPersona, int dni, String nombre, String apellido, String telefono, Domicilio domicilio,
			int nroAfiliado, ObraSocial obraSocial, String cuil, int sucursal, boolean encargado) {
		super(idPersona, dni, nombre, apellido, telefono, domicilio, nroAfiliado, obraSocial);
		this.cuil = cuil;
		this.sucursal = sucursal;
		this.encargado = encargado;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public boolean isEncargado() {
		return encargado;
	}
	public void setEncargado(boolean encargado) {
		this.encargado = encargado;
	}
	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", sucursal=" + sucursal + ", encargado=" + encargado + "]";
	}
	
	
	

}
