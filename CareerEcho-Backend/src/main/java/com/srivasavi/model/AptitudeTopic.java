package com.srivasavi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "aptitude_topics")
public class AptitudeTopic {
    @Id
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTheory() {
		return theory;
	}
	public void setTheory(String theory) {
		this.theory = theory;
	}
	public List<AptitudeQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<AptitudeQuestion> questions) {
		this.questions = questions;
	}
	private String name;
    private String theory;
    private List<AptitudeQuestion> questions;

 
}
