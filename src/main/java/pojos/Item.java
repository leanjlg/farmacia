package pojos;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public class Item {
	@BsonProperty(useDiscriminator = true)
	private Producto producto;
	@BsonProperty("precioUnitario")
	private double precioUnitario;
	@BsonProperty("cantidad")
	private int cantidad;
	
	public Item() {}
	public Item(Producto producto, double precioUnitario, int cantidad) {
		super();
		this.producto = producto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Item [producto=" + producto + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + "]";
	}
	
	

}
