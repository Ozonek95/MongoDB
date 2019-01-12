import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class ShopApp {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(
                new ServerAddress("localhost", 27017),
                MongoCredential.createCredential("javakrk", "library", "javakrk".toCharArray()),
                MongoClientOptions.builder().build()
        );

        mongoClient.close();
    }

}
