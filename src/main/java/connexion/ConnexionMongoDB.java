package connexion;

import com.mongodb.MongoClient;

public class ConnexionMongoDB {	
	
	private static MongoClient mongoClient;
	
	public static MongoClient getMongoClient() {
		if (mongoClient == null) {						
			mongoClient = new MongoClient("localhost", 27017);			
		}		
		return mongoClient;
	}
	
	

}
