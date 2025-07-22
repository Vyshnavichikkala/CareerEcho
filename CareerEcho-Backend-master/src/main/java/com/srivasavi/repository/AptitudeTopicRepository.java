package com.srivasavi.repository;

import com.srivasavi.model.AptitudeTopic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AptitudeTopicRepository extends MongoRepository<AptitudeTopic, String> {
    AptitudeTopic findByNameIgnoreCase(String name);
}
