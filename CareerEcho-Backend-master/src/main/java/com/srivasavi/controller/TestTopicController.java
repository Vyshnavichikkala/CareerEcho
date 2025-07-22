package com.srivasavi.controller;

import com.srivasavi.model.TestTopic;
import com.srivasavi.service.TestTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class TestTopicController {
    @Autowired
    private TestTopicService service;

    @GetMapping("/{topic}")
    public TestTopic getTestByTopic(@PathVariable String topic) {
        return service.getTestByTopic(topic);
    }

    @PostMapping("/add")
    public TestTopic addTestTopic(@RequestBody TestTopic topic) {
        return service.saveTestTopic(topic);
    }
}
