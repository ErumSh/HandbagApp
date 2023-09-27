package de.iav.backend.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection= "users")
public record Bag (
    @MongoId
    String id,
    String type,
    int price,
    String brand
){
}
