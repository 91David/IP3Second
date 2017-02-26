/**
 * Created by andre_000 on 24/02/2017.
 */

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Document {

    @Id
    private ObjectId id;
    private String title;
    private int revisionNumber;
    private String documentAuthor;
    private Date creationDate;
    private Boolean draft;
    private Boolean active;
    private Boolean archived;
    private String documentStatus;
    private ArrayList<User> distributees;
    private Date activationDate;

    public Document(ObjectId id, String title, int revisionNumber,
    String documentAuthor, Date creationDate, Boolean active, String documentStatus, Date activationDate, Boolean archived){
        this.id = id;
        this.title = title;
        this.revisionNumber = revisionNumber;
        this.documentAuthor = documentAuthor;
        this.creationDate = creationDate;
        this.active = true;
        this.archived = false;
        this.documentStatus = documentStatus;
        activationDate = null;
        ArrayList<User> distributees = new ArrayList<User>();
    }

    public ObjectId getId() {
        return id;
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getRevisionNumber(){
        return revisionNumber;
    }

    /*Else inform user he has no permition for that Where there is a currently active document revision, the currently active
    revision will be archived and given the status of ‘Archived’. Archived
    documents will be read only.*/

    public void setRevisionNumber(int revisionNumber){
        if (active = true)
        this.revisionNumber = revisionNumber;
    }

    public String getDocumentAuthor(){
        return documentAuthor;
    }

    public void setDocumentAuthor(String documentAuthor){
        this.documentAuthor = documentAuthor;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public Boolean draft(){
        return draft;
    }

    public void setDraft(Boolean draft){
        this.draft = true;
    }

    public Boolean active(){
        return active;
    }

    public void setActive(Boolean active){
        this.active = true;
    }
    public String getDocumentStatus() {
        if (draft = true) {
            this.documentStatus = "The Document is currently in Draft mode";
            return documentStatus;
        } else {
            this.documentStatus = "The Document is currently Active";
            return documentStatus;

        }
    }

    public ArrayList<User> getDistributees(){
        return distributees;
    }

    //add user allso check if user is already in
    //is the array list best option ? can you save hash map into a database ???
    /*public ArrayList<User> addDistrubetees(){
        distributees.add(User);
    }*/
/*
    public ArrayList<User> removeDistributees(){}*/


//Add Activation date !
    public String activateDocument(){
        if (active = true) {
            return  ("The document is already active");
        }
        else  {
            this.draft = false;
            this.active = true;
            return("The document has been activated!");

        }

    }

    //create attachments etc etc with void
    public String removeAttachments(){
        if (active = false)
            return("The attachment has been removed");
        else
            return ("You have no permission to remove attachements when it's activated!");
    }

    public String addAttachments(){
        if (active = false)
            return("The attachment has been successfully added!!");

        else
            return ("You have no permission to remove attachements when it's activated!");
    }



}
