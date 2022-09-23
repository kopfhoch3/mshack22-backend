package de.kopf3.mshack22backend.entities;

import de.kopf3.mshack22backend.persistence.document.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.ZonedDateTime;

@Data
@Document
public class Action {
    
    @MongoId
    private ObjectId id;

    private User user;


    private ObjectId point;
    
    private String type;
    private ZonedDateTime timestamp;
    private String message;
}
