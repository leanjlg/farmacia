package test;

import connexion.ConnexionMongoDB;
import connexion.PojoCodecRegistry;
import pojos.Cliente;
import pojos.Domicilio;
import pojos.Empleado;
import pojos.Item;
import pojos.ObraSocial;
import pojos.Producto;
import pojos.Sucursal;
import pojos.Venta;

import com.mongodb.MongoClient;				//Para instanciar mongoDB
import com.mongodb.client.MongoDatabase; 	//Para instanciar la base de datos y acceder a ella
import com.mongodb.client.MongoCollection;	//Para instanciar la colección y acceder a ella
import static com.mongodb.client.model.Filters.*;//Para utilizar los filtros de busqueda "querys"
import org.bson.Document; // Para crud de documentos (objetos) BSON
import org.bson.codecs.configuration.CodecRegistry;

import static com.mongodb.client.model.Updates.*;// Para utilizar los métodos de actualizar documentos en la DB
import com.mongodb.client.result.UpdateResult;//Para obtener información sobre el resultado de una operación de actualización.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Conexión al Server de MongoDB pasandole el host y el puerto
		//MongoClient clienteMongo = new MongoClient("localhost", 27017);
		CodecRegistry pojoCodecRegistry = new PojoCodecRegistry().getPojoCodecRegistry();
		MongoClient clienteMongo = new ConnexionMongoDB().getMongoClient();

		//Conexión a la base de datos (si no existe, mongoDB crea la base de datos cuando se alojen datos en ella)
		MongoDatabase baseDeDatos = clienteMongo.getDatabase("pruebaComercio").withCodecRegistry(pojoCodecRegistry);

		//Conexión con la colección (si no existe, mongoDB crea la coleccion cuando se alojen datos en ella)
		//MongoCollection collection = baseDeDatos.getCollection("productos");
		MongoCollection sucursalCollection = baseDeDatos.getCollection("sucursal", Sucursal.class );
		
		
		//OBJETOS
		Producto pro1 = new Producto(1, "Prod11", 34, "descripcion1", true );
		Producto pro2 = new Producto(2, "Prod22", 22, "descripcion2", false );
		Domicilio dom = new Domicilio(1, "calle", 45, "localidad3", "provincia3");
		ObraSocial obraSocial = new ObraSocial(3, "OSDE.210");
		Empleado emp = new Empleado(3, 22222222 , "María", "Palo", "233-111", dom, 0, null,"cuil" ,2 ,false );
		Cliente cliente = new Cliente(4, 44444444 , "Juan", "Gomés", "444-111", dom, 5, obraSocial, 22  );
		List<Item> items = new ArrayList<Item>();
				items.add(new Item(pro1, 8, 3));
				items.add(new Item(pro2, 5, 5));		
		Venta venta = new Venta(3, LocalDate.now(), 255, "Pago credito", emp, emp, cliente, items);
		List<Venta> ventas = new ArrayList<Venta>();
		ventas.add(venta);
		
		Sucursal sucursal = new Sucursal(1, dom, ventas);
		
		sucursalCollection.insertOne(sucursal); // INSERTAR UN Documento BSON
		
		
		//Traer lista de colecciones en una base de datos
//		for (String nombreColeccion: baseDeDatos.listCollectionNames() ) {
//			System.out.println(nombreColeccion);
//		}			

		//collection.find(and(gt("precio", 1), lte("precio", 6))).forEach(doc -> System.out.println(((Document) doc).toJson()));
		
//		Document producto = new Document("nombre", "salsa" ) //CREAR un Documento BSON
//										.append("precio", 20)
//										.append("descipcion", "refinada")
//										.append("proveedor", new Document("nombre", "Ditribuidora1")
//												.append("direccion", "Direccion1234"));
		
		
//		System.out.println(producto.toJson()); // Imprimir un BSON en formato JSON
//		System.out.println(producto.get("nombre"));// Imprimir un atributo del BSON		
//		collection.updateOne(eq("nombre", "yerbaModificada") , set("nombre", "yerbaModificada111")); //ACTUALIZAR un BSON en una colleccion
		//collection.deleteOne(eq("activo", true));
	}
}