package de.kopf3.mshack22backend.persistence.document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@Document
public class User {
    
    @MongoId
    @JsonIgnore
    private ObjectId id;

    @JsonSetter("id")
    public void setId(String id){
        this.id = new ObjectId(id);
    }
    @JsonGetter("id")
    public String getId(){
        return this.id==null?null:this.id.toHexString();
    }
    
    private UUID deviceId;
    
    private String nickname;
}
