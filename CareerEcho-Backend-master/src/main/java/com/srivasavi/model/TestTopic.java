package com.srivasavi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "aptitude_tests")
public class TestTopic {
    @Id
    private String id;
    private String topic;
    private List<TestQuestion> questions;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }
    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }
}
