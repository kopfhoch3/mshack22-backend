package de.kopf3.mshack22backend.persistence.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@Document
public class Image {
    
    @MongoId
    private Long id;

    private String url;

    
    private boolean isPrimary;
}
