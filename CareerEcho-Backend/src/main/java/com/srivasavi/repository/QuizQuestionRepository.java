package com.srivasavi.repository;

import com.srivasavi.model.QuizQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizQuestionRepository extends MongoRepository<QuizQuestion, String> {
}
