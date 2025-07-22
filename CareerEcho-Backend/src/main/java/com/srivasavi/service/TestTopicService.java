package com.srivasavi.service;

import com.srivasavi.model.TestTopic;
import com.srivasavi.repository.TestTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTopicService {
    @Autowired
    private TestTopicRepository repo;

    public TestTopic getTestByTopic(String topic) {
        return repo.findByTopic(topic);
    }

    public TestTopic saveTestTopic(TestTopic topic) {
        return repo.save(topic);
    }
}
