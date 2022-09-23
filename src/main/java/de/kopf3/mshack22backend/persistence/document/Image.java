package de.kopf3.mshack22backend.persistence.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
public class Image {
    

    private String url;

    
    private boolean isPrimary;
}
