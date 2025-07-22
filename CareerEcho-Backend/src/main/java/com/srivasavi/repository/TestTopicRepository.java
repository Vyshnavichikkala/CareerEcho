package com.srivasavi.repository;

import com.srivasavi.model.TestTopic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestTopicRepository extends MongoRepository<TestTopic, String> {
    TestTopic findByTopic(String topic);
}
