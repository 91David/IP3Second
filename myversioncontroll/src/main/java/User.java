/**
 * Created by andre_000 on 24/02/2017.
 */

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User extends Connector {

    @Id
    private ObjectId id;
    private String forename;
    private String password;
    private String surname;
    private String username;
    private String role;

    public User(ObjectId id, String forename, String password, String surname, String username, String role) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public ObjectId getId() {
        return id;
    }

    /* Not sure if we need a seter for id
    private void setId(ObjectId id){
        this.id = id;
    }
    */

    /**
     * Hashes passwords using jBCrypt.
     * (Note: Do not modify gensalt beyond 30.)
     *
     * @param password The user's password.
     * @return The hashed password.
     */
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    /**
     * Check that an unencrypted password matches one that has previously been hashed.
     * (It should NOT reveal the password, only verify whether the hashed matches the plain.)
     *
     * @param password       The user's password.
     * @param hashedPassword The hashed password.
     * @return Boolean verifying whether password matches.
     */
    public static Boolean verifyPassword(String password, String hashedPassword) {
        System.out.println(BCrypt.checkpw(password, hashedPassword));
        return BCrypt.checkpw(password, hashedPassword);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }


    /* make it private for admin only ? ? */

    public void setUsername(String username) {

        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
/*
//Define Roles
    public String addDocument(Document document){
       if(this.role = Author){
        datastore.save(document);
        return "Document Added";}
        else
            return "You acannot add a document if you are not an Author!";
    }

}
*/
