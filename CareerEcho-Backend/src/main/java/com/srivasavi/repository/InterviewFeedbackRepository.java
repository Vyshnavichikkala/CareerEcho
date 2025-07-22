package com.srivasavi.repository;

import com.srivasavi.model.InterviewFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InterviewFeedbackRepository extends MongoRepository<InterviewFeedback, String> {

    List<InterviewFeedback> findByCompanyIgnoreCase(String company);

    List<InterviewFeedback> findByCompanyIgnoreCaseAndRoleIgnoreCase(String company, String role);

    List<InterviewFeedback> findByCompanyIgnoreCaseAndNumberOfRounds(String company, int numberOfRounds);

    List<InterviewFeedback> findByCompanyIgnoreCaseAndRoleIgnoreCaseAndNumberOfRounds(String company, String role, int numberOfRounds);
}
