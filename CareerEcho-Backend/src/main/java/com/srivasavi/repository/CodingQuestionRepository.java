package com.srivasavi.repository;

import com.srivasavi.model.CodingQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CodingQuestionRepository extends MongoRepository<CodingQuestion, String> {
    List<CodingQuestion> findByLevelIgnoreCase(String level);
}
