package connexion;

import com.mongodb.MongoClient;

public class ConnexionMongoDB {	
	
	private static MongoClient mongoClient;
	
	public static MongoClient getMongoClient() {
		if (mongoClient == null) {			
			//Conexión al Server de MongoDB pasandole el host y el puerto
			mongoClient = new MongoClient("localhost", 27017);			
		}		
		return mongoClient;
	}
	
	

}
