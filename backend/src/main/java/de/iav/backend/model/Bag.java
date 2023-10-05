package de.iav.backend.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection= "bag")
public record Bag (
    @MongoId
    String id,
    String type,
    String price,
    String brand
){
}
