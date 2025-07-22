package com.srivasavi.controller;

import com.srivasavi.model.AptitudeTopic;
import com.srivasavi.repository.AptitudeTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aptitude")
@CrossOrigin(origins = "*")
public class AptitudeController {

    @Autowired
    private AptitudeTopicRepository repository;

    @GetMapping("/topics")
    public List<AptitudeTopic> getAllTopics() {
        return repository.findAll();
    }

    @GetMapping("/topic")
    public AptitudeTopic getTopicByName(@RequestParam String name) {
        return repository.findByNameIgnoreCase(name);
    }

    @PostMapping("/add")
    public String addTopic(@RequestBody AptitudeTopic topic) {
        repository.save(topic);
        return "Topic added successfully!";
    }
}
