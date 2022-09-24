package de.kopf3.mshack22backend.persistence.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Data
public class Action {
    


    private String message;
    private List<Image> images = Collections.emptyList();
    private List<String> usersLiking = Collections.emptyList();
    private List<String> usersDisliking = Collections.emptyList();
    private Date timestamp;
    private String type;
}
