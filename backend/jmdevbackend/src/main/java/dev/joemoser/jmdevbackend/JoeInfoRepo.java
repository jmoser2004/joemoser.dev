package dev.joemoser.jmdevbackend;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoeInfoRepo extends MongoRepository<JoeInfo, ObjectId>{
    
}
