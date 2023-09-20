package de.iav.backend.repository;

import de.iav.backend.model.Bag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends MongoRepository <Bag, String>{
}
