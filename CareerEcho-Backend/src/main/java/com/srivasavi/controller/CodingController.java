package com.srivasavi.controller;

import com.srivasavi.model.CodingQuestion;
import com.srivasavi.repository.CodingQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin
public class CodingController {

    @Autowired
    private CodingQuestionRepository repository;

    @GetMapping
    public List<CodingQuestion> getQuestions(@RequestParam(required = false) String level) {
        if (level == null || level.equalsIgnoreCase("all")) {
            return repository.findAll();
        } else {
            return repository.findByLevelIgnoreCase(level);
        }
    }
}
