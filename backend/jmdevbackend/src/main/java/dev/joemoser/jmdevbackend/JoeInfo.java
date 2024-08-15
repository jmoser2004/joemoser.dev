package dev.joemoser.jmdevbackend;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Document(collection = "JoeInfo")
public class JoeInfo {
    @Id
    private ObjectId id;
    private String infoType;
    private String[] infoPieces;

    public JoeInfo()//default constructor
    {
        this.id = new ObjectId();
        this.infoType = "default";
        String[] defaultArray = {"Default"};
        this.infoPieces = defaultArray;
    }

    public JoeInfo(ObjectId id, String infoType, String[] infoPieces)
    {
        this.id = id;
        this.infoType = infoType;
        this.infoPieces = infoPieces;
    }

    public ObjectId getId(){return this.id;}
    public String getInfoType(){return this.infoType;}
    public String[] getInfoPieces(){return this.infoPieces;}

    public void setId(ObjectId id){this.id = id;}
    public void setInfoType(String infoType){this.infoType = infoType;}
    public void setInfoPieces(String[] infoPieces){this.infoPieces = infoPieces;}
}
