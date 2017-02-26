/**
 * Created by andre_000 on 24/02/2017.
 */

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;


public class Api {

    public static Connector connector = new Connector();

    public static void main(String[] args){

        Gson gson = new Gson();
        post("/add/user", (req, res) -> {
            res.type("application/json");
            User user = gson.fromJson(req.body(), User.class);
            return connector.addUser(user);
        }, gson ::toJson);

        get("/list/users", (req, res) -> {
            res.type("application/json");
            return connector.getAllUsers();
        }, gson ::toJson);

        post("/add/document", (req, res) ->{
            res.type("application/json");
            Document document = gson.fromJson(req.body(), Document.class);
            return connector.addDocument(document);
        }, gson ::toJson);

        get("/list/documents", (req, res) -> {
            res.type("application/json");
            return connector.getAllDocuments();
        }, gson ::toJson);



        get("/hello", (req, res) -> "Hello World");
    }
}