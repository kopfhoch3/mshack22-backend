package de.kopf3.mshack22backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "de.kopf3.mshack22backend.persitence.repository")
public class MongoConfig {
    
}
