package com.srivasavi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "interviewDB")
public class InterviewFeedback {

    @Id
    private String id;

    private String company;
    private String role;
    private String jobDescription;
    private int numberOfRounds;
    private List<RoundDetail> roundDetails;

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public List<RoundDetail> getRoundDetails() {
        return roundDetails;
    }

    public void setRoundDetails(List<RoundDetail> roundDetails) {
        this.roundDetails = roundDetails;
    }
}
