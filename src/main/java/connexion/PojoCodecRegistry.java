package connexion;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;

public class PojoCodecRegistry {
	
	private static CodecRegistry pojoCodecRegistry;
	
	public static CodecRegistry getPojoCodecRegistry() {
		if(pojoCodecRegistry == null) {
			pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		}		
		return pojoCodecRegistry;
	}

}
