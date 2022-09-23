package de.kopf3.mshack22backend.persistence.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@Document
public class User {
    
    @MongoId
    private Long id;
    
    private UUID deviceId;
    
    private String nickname;
}
