package de.iav.backend.repository;

import de.iav.backend.model.Bag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BagRepository extends MongoRepository <Bag, String>{

    Optional<Bag> findByType(String type);
    Optional<Bag> findById(String id);
}
