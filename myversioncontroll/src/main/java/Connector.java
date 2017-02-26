/**
 * Created by andre_000 on 24/02/2017.
 */

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Connector {

    MongoClient client = new MongoClient("0.0.0.0", 27017); //connect to mongodb
    Datastore datastore = new Morphia().createDatastore(client, "DocumentVersionControl"); //select Database

    public String addUser(User user){
        datastore.save(user);
        return "User Added";
    }

    public String addDocument(Document document){
        datastore.save(document);
        return "Document Added";
    }

    public List<User> getAllUsers(){
        List<User> list = datastore.find(User.class).asList();
        if(list !=null) {
            return list;
        }
        return null;
    }

    public List<Document> getAllDocuments(){
        List<Document> list = datastore.find(Document.class).asList();
        if(list !=null){
            return list;
        }
        return null;
    }
}
